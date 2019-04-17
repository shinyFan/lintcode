package com.yuantu.faceUtils;

import com.yuantu.request.UserRequest;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JINZONGFAN on 2019/4/17 14:17
 */
public class StrToObjectUtil {
    public static void main(String[] args) throws InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException, UnsupportedEncodingException {
        String body="idNo=410803199605250038&name=%E9%9D%B3%E5%AE%97%E5%B8%86&cardNo=410803199605250038&cardType=%E8%BA%AB%E4%BB%BD%E8%AF%81&phone=13083687245&extend=%E5%A4%87%E6%B3%A8&image=%2F9j%2F4AAQSkZJRgABAQEAYABgAAD%2F2wBDAAwICQoJBwwKCQoNDAwOER0TERAQESMZGxUdKiUsKykl%0AKCguNEI4LjE%2FMigoOk46P0RHSktKLTdRV1FIVkJJSkf%2F2wBDAQwNDREPESITEyJHMCgwR0dHR0dH%0AR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0f%2FwAARCADRATkDASIA%0AAhEBAxEB%2F8QAHAABAAIDAQEBAAAAAAAAAAAAAgEDAAQFBgcI%2F8QAQBABAAIBAwIEAggEAwYGAwAA%0AAQACEQMEITFBBRJRYXGBBhMikaGxwfAUMnLRByMzFTRCc7LxFiU1NkPhUoLC%2F8QAGQEBAAMBAQAA%0AAAAAAAAAAAAAAAECBAMF%2F8QAIhEBAQACAgICAwEBAAAAAAAAAAECEQMxEiEyQRMiUQQz%2F9oADAMB%0AAAIRAxEAPwD1lSIIQjICCMISMIEhGEgIggIIghCMIEhEEwIggYEQTAiCBgRBMCcnxzxjS2Hh9tTT%0A1Dzr5RMOHHT2fTPcgdHc7rb7TTNTc6tdKqgNnuuCcfefTHwXZanl1txZyPNaKCOEfRnzTx36U73x%0AHSroa1g8jxYyORX16c%2FvE4NtypdsZVPtOXqj19fj7yNj6J4n%2FidSoHh2yy5y21XInsGOs4tv8SvH%0AG%2FmqbatEwBp55x16%2BvOJ5FxavnM%2FZQyYwPue5%2BUra4pZtjhMZ75z0%2FFgewP8SPG7bbUpe2l5rD5d%0AStCrV6iHR9Oe01%2F%2FAB%2F475ed1m%2BfMWKnAnJjp8PTmeSVTHYc8SKr6hl69yB7PQ%2FxF8bpoVpbV072%0AFW9tMVMcHy%2B%2Fiel8A%2FxD0Nze1PFym3FqVtUcGeq%2B35HxnynCcnNXj3kVsmAXD27wP0L4f4tsPEh%2F%0AgtzTVRRBw8PXHpxNvE%2FPW332voudHVvpuVWqi5957n6I%2FTl2tDa%2BKNtTSXJqZy1zlw%2BpnEbH0pIU%0Aley3mhv9rXcbbUL0t0RzLUkgJCkaQpArSFJYkCQAkCRpCwK0hY0gYFaQpHaBIASBljBaBWkMbDiB%0AukZCRkBEZARkBEZCRkBEQQkZARJCQRkCQiCQRdDOFxzgMrA5P0l8Sr4Z4XbVbNXPDVwnwezlP3mf%0AI%2FFPGNxuLa1TcXtpXearkecjzznOO%2Faeg%2Bmv0i%2FjNzq7U0itKWTCZXHAomRwvE8NqKuCrIAtqLZD%0ALnqZWZVtVWt0yAmMieif3hKKemZbpaYmUxz64fhjvAzR83OGoeg4H%2BzDdHFbFq56L2%2BXRlttMtbF%0AVMdiuXHygKgNVce5IA%2BpVTiuOiWyPz6ffiRfTaOLCW7mOJb5QMVcLxhyfPiYaNuKomegd42nSil2%0AluKCPCIOZFwctRr7HR%2BE3K7Rxn7J7D%2Bkn%2BD1EyCnwzG4nxrTRMPCJ1%2BUsLqouDhXHb9sTt7UUw88%0APovp8ZX5GphOEwvfJz%2FaNos073gH0j3vhOrWuhrtdK2oWvVcgHt8Py959g8M8S2vim2rrbXULCDa%0Auear2SfA2rTGMvTCdvb4z030M%2Bkr4LufLcbaWtcrapwAv8z64zgPi88SUPsCQpJrat6lqo1TIncm%0AMkBgY2FgVsLGwMAMDGwWgBgtLGV2gBgtLLSu0AMiJhgblZYQEdYCrLKwEZARGQVjIDIiEiIDIiEi%0AICJw%2FplvXaeBahXUdK90KWMnJ7nJO6TwP%2BJe5sX0tCupqc1yUP5XuvHPpA%2Be6976%2Bu31LF1cr3fV%0AfV92bG28J1tevnapW3YO3aX%2BEbB3e9NJDy0M6mDtnp9%2F5M9nTb10dMKgerjvOOeevTRxcfl7rymj%0A9HNSx9r7K9nkx%2FeN%2BjWuuRMHuv4cfnPW00jOcZe7LfLg6HPtOX5K7%2FixeJfANxRwW8we2M%2FJ6%2FfL%0AtH6P6tubGB9TmeudMe3zxJKYCReSpnDi87o%2FR3SrgsZe72m%2FpeCbWlf5M9uZ1fKYcGZGHuY%2BEpcr%0AXSYSOb%2Fsvb0riulU9GD%2FAGdpeb7WmWwcZOJ1mqi9cENtNcY%2BUrup1Hnd74cWp5aaZgcoGMfOcLX8%0AMsaic%2BYcmPj6T3VtNVyHPtOL4vo209xV0wF7vGfUzOmGdl05cnHLHkN3pWrqOOnmcCc%2Bn6TWP8rU%0ArbKuRycf9p3txp11Krahk5yGB%2B%2FpOXr6a2GomeRf0mqVhymn0b%2FDzx019F8L17ttWmbaa%2Bnp74%2Fv%0Ame1Z8d%2BhG8%2FgfpDo3UfrFo5HKPDwZfz%2FALfYmXioMLGwMAMLEwsAMrtLLQMAMrtLGBgC0DHaBgBh%0AiYYG5WWEBGQGRkBEQGRkBGQGREBGQGREBGQET5b9OtZ1vpDuXNvLp1KGTAPHbvlevf8AP6kdp8p%2B%0AkWb%2BM7u%2Bo%2BZvq2wDyGUH2Azz8cd0ipjZ%2Bje28mxtuLAW1rtsvocB%2Bc7RXKd%2FjNXw%2FTNLYaOmcYqd%0AsTdoc%2B0x5e69DCaxh1oYO%2FtM8vPJFUy4iT3JGloqaZHiZ5fYMRo9nOe0h4OvWRUincCEojle8nOB%0A5H5QtuoYcSq0MMvH4ywqY9ZVVceue8dBsGXn3iIo3qZyh8Zw%2FpAroZqL5XOD8z7p6G9FqiDknD8W%0ApatMB0TgOv75l52pl04XmdXFBzzjOevHGJp7ulK1Wq34crw%2FdN%2Bmj5S7iyK8Y6ev4cnwg3OnbWpb%0AUzVcparj25PXM7y%2B2XLH00Po%2FqaG38c21955q6BqHma5Grnh45%2BP6z7SI1GrmqCPqT4eabpbmttT%0ATErYUynR6Z%2BE%2B3aNzU0NPUMYtUsYROQe2T7p2jheyYGJhZKAYWJgYBZXaNgtANoGNldoBtAx2gYA%0AYYrQwNwjICKsCwjJWRjAsIiAYhgWEQwDGMBDGMAxDAY8z5x45oL4vr1xU82tbIHQznK914%2FCfRhn%0AifFtv%2F53qad9TzXvqW1ExyV4xn9%2FrK5dLYzdjNuf5dTHQJt1MUECUcUrzxgl2lqVa5UA9Zkk3W%2B3%0ARAkQrJ%2Bs0%2BcXq8esktREyZk6JlFeH7u8yxl64lnCZEkNgBU5kaW2r8menf0k%2FVnVzBqbnTpkyGOe%0As19XxPTpVQEyHU%2FWPBFzjc%2Br%2B1iWVqienpNLS8Q09QEzl6Yfwm3p6nnqWxmr%2BEeKvmscYwzQ3%2Bha%0A5xh4zj4TebGcL05g1EcY6pIW7edvtjNfLmvm6j2eOvtkPvnP19G1fNRc2RwJjDnknot5oYqtRwOU%0AOoepOPuNO38ScjyYcvOTp%2BR85fG7rlnNOHcHUrVqp5gc5zVycdeTD%2BU%2Bx6dK6WlXToBWoAHQAnyf%0Ac6NTc1aWUsiL1HI8e4%2FnPrNV8lcuXBl9eJpx6ZMu0LCxLAssqhgYmBYBYGJgWAWBjWC0AMFo2C0A%0AMiSwwNyrEMAxjAsGIZWMYwLBjGVjEMCwYhlYxjAYxjAMQwGM8t4zpNfpT9Y8l9sY%2BThx%2B%2FSeoGcD%0A6QUP9rbPUE8zo6lcew1c%2FjK5%2FFfj%2BTka6tnzWxQ%2FGa9tvuNdPqTFe%2BeBnRtpVtcU5HvKLeK0pvP4%0ALZ6Ntzucc1ogVPdeD8WZ5f41Wf1ram23Gm5dRe3GeJNNfVonmWcnxD6U7vb7%2Bu2dloZtZqLrPOLN%0AXLjjkevbD3mxpeKae8Atp20dThtSyOB6InCe8ZeU7MfG3Udvb6zczyj0kbrzNVDL6R7Cg1BMcZ%2BM%0Av1tEdBzjnuSlrrI4%2FwBVfUtgyr19pZTwytx8%2FOOZXbc22231W1cNFH3c8HzlO42e5v4Rud%2Fvd3ra%0ATSuaaelXLXjLnhxjJwHrl4lsZclMrMY6ej4bSr9jnH4zZpTU0ByKdk%2FtPnvge58Q192add9raeq6%0Ahhs%2BahXCtnuAlfve%2BJ63Y%2BKb0Cu%2B01Bx50cPolscj7h8ZNlxVxvn9OxR82VcYOkjDnkxDXVrYLVT%0A3My%2BoNcmPl2nO3brj6a2oHOXhOZ5zfXKUuHKKHOMpyHzHj4E9Peorn7p5TxyrTXuHBZyhx1MScO1%0AeSelG20b7rxHaaVc28%2BrQVFwqfp%2BXtPqb3nhPBPAnTvob7U1r1vSv2SlsGUwc9cgp851Hf6uw8V0%0AdK2mGlqOG2VV9zpO85JHD8GWXt6RYViWBZ2ZkLAslYVgFYWJZWsArCsSwLAKwWYlgWAVhkrIgbdW%0AIZWMsGBYMQysYhgWDGMrGMYFgxDKxiGBYMQysYhgWDPOeO6ln6RbPTRK10b4eyuH9J6EZyPHtAtr%0A7LcHWmo0fcR%2FWUz6dOLXk0LVbUSrjjGfSaWx2FdprW1NDUdO7ltZw%2BZeuczpFc178yp062y3F%2Bcz%0AT026cHxXwTZa29vutSq6l3NilsFnu45Re%2BElJtl3Nbaen5cFa49ahgMemJ6F0ajjTpU98SNPbV07%0AeexmyYPQk27JJOi2FXSpWtnLWuMs27ZtTAOPaU0ri2DGJsZAxmc6vHG3eiV3fm1KVvSyWBOBDGf3%0A6yLUs1Qr9lMYrwY9ydTX0aalGtsYeR9Jq6WmFscuO8mUa%2B00dHbOa7ewvpUx%2BE3hNTlMZOicYltK%0ApgxLa0F4MvrCFOnp1HAYenTtLkCpgxiMpnqBI1DBghDW1HPHynD3u1%2FifGNvpWxajZyJkcCmZ27c%0ALjmae3oaniurdOdOgVPdyfrIlTlNzTr7bSzWjo4rSqYMcPH%2FAGnP8ZrjdbQQbfXh%2BE0dprbvw%2FxL%0AU0t3qWS1m1V6WHpj0x0x2nU3lP4vxXZAPlR1bY7cYPxZM9rSeN27mePlCsxYVm55TFgWSsKwCsKy%0AVgWAVhWJYFgFYFiWBYELDmYsiBtjEMrGIYFgxjKxjGBYMQysYhgWDEMrGIYFgxZlYxDAsGaviek6%0A20ydaWrc%2BTz%2BE2BkoWq1eiYZFm5pbG6sri1wGJXqBzl%2B6LUGmpaq%2FwAtkflK9S%2BDPXjEy6b5VYo4%0AO0VrAiJNPc6%2FkFHp3l2zo2oWvkyiEhLd0qYMvwjvQK%2BZXD2kF9M0MD9tUcxOpo%2FUlbKIvTmTola9%0AtUxYMZxwvITS2%2B5q69qXPLYcI9p0fLotc1sWz6HM4e6ou6traHWrh98cMqvHdqicS2uUDpzmc3Zb%0An6ynok3TU68mYVbGcPtKtRyccyPPnq9urIUZFRFNubZwyk8u31dbXtYqeUMrwcvP4za8uOvGYa1q%0A2%2B0DV6iZy9pESo8RNTfauzNPSsmct0x9%2Fuzp7PTq7i2sYfLU06vsdfxhNM1gqqZcPwJuVrWlStTA%0ATvx47u3Hmz1PGJWBZKwrNDEhYVmLCsDFgWSsKwCsKzFhWBCwLEsCwIWHMxZGYGyMYyoYxgWjEMrG%0AIYFgxDKxiGBYMQysYhgWDFmVjFmA8xDK8xZgcjeibvVcYVyTU1bKY%2FZOl4lVdWtjon5M0NSmTI9Z%0Alymq3YXeMaVNA1darqP2Bzj1SbW60662hbTbXpkx5qWwnzlJxfA4xLMVaq2qB1V4kRNt21NPb7jT%0A0vq7bu2pj%2BW1uXHovf4wW0tTc6TpaylcYcOcvv7Tcrq6F21aatfOnHp%2FaYVro%2Fb1tQqdcZ5%2BUleS%0AtTZ%2BHbfZK6d9Q83WpZK%2FccTbvWpRK1wBx7Q%2Fxmyzl1LHukzX3ezro21Dc6eKmXNg6fGQizKKqmL5%0AOF9OjNzSu24XKdSaOx3WhvKGpo2LGepN%2FSqjnv8AnKUl22K5Tr98dauEgqoZ7yyqBISywFX8Jq7p%0Aa7e9qqNRsYcchkm2p0mvrg4q93D8JMiLXQ2BnaaWrZW16FnjGMg4xL1mcBgADgDtCs2ya6efbbd1%0AiwrMWFZKGLAslYFgYsKzFhWBCwLEsCwIWFZiwrAKzMzFhzA2RjGVDGMCwYhlYxDAsGIZWMQwLBiG%0AVjEMB5izK8xDAsGTmDMzMAbyjfQU61c%2FLvOYnUfnOxkTD3nL3Om6WpgHDyPtOPJj9tHDn9NbUoK4%0A7k4%2B58GNdvjW1qq58tdRB9XB3nazl5V%2BExqZyGEnGVpjz2l4RqUWtdbWp3za2SO3hWq%2FzbrVx7Y5%0A%2BeJ29QLZElH1eHJz7S23SZ6%2BnNr4Ho6iOo31U4G91xL9P6PbSrm%2BhpoGSuM5%2B%2BdPTE6BnvmXYzy9%0AH1kWouTn7XZae1qmjUoHYOJvjgxzzMsGHASvPHrKWqrc4cxluD9ZTW2erF5gwr0kQWNueXpNfVsj%0AnJg5%2B6Is3v5a%2FFZXqphDtxFqO3b8wgnRMyFnm%2FD934g7%2FWpXXtq6NLgVtXIDhAfYnoVm6XceflNX%0ASVhWYsCyUJWBZiwrAxYVmLCsDFgWSsKwIWBZKwLAxZGZCyIGwMYyoYxgWDEMrGIYFgxDKxk5gWjJ%0AzKxiGBYMWZXmTmBZmSMrGTmBZmDW0662n5bOHs%2BjMGTmL7J6cq9L6Wr5dQx6J0T2mK5Ok6erSurR%0Arc%2BD3H1JzNWltC%2FlufZeljozPlhrpqw5d%2BqjyluBFzI%2BrM4z8pBqg44BIm%2BQQPjKO0p0qCIZjsIP%0APuHrKDUBMh8jiZbXy446ytidk5xhZFkxzNe%2B4C2MnHWUau8rXI2M%2FiyurTba8%2BDIdIS9tSxWuXLi%0Aa2la%2BtbHIZ6d3%2BxOtsdtax%2FkVHs3eKnwe%2FylscbbrFW5STdZXTroaL5seZOV7e0qvtrNS%2Bs2pS38%0AtQ%2B3f4HY937p0db6rZAp9duUzUscHvjsfizS81r3dTUs2unK%2Fp%2FaaceCY%2B8u2fLnt%2BKza6VdEq10%0A61wYrUylfv5V7ryzasuBe8opZ7enbtL8Lp89es6uAZkLDmQsgSsKyFhWBiwrMWFYGLCsxYVgYsCy%0AVgWBCyJiyMwLxiGVjEMCwYhlYxDAsGIZWMWYFgxZlWZOYFuZIysYswLMzMyvMWYFmZgyvMWYDzDq%0AUrqUaXC1XqMgYb3NPTtqW6VMsdji7vQ19DUsUHUoPGOs1v4xopetq47IiTo7bcO4072vjzmpaqen%0ARD7nEepWrVUfuma%2Brpsx6cp3%2FmcAuegENtfUsfZqnxmxfylucHxf0gbFrFNOre70rUzn5SvfUS0d%0AV17KFmp3x1%2B%2FtM2mjra2sae303U1HhRzj3V4J29r4Fr7hL7x%2Brp18lXn5vad3a7TQ2mn5NHTrWp6%0AE0Yf58sveTjnzzH1i5%2Fh3gtdELbuxqW6%2BQ4qPv3X3fum9vd5XaaddPTqW1rH2a44D1cdj07wbvfG%0Ajb6vTPNqJlO1T1f7TlnmWy2bWXNr26v7%2B7tNNmPHNYs1tzu8jqLbNlvd5bPKv77R1c2eQ9X056yu%0AjnkcDxzhfj8f36xVPMhVQx1xz%2F3nNZfTrwrLNOwOF%2BS9Zp6u4KW8mmDdOmeA9WPbNqPmtbn1eH7p%0AA2NQ8r0cPJmBZd566lUzy8iv4yjUq0UsfB7MgQsKyMyFgYsKzFhWBiwrMWFYGLAslYVgQsjMhZGY%0AF4xDKxiGBYMQysZOYFuZOZXmTmBZmIZWMWYFmZmZXmIYFgycyvMkYFmZmYMxVFMrgOqwM1NSunp2%0A1L2K0qNrL0A5Wcvc%2BJ6W72lr7ZuVrfyDerV8yZz78dPfEs3250tXT1NquNPVq0b5ymRGz2Aer35x%0A0nG8O09Q0Nzsdavl19K%2F1pXOfMeXFseuAE9TLOuOP62%2FaN%2Fs3PC7jq6%2BlnGStgPbJ%2FaX7qu48r9V%0A9ofRD75w6bv%2BC8W0L3cUuunZeOHo%2FeE9P5jT27r%2BUsjio9DGMvvjJiZPC5Z6jV5zHHdcbT0TT16v%0AiOt9UJnyV%2B1dOuQM4Mc5e3TM9js9ntNrpDt61SwPnOWwmRz3J883Wpc3WpqWsDaytnKr%2Baz1f0R3%0Attx4VfQtbLt7eWq%2F%2FimQ%2BXJ8MTdhxY4T0yZ8mWfbvWt6cTn7zfJa2ht7HnP57vJT2PW3t26sHiO9%0Aart9tZrdP8zUDJpj2PW2O3bq9ic%2BhWoadTFA9crnlV65zzl6%2FhJyy10rIlanA4OXPKrzlXqq9%2F8A%0A6kliy5MCZ47%2FAKfv5GFR%2Fmw1Pw4%2FLp%2B%2Blevr10a5TzWTAHr6Pz%2FeevBdbqXrp1zbj0%2FfxlFNTU3A%0AmlZrR4b9X4Hr%2Bn4Q6O21dxY1dzkoc1r0z8fQ9vym95a1rgxWp1Xgx6%2FnxCVelp1064DLbq9V47ve%0AWVpZM2wOcmH09fhJEa2rhLByPDzjD8M5M5xnqya2LLWuXGBxxj%2B36c%2BiIZXIoHdOTL8MfHj%2FAO0l%0AhqpUqhaq4DHt1%2FKEoIln2wemMflkweiekQW8r5aoD2evdM%2Fv17kAa2m6eHqP4fGUrNqv2VF4ez6e%0A%2FwCEp1tHH2qcnp6fCRoU5kLIWFZAlYVkLIWBiwrMWFYGLDmYsjMC%2BTMmQEREyZAmImTICkzJkCSK%0AZMgZFMmQMt%2FL935y23%2BkTJktB53xL%2Fdtz%2FTpfkSw%2FwDdey%2F5dP8AoZkyduL7Uyef%2BkvWn9dfzJ7C%0An%2Fp2l%2FTb8yZMnLj%2FAOjrn8HlfE%2Bmr%2FUflO99Bv8AU3fwp%2BTMmTZemeLv%2Fh1v6r%2Fmy1%2Fmt8X%2FAKiZ%0AMmPLt1nTK%2F6dvl%2BbNC3%2B%2BH%2F6%2FlMmSIV2Lf8AF8X8obfy1%2Frp%2BbMmSQdf%2BV%2F5ep%2F%2FADLNv%2Fp2%2Frt%2B%0ATMmSEnbrT996RafU%2FpP%2BmZMgR%2FwnxP1jP7TJkDnan%2Bpb4sDMmSoLCzJkCGBmTIBZEyZA%2F9k%3D&logId=1&service=face.reg";
        UserRequest user = (UserRequest) StrToObjectUtil.strToObject(body,UserRequest.class);
        String str="asdqwafaaFAF";
        System.out.println("image".contains("image"));
        System.out.println("faceImgUrl".contains("image"));
        System.out.println("faceImgUrl".contains("Img"));

    }



    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param str 包含属性值的 字符串
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InstantiationException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
     public static Object strToObject(String str,Class type) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException, UnsupportedEncodingException {
        Map map=new HashMap();
        //将键值对切分
        String[] strings = str.split("&");
        for(String s:strings){
            //对s进行切分
            String[] keyValue = s.split("=");
            //如果是base的图片需要加=号
            String key=keyValue[0];
            //对value解码
            String value=null;
            try {
                value= URLDecoder.decode(keyValue[1],"utf-8");
            }catch (Exception e){
                value=null;
            }

//            if (key.toLowerCase().contains("img")||key.toLowerCase().contains("image")){
//                value+="=";
//            }
            map.put(key,value);
        }

        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);
                //long类型
                if(descriptor.getPropertyType().getName().contains("Long")){
                    //将string转成long类型
                    value=Long.valueOf(value.toString());

                }else if(descriptor.getPropertyType().getName().contains("Date")){
                    //将string转成long类型
                    continue;
                }
                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

}
