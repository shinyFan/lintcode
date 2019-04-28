package com.yuantu.face;

import com.yuantu.entity.User;
import com.yuantu.faceUtils.ImageToBase64;
import com.yuantu.request.UserRequest;
import com.yuantu.service.serviceInterface.UserServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JINZONGFAN on 2019/4/16 17:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    ImageToBase64 util;
    @Test
    public void add() {
        UserRequest user=new UserRequest();
        user.setIdNo("4108");
        user.setName("jzf");
        user.setCardNo("111");
        user.setCardType("test");
        user.setPhone("130");
        user.setLogId(1L);
        user.setService("face.add");
        user.setImage("/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAwICQoJBwwKCQoNDAwOER0TERAQESMZGxUdKiUsKykl\n" +
                "KCguNEI4LjE/MigoOk46P0RHSktKLTdRV1FIVkJJSkf/2wBDAQwNDREPESITEyJHMCgwR0dHR0dH\n" +
                "R0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0dHR0f/wAARCADRATkDASIA\n" +
                "AhEBAxEB/8QAHAABAAIDAQEBAAAAAAAAAAAAAgEDAAQFBgcI/8QAQBABAAIBAwIEAggEAwYGAwAA\n" +
                "AQACEQMEITFBBRJRYXGBBhMikaGxwfAUMnLRByMzFTRCc7LxFiU1NkPhUoLC/8QAGQEBAAMBAQAA\n" +
                "AAAAAAAAAAAAAAECBAMF/8QAIhEBAQACAgICAwEBAAAAAAAAAAECEQMxEiEyQRMiUQQz/9oADAMB\n" +
                "AAIRAxEAPwD1lSIIQjICCMISMIEhGEgIggIIghCMIEhEEwIggYEQTAiCBgRBMCcnxzxjS2Hh9tTT\n" +
                "1Dzr5RMOHHT2fTPcgdHc7rb7TTNTc6tdKqgNnuuCcfefTHwXZanl1txZyPNaKCOEfRnzTx36U73x\n" +
                "HSroa1g8jxYyORX16c/vE4NtypdsZVPtOXqj19fj7yNj6J4n/idSoHh2yy5y21XInsGOs4tv8SvH\n" +
                "G/mqbatEwBp55x16+vOJ5FxavnM/ZQyYwPue5+Ura4pZtjhMZ75z0/FgewP8SPG7bbUpe2l5rD5d\n" +
                "StCrV6iHR9Oe01//AB/475ed1m+fMWKnAnJjp8PTmeSVTHYc8SKr6hl69yB7PQ/xF8bpoVpbV072\n" +
                "FW9tMVMcHy+/iel8A/xD0Nze1PFym3FqVtUcGeq+35HxnynCcnNXj3kVsmAXD27wP0L4f4tsPEh/\n" +
                "gtzTVRRBw8PXHpxNvE/PW332voudHVvpuVWqi5957n6I/Tl2tDa+KNtTSXJqZy1zlw+pnEbH0pIU\n" +
                "ley3mhv9rXcbbUL0t0RzLUkgJCkaQpArSFJYkCQAkCRpCwK0hY0gYFaQpHaBIASBljBaBWkMbDiB\n" +
                "ukZCRkBEZARkBEZCRkBEQQkZARJCQRkCQiCQRdDOFxzgMrA5P0l8Sr4Z4XbVbNXPDVwnwezlP3mf\n" +
                "I/FPGNxuLa1TcXtpXearkecjzznOO/aeg+mv0i/jNzq7U0itKWTCZXHAomRwvE8NqKuCrIAtqLZD\n" +
                "LnqZWZVtVWt0yAmMieif3hKKemZbpaYmUxz64fhjvAzR83OGoeg4H+zDdHFbFq56L2+XRlttMtbF\n" +
                "VMdiuXHygKgNVce5IA+pVTiuOiWyPz6ffiRfTaOLCW7mOJb5QMVcLxhyfPiYaNuKomegd42nSil2\n" +
                "luKCPCIOZFwctRr7HR+E3K7Rxn7J7D+kn+D1EyCnwzG4nxrTRMPCJ1+UsLqouDhXHb9sTt7UUw88\n" +
                "Povp8ZX5GphOEwvfJz/aNos073gH0j3vhOrWuhrtdK2oWvVcgHt8Py959g8M8S2vim2rrbXULCDa\n" +
                "uear2SfA2rTGMvTCdvb4z030M+kr4LufLcbaWtcrapwAv8z64zgPi88SUPsCQpJrat6lqo1TIncm\n" +
                "MkBgY2FgVsLGwMAMDGwWgBgtLGV2gBgtLLSu0AMiJhgblZYQEdYCrLKwEZARGQVjIDIiEiIDIiEi\n" +
                "ICJw/plvXaeBahXUdK90KWMnJ7nJO6TwP+Je5sX0tCupqc1yUP5XuvHPpA+e6976+u31LF1cr3fV\n" +
                "fV92bG28J1tevnapW3YO3aX+EbB3e9NJDy0M6mDtnp9/5M9nTb10dMKgerjvOOeevTRxcfl7rymj\n" +
                "9HNSx9r7K9nkx/eN+jWuuRMHuv4cfnPW00jOcZe7LfLg6HPtOX5K7/ixeJfANxRwW8we2M/J6/fL\n" +
                "tH6P6tubGB9TmeudMe3zxJKYCReSpnDi87o/R3SrgsZe72m/peCbWlf5M9uZ1fKYcGZGHuY+Epcr\n" +
                "XSYSOb/svb0riulU9GD/AGdpeb7WmWwcZOJ1mqi9cENtNcY+Urup1Hnd74cWp5aaZgcoGMfOcLX8\n" +
                "Msaic+YcmPj6T3VtNVyHPtOL4vo209xV0wF7vGfUzOmGdl05cnHLHkN3pWrqOOnmcCc+n6TWP8rU\n" +
                "rbKuRycf9p3txp11Krahk5yGB+/pOXr6a2GomeRf0mqVhymn0b/Dzx019F8L17ttWmbaa+np74/v\n" +
                "me1Z8d+hG8/gfpDo3UfrFo5HKPDwZfz/ALfYmXioMLGwMAMLEwsAMrtLLQMAMrtLGBgC0DHaBgBh\n" +
                "iYYG5WWEBGQGRkBEQGRkBGQGREBGQGREBGQET5b9OtZ1vpDuXNvLp1KGTAPHbvlevf8AP6kdp8p+\n" +
                "kWb+M7u+o+Zvq2wDyGUH2Azz8cd0ipjZ+je28mxtuLAW1rtsvocB+c7RXKd/jNXw/TNLYaOmcYqd\n" +
                "sTdoc+0x5e69DCaxh1oYO/tM8vPJFUy4iT3JGloqaZHiZ5fYMRo9nOe0h4OvWRUincCEojle8nOB\n" +
                "5H5QtuoYcSq0MMvH4ywqY9ZVVceue8dBsGXn3iIo3qZyh8Zw/pAroZqL5XOD8z7p6G9FqiDknD8W\n" +
                "patMB0TgOv75l52pl04XmdXFBzzjOevHGJp7ulK1Wq34crw/dN+mj5S7iyK8Y6ev4cnwg3OnbWpb\n" +
                "UzVcparj25PXM7y+2XLH00Po/qaG38c21955q6BqHma5Grnh45+P6z7SI1GrmqCPqT4eabpbmttT\n" +
                "TErYUynR6Z+E+3aNzU0NPUMYtUsYROQe2T7p2jheyYGJhZKAYWJgYBZXaNgtANoGNldoBtAx2gYA\n" +
                "YYrQwNwjICKsCwjJWRjAsIiAYhgWEQwDGMBDGMAxDAY8z5x45oL4vr1xU82tbIHQznK914/CfRhn\n" +
                "ifFtv/53qad9TzXvqW1ExyV4xn9/rK5dLYzdjNuf5dTHQJt1MUECUcUrzxgl2lqVa5UA9Zkk3W+3\n" +
                "RAkQrJ+s0+cXq8esktREyZk6JlFeH7u8yxl64lnCZEkNgBU5kaW2r8menf0k/VnVzBqbnTpkyGOe\n" +
                "s19XxPTpVQEyHU/WPBFzjc+r+1iWVqienpNLS8Q09QEzl6Yfwm3p6nnqWxmr+EeKvmscYwzQ3+ha\n" +
                "5xh4zj4TebGcL05g1EcY6pIW7edvtjNfLmvm6j2eOvtkPvnP19G1fNRc2RwJjDnknot5oYqtRwOU\n" +
                "OoepOPuNO38ScjyYcvOTp+R85fG7rlnNOHcHUrVqp5gc5zVycdeTD+U+x6dK6WlXToBWoAHQAnyf\n" +
                "c6NTc1aWUsiL1HI8e4/nPrNV8lcuXBl9eJpx6ZMu0LCxLAssqhgYmBYBYGJgWAWBjWC0AMFo2C0A\n" +
                "MiSwwNyrEMAxjAsGIZWMYwLBjGVjEMCwYhlYxjAYxjAMQwGM8t4zpNfpT9Y8l9sY+Thx+/SeoGcD\n" +
                "6QUP9rbPUE8zo6lcew1c/jK5/Ffj+Tka6tnzWxQ/Ga9tvuNdPqTFe+eBnRtpVtcU5HvKLeK0pvP4\n" +
                "LZ6Ntzucc1ogVPdeD8WZ5f41Wf1ram23Gm5dRe3GeJNNfVonmWcnxD6U7vb7+u2dloZtZqLrPOLN\n" +
                "XLjjkevbD3mxpeKae8Atp20dThtSyOB6InCe8ZeU7MfG3Udvb6zczyj0kbrzNVDL6R7Cg1BMcZ+M\n" +
                "v1tEdBzjnuSlrrI4/wBVfUtgyr19pZTwytx8/OOZXbc22231W1cNFH3c8HzlO42e5v4Rud/vd3ra\n" +
                "TSuaaelXLXjLnhxjJwHrl4lsZclMrMY6ej4bSr9jnH4zZpTU0ByKdk/tPnvge58Q192add9raeq6\n" +
                "hhs+ahXCtnuAlfve+J63Y+Kb0Cu+01Bx50cPolscj7h8ZNlxVxvn9OxR82VcYOkjDnkxDXVrYLVT\n" +
                "3My+oNcmPl2nO3brj6a2oHOXhOZ5zfXKUuHKKHOMpyHzHj4E9Peorn7p5TxyrTXuHBZyhx1MScO1\n" +
                "eSelG20b7rxHaaVc28+rQVFwqfp+XtPqb3nhPBPAnTvob7U1r1vSv2SlsGUwc9cgp851Hf6uw8V0\n" +
                "dK2mGlqOG2VV9zpO85JHD8GWXt6RYViWBZ2ZkLAslYVgFYWJZWsArCsSwLAKwWYlgWAVhkrIgbdW\n" +
                "IZWMsGBYMQysYhgWDGMrGMYFgxDKxiGBYMQysYhgWDPOeO6ln6RbPTRK10b4eyuH9J6EZyPHtAtr\n" +
                "7LcHWmo0fcR/WUz6dOLXk0LVbUSrjjGfSaWx2FdprW1NDUdO7ltZw+ZeuczpFc178yp062y3F+cz\n" +
                "T026cHxXwTZa29vutSq6l3NilsFnu45Re+ElJtl3Nbaen5cFa49ahgMemJ6F0ajjTpU98SNPbV07\n" +
                "eexmyYPQk27JJOi2FXSpWtnLWuMs27ZtTAOPaU0ri2DGJsZAxmc6vHG3eiV3fm1KVvSyWBOBDGf3\n" +
                "6yLUs1Qr9lMYrwY9ydTX0aalGtsYeR9Jq6WmFscuO8mUa+00dHbOa7ewvpUx+E3hNTlMZOicYltK\n" +
                "pgxLa0F4MvrCFOnp1HAYenTtLkCpgxiMpnqBI1DBghDW1HPHynD3u1/ifGNvpWxajZyJkcCmZ27c\n" +
                "Ljmae3oaniurdOdOgVPdyfrIlTlNzTr7bSzWjo4rSqYMcPH/AGnP8ZrjdbQQbfXh+E0dprbvw/xL\n" +
                "U0t3qWS1m1V6WHpj0x0x2nU3lP4vxXZAPlR1bY7cYPxZM9rSeN27mePlCsxYVm55TFgWSsKwCsKy\n" +
                "VgWAVhWJYFgFYFiWBYELDmYsiBtjEMrGIYFgxjKxjGBYMQysYhgWDEMrGIYFgxZlYxDAsGaviek6\n" +
                "20ydaWrc+Tz+E2BkoWq1eiYZFm5pbG6sri1wGJXqBzl+6LUGmpaq/wAtkflK9S+DPXjEy6b5VYo4\n" +
                "O0VrAiJNPc6/kFHp3l2zo2oWvkyiEhLd0qYMvwjvQK+ZXD2kF9M0MD9tUcxOpo/UlbKIvTmTola9\n" +
                "tUxYMZxwvITS2+5q69qXPLYcI9p0fLotc1sWz6HM4e6ou6traHWrh98cMqvHdqicS2uUDpzmc3Zb\n" +
                "n6ynok3TU68mYVbGcPtKtRyccyPPnq9urIUZFRFNubZwyk8u31dbXtYqeUMrwcvP4za8uOvGYa1q\n" +
                "2+0DV6iZy9pESo8RNTfauzNPSsmct0x9/uzp7PTq7i2sYfLU06vsdfxhNM1gqqZcPwJuVrWlStTA\n" +
                "Tvx47u3Hmz1PGJWBZKwrNDEhYVmLCsDFgWSsKwCsKzFhWBCwLEsCwIWHMxZGYGyMYyoYxgWjEMrG\n" +
                "IYFgxDKxiGBYMQysYhgWDFmVjFmA8xDK8xZgcjeibvVcYVyTU1bKY/ZOl4lVdWtjon5M0NSmTI9Z\n" +
                "lymq3YXeMaVNA1darqP2Bzj1SbW60662hbTbXpkx5qWwnzlJxfA4xLMVaq2qB1V4kRNt21NPb7jT\n" +
                "0vq7bu2pj+W1uXHovf4wW0tTc6TpaylcYcOcvv7Tcrq6F21aatfOnHp/aYVro/b1tQqdcZ5+UleS\n" +
                "tTZ+HbfZK6d9Q83WpZK/ccTbvWpRK1wBx7Q/xmyzl1LHukzX3ezro21Dc6eKmXNg6fGQizKKqmL5\n" +
                "OF9OjNzSu24XKdSaOx3WhvKGpo2LGepN/Sqjnv8AnKUl22K5Tr98dauEgqoZ7yyqBISywFX8Jq7p\n" +
                "a7e9qqNRsYcchkm2p0mvrg4q93D8JMiLXQ2BnaaWrZW16FnjGMg4xL1mcBgADgDtCs2ya6efbbd1\n" +
                "iwrMWFZKGLAslYFgYsKzFhWBCwLEsCwIWFZiwrAKzMzFhzA2RjGVDGMCwYhlYxDAsGIZWMQwLBiG\n" +
                "VjEMB5izK8xDAsGTmDMzMAbyjfQU61c/LvOYnUfnOxkTD3nL3Om6WpgHDyPtOPJj9tHDn9NbUoK4\n" +
                "7k4+58GNdvjW1qq58tdRB9XB3nazl5V+ExqZyGEnGVpjz2l4RqUWtdbWp3za2SO3hWq/zbrVx7Y5\n" +
                "+eJ29QLZElH1eHJz7S23SZ6+nNr4Ho6iOo31U4G91xL9P6PbSrm+hpoGSuM5++dPTE6BnvmXYzy9\n" +
                "H1kWouTn7XZae1qmjUoHYOJvjgxzzMsGHASvPHrKWqrc4cxluD9ZTW2erF5gwr0kQWNueXpNfVsj\n" +
                "nJg5+6Is3v5a/FZXqphDtxFqO3b8wgnRMyFnm/D934g7/WpXXtq6NLgVtXIDhAfYnoVm6XceflNX\n" +
                "SVhWYsCyUJWBZiwrAxYVmLCsDFgWSsKwIWBZKwLAxZGZCyIGwMYyoYxgWDEMrGIYFgxDKxk5gWjJ\n" +
                "zKxiGBYMWZXmTmBZmSMrGTmBZmDW0662n5bOHs+jMGTmL7J6cq9L6Wr5dQx6J0T2mK5Ok6erSurR\n" +
                "rc+D3H1JzNWltC/lufZeljozPlhrpqw5d+qjyluBFzI+rM4z8pBqg44BIm+QQPjKO0p0qCIZjsIP\n" +
                "PuHrKDUBMh8jiZbXy446ytidk5xhZFkxzNe+4C2MnHWUau8rXI2M/iyurTba8+DIdIS9tSxWuXLi\n" +
                "a2la+tbHIZ6d3+xOtsdtax/kVHs3eKnwe/ylscbbrFW5STdZXTroaL5seZOV7e0qvtrNS+s2pS38\n" +
                "tQ+3f4HY937p0db6rZAp9duUzUscHvjsfizS81r3dTUs2unK/p/aaceCY+8u2fLnt+Kza6VdEq10\n" +
                "61wYrUylfv5V7ryzasuBe8opZ7enbtL8Lp89es6uAZkLDmQsgSsKyFhWBiwrMWFYGLCsxYVgYsCy\n" +
                "VgWBCyJiyMwLxiGVjEMCwYhlYxDAsGIZWMWYFgxZlWZOYFuZIysYswLMzMyvMWYFmZgyvMWYDzDq\n" +
                "UrqUaXC1XqMgYb3NPTtqW6VMsdji7vQ19DUsUHUoPGOs1v4xopetq47IiTo7bcO4072vjzmpaqen\n" +
                "RD7nEepWrVUfuma+rpsx6cp3/mcAuegENtfUsfZqnxmxfylucHxf0gbFrFNOre70rUzn5SvfUS0d\n" +
                "V17KFmp3x1+/tM2mjra2sae303U1HhRzj3V4J29r4Fr7hL7x+rp18lXn5vad3a7TQ2mn5NHTrWp6\n" +
                "E0Yf58sveTjnzzH1i5/h3gtdELbuxqW6+Q4qPv3X3fum9vd5XaaddPTqW1rH2a44D1cdj07wbvfG\n" +
                "jb6vTPNqJlO1T1f7TlnmWy2bWXNr26v7+7tNNmPHNYs1tzu8jqLbNlvd5bPKv77R1c2eQ9X056yu\n" +
                "jnkcDxzhfj8f36xVPMhVQx1xz/3nNZfTrwrLNOwOF+S9Zp6u4KW8mmDdOmeA9WPbNqPmtbn1eH7p\n" +
                "A2NQ8r0cPJmBZd566lUzy8iv4yjUq0UsfB7MgQsKyMyFgYsKzFhWBiwrMWFYGLAslYVgQsjMhZGY\n" +
                "F4xDKxiGBYMQysZOYFuZOZXmTmBZmIZWMWYFmZmZXmIYFgycyvMkYFmZmYMxVFMrgOqwM1NSunp2\n" +
                "1L2K0qNrL0A5Wcvc+J6W72lr7ZuVrfyDerV8yZz78dPfEs3250tXT1NquNPVq0b5ymRGz2Aer35x\n" +
                "0nG8O09Q0Nzsdavl19K/1pXOfMeXFseuAE9TLOuOP62/aN/s3PC7jq6+lnGStgPbJ/aX7qu48r9V\n" +
                "9ofRD75w6bv+C8W0L3cUuunZeOHo/eE9P5jT27r+Usjio9DGMvvjJiZPC5Z6jV5zHHdcbT0TT16v\n" +
                "iOt9UJnyV+1dOuQM4Mc5e3TM9js9ntNrpDt61SwPnOWwmRz3J883Wpc3WpqWsDaytnKr+az1f0R3\n" +
                "ttx4VfQtbLt7eWq//imQ+XJ8MTdhxY4T0yZ8mWfbvWt6cTn7zfJa2ht7HnP57vJT2PW3t26sHiO9\n" +
                "art9tZrdP8zUDJpj2PW2O3bq9ic+hWoadTFA9crnlV65zzl6/hJyy10rIlanA4OXPKrzlXqq9/8A\n" +
                "6kliy5MCZ47/AKfv5GFR/mw1Pw4/Lp++levr10a5TzWTAHr6Pz/eevBdbqXrp1zbj0/fxlFNTU3A\n" +
                "mlZrR4b9X4Hr+n4Q6O21dxY1dzkoc1r0z8fQ9vym95a1rgxWp1Xgx6/nxCVelp1064DLbq9V47ve\n" +
                "WVpZM2wOcmH09fhJEa2rhLByPDzjD8M5M5xnqya2LLWuXGBxxj+36c+iIZXIoHdOTL8MfHj/AO0l\n" +
                "hqpUqhaq4DHt1/KEoIln2wemMflkweiekQW8r5aoD2evdM/v17kAa2m6eHqP4fGUrNqv2VF4ez6e\n" +
                "/wCEp1tHH2qcnp6fCRoU5kLIWFZAlYVkLIWBiwrMWFYGLDmYsjMC+TMmQEREyZAmImTICkzJkCSK\n" +
                "ZMgZFMmQMt/L935y23+kTJktB53xL/dtz/TpfkSw/wDdey/5dP8AoZkyduL7Uyef+kvWn9dfzJ7C\n" +
                "n/p2l/Tb8yZMnLj/AOjrn8HlfE+mr/UflO99Bv8AU3fwp+TMmTZemeLv/h1v6r/my1/mt8X/AKiZ\n" +
                "MmPLt1nTK/6dvl+bNC3++H/6/lMmSIV2Lf8AF8X8obfy1/rp+bMmSQdf+V/5ep//ADLNv/p2/rt+\n" +
                "TMmSEnbrT996RafU/pP+mZMgR/wnxP1jP7TJkDnan+pb4sDMmSoLCzJkCGBmTIBZEyZA/9k=");
        //util.getPicFormatBASE64(user);
        userServiceInterface.saveUser(user);
        //ImageToBase64
    }

    @Test
    public void update() {
        UserRequest user=new UserRequest();
        user.setIdNo("4108");
        user.setName("jzf");
        user.setCardNo("111");
        user.setCardType("test");
        user.setPhone("138");
        user.setLogId(2L);
        user.setService("face.modify");
        //获得图片
        String base64 = ImageToBase64.ImageToBase64("D:\\资料\\face2.jpg");
        user.setImage(base64);
        //util.getPicFormatBASE64(user);
        userServiceInterface.updateUser(user);
        //ImageToBase64
    }

    @Test
    public void delete() {
        UserRequest user=new UserRequest();
        user.setIdNo("4108");
        user.setName("jzf");
        //user.setService("face.del");
        //util.getPicFormatBASE64(user);
        userServiceInterface.deleteUser(user);
        //ImageToBase64
    }
}
