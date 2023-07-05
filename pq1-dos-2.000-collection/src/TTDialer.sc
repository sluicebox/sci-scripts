;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 555)
(include sci.sh)
(use Main)
(use Talker)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	TTDialer 0
	phoneT 1
)

(local
	[local0 100]
	local100
	local101
	[local102 14] = [0 1 -16 1 19 -16 1 19 -16 1 19 -16 19 -1]
	[local116 20] = [0 -15 -69 -69 -69 -52 -52 -52 -34 -34 -34 -15 -15 -3 551 552 553 554 555 556]
	local136
	local137
	local138
	local139
	local140
	local141
	local142
)

(instance TTDialer of Prop
	(properties
		x 275
		y 89
		view 555
		priority 14
		signal 16
	)

	(method (init param1 param2)
		(= x 41)
		(= y 189)
		(= local138 param1)
		(if (> argc 1)
			(= local139 param2)
		else
			(= local139 0)
		)
		(= local0 0)
		(= local101 0)
		(= local136 0)
		(= local137 0)
		(= local140 (User canInput:))
		(= local141 ((gTheIconBar at: 0) cursor:))
		(HandsOff)
		(User canInput: 1 mapKeyToDir: 0)
		(gTheIconBar enable: 2 curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 609)
		(gLongSong2 number: 923 loop: -1 flags: -1 play: hold: 10)
		(super init: stopUpd:)
		(btn0 init: stopUpd:)
		(btn1 init: stopUpd:)
		(btn2 init: stopUpd:)
		(btn3 init: stopUpd:)
		(btn4 init: stopUpd:)
		(btn5 init: stopUpd:)
		(btn6 init: stopUpd:)
		(btn7 init: stopUpd:)
		(btn8 init: stopUpd:)
		(btn9 init: stopUpd:)
		(btnStar init: stopUpd:)
		(btnCross init: stopUpd:)
		(hangUp init: stopUpd:)
		(gMouseDownHandler addToEnd: self)
		(gKeyDownHandler addToEnd: self)
	)

	(method (dispose)
		(User canInput: 0 canControl: 0)
		(btn0 dispose:)
		(btn1 dispose:)
		(btn2 dispose:)
		(btn3 dispose:)
		(btn4 dispose:)
		(btn5 dispose:)
		(btn6 dispose:)
		(btn7 dispose:)
		(btn8 dispose:)
		(btn9 dispose:)
		(btnStar dispose:)
		(btnCross dispose:)
		(hangUp dispose:)
		(self hide:)
		(= local101 254)
		(hangUpTimer setReal: self 2)
	)

	(method (handleEvent event)
		(cond
			((not (User canInput:)))
			((event modifiers:)
				(super handleEvent: event)
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(event claimed: 1)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (cue &tmp [temp0 51])
		(switch (++ local101)
			(1
				(if (not (ReadNumber @local0))
					(= local137 1212)
					(self setScript: sCheckNumber)
				)
			)
			(2 0)
			(3
				(if (== local138 1)
					(= local136 (ReadNumber @local0))
					(= local0 0)
					(cond
						((== local136 411)
							(= local137 1212)
							(self setScript: sInformation)
						)
						((== local136 911)
							(= local137 9998)
							(self setScript: sInformation)
						)
					)
				)
			)
			(3 0)
			(4 0)
			(5 0)
			(6 0)
			(255
				(User canInput: local140 mapKeyToDir: 1)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gCurRoom notify: local142)
				(if local139
					(local139 cue:)
				)
				(gLongSong2 stop:)
				(hangUpTimer dispose: delete:)
				(gTheIconBar enable: curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(buttonSnd dispose:)
				(super dispose:)
			)
			(else
				(= local137 (ReadNumber @local0))
				(self setScript: sCheckNumber)
			)
		)
	)
)

(instance hangUpTimer of Timer
	(properties)
)

(class PushButton of Prop
	(properties
		priority 14
		signal 16
		keyValue 45
		scanValue 0
		keyStr {x}
		tone 0
	)

	(method (init &tmp temp0)
		(= x (+ (TTDialer x:) [local102 loop]))
		(= y (+ (TTDialer y:) [local116 loop] 1000))
		(= view 555)
		(self setCel: 0)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 10] temp10 temp11 temp12)
		(= temp10 (event type:))
		(= temp11 (event message:))
		(cond
			((and (== temp10 evKEYBOARD) (== temp11 KEY_ESCAPE))
				(event claimed: 1)
			)
			(
				(or
					(and (== temp10 evMOUSEBUTTON) (self onMe: event))
					(and (== temp10 evKEYBOARD) (== temp11 KEY_RETURN) (self onMe: event))
					(and (== temp10 evKEYBOARD) (OneOf temp11 keyValue scanValue))
				)
				(event claimed: 1)
				(gLongSong2 stop:)
				(if (== loop 13)
					(= local142 -1)
					(TTDialer dispose:)
				else
					(if (and (== (event modifiers:) $000c) (== loop 1)) ; emALT | emCTRL
						(= keyStr {!})
					else
						(switch loop
							(11
								(= keyStr {#})
							)
							(12
								(= keyStr {*})
							)
							(else
								(Format keyStr 555 0 (- loop 1)) ; "%d"
							)
						)
					)
					(= temp12 tone)
					(self setScript: (sButton new:) 0 temp12)
				)
			)
		)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(client setCycle: End self)
			)
			(1
				(if register
					(buttonSnd number: register flags: -1 play:)
				)
				(= cycles 2)
			)
			(2
				(StrCat @local0 (client keyStr:))
				(client setCel: 0)
				(= cycles 2)
			)
			(3
				(TTDialer cue:)
				(= cycles 10)
			)
			(4
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance btn0 of PushButton
	(properties
		z 1000
		loop 1
		keyValue 48
		scanValue 20992
		keyStr {x}
		tone 933
	)
)

(instance btn1 of PushButton
	(properties
		z 1000
		loop 2
		keyValue 49
		scanValue 20224
		keyStr {x}
		tone 924
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 55 else 49))
		(= scanValue (if (== gCurRoomNum 258) 18176 else 20224))
		(super init:)
	)
)

(instance btn2 of PushButton
	(properties
		z 1000
		loop 3
		keyValue 50
		scanValue 20480
		keyStr {x}
		tone 925
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 56 else 50))
		(= scanValue (if (== gCurRoomNum 258) 18432 else 20480))
		(super init:)
	)
)

(instance btn3 of PushButton
	(properties
		z 1000
		loop 4
		keyValue 51
		scanValue 20736
		keyStr {x}
		tone 926
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 57 else 51))
		(= scanValue (if (== gCurRoomNum 258) 18688 else 20736))
		(super init:)
	)
)

(instance btn4 of PushButton
	(properties
		z 1000
		loop 5
		keyValue 52
		scanValue 19200
		keyStr {x}
		tone 927
	)
)

(instance btn5 of PushButton
	(properties
		z 1000
		loop 6
		keyValue 53
		scanValue 19456
		keyStr {x}
		tone 928
	)
)

(instance btn6 of PushButton
	(properties
		z 1000
		loop 7
		keyValue 54
		scanValue 19712
		keyStr {x}
		tone 929
	)
)

(instance btn7 of PushButton
	(properties
		z 1000
		loop 8
		keyValue 55
		scanValue 18176
		keyStr {x}
		tone 930
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 49 else 55))
		(= scanValue (if (== gCurRoomNum 258) 20224 else 18176))
		(super init:)
	)
)

(instance btn8 of PushButton
	(properties
		z 1000
		loop 9
		keyValue 56
		scanValue 18432
		keyStr {x}
		tone 931
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 50 else 56))
		(= scanValue (if (== gCurRoomNum 258) 20480 else 18432))
		(super init:)
	)
)

(instance btn9 of PushButton
	(properties
		z 1000
		loop 10
		keyValue 57
		scanValue 18688
		keyStr {x}
		tone 932
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 51 else 57))
		(= scanValue (if (== gCurRoomNum 258) 20736 else 18688))
		(super init:)
	)
)

(instance btnCross of PushButton
	(properties
		z 1000
		loop 11
		keyValue 35
		keyStr {x}
		tone 934
	)
)

(instance btnStar of PushButton
	(properties
		z 1000
		loop 12
		keyValue 42
		keyStr {x}
		tone 935
	)
)

(instance hangUp of PushButton
	(properties
		z 1000
		loop 13
		keyValue 32
		keyStr {x}
	)
)

(instance sInformation of Script
	(properties)

	(method (changeState newState &tmp [temp0 222])
		(switch (= state newState)
			(0
				(HandsOff)
				(= local100 (Random 20 35))
				(cond
					((== local137 9998)
						(++ state)
						(gMessager say: 18 4 22 0 self 100) ; "Against your better judgment, you dial the emergency number. After a few seconds, the dispatcher answers your call."
						(= local137 0)
					)
					((and (IsFlag 44) (not (IsFlag 47)))
						(SetFlag 47)
						(= local142 local137)
						(client dispose:)
					)
					(else
						(= ticks 5)
					)
				)
			)
			(1
				(gMessager say: 18 4 24 0 self 100) ; "You have reached Directory Assistance. Due to a heavy volume of calls, all circuits are busy. Please try again later. Thank you for using LT&T."
			)
			(2
				(= local142 0)
				(= local0 0)
				(= local101 0)
				(= local136 0)
				(= local137 0)
				(client dispose:)
			)
		)
	)
)

(instance phoneT of Narrator
	(properties
		x 150
		y 20
		talkWidth 150
		showTitle 1
	)

	(method (init)
		(switch local137
			(6272
				(self name: {Frank Anglin} back: local100)
			)
			(2264
				(self name: {Oliver Smith} back: local100)
			)
			(9453
				(self name: {Miranda Duvall} back: local100)
			)
			(9699
				(self name: {Mike Shannon} back: local100)
			)
			(4875
				(self name: {Hurt Wolff} back: local100)
			)
			(2837
				(self name: {Keith Mandel} back: local100)
			)
			(7783
				(self name: {Jeffrey Steele} back: local100)
			)
			(6342
				(self name: {Jake Donaldson} back: local100)
			)
			(9274
				(self name: {Fudley Morris} back: local100)
			)
			(9355
				(self name: {John Dooley} back: local100)
			)
			(4663
				(self name: {Thomas Carter} back: local100)
			)
			(3293
				(self name: {Oscar Hamilton} back: local100)
			)
			(7588
				(self name: {Helen Hackman} back: local100)
			)
			(2273
				(self name: {Tony Michaels} back: local100)
			)
			(8833
				(self name: {Laura Watts} back: local100)
			)
			(2483
				(self name: {Todd Ballew} back: local100)
			)
			(9473
				(self name: {Joe Taber} back: local100)
			)
			(3833
				(self name: {Steve Johnson} back: local100)
			)
			(2233
				(self name: {Shelly Kale} back: local100)
			)
			(9425
				(self name: {Sarah Zuckerman} back: local100)
			)
			(2275
				(self name: {Rex McCall} back: local100)
			)
			(6373
				(self name: {Russ Dinkle} back: local100)
			)
			(4335
				(self name: {Paul Peterwaski} back: local100)
			)
			(2697
				(self name: {Sandy Shapiro} back: local100)
			)
			(7427
				(self name: {Pat Billings} back: local100)
			)
			(1212
				(self name: {Operator} back: local100)
			)
			(9998
				(self name: {Cherie} back: local100)
			)
		)
		(super init: &rest)
	)
)

(instance buttonSnd of Sound
	(properties)
)

(instance sCheckNumber of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(User canInput: 0)
				(btn0 hide:)
				(btn1 hide:)
				(btn2 hide:)
				(btn3 hide:)
				(btn4 hide:)
				(btn5 hide:)
				(btn6 hide:)
				(btn7 hide:)
				(btn8 hide:)
				(btn9 hide:)
				(btnStar hide:)
				(btnCross hide:)
				(hangUp hide:)
				(client hide:)
				(= cycles 2)
			)
			(1
				(if (!= local136 555)
					(User canInput: 0)
					(gMessager say: 18 4 19 0 self 100) ; "The number you have dialed cannot be reached from your calling area. Thank you for using LT&T."
					(= local0 0)
					(= local101 0)
					(= local136 0)
					(= local137 0)
					(= local142 0)
				else
					(= local100 (Random 7 100))
					(switch local137
						(3784
							(if (!= gCurRoomNum 54)
								(gMessager say: 13 4 14 0 self 100) ; "You get a busy signal. Captain Morgan has to spend a lot of time on the phone."
								(= local137 0)
							else
								(= cycles 2)
							)
						)
						(2264
							(if (IsFlag 54)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 54)
								(gMessager say: 14 4 15 0 self 100) ; "Hello, this is Detective Oliver Smith. I'm out improving my skills with a firearm at the firing range. I would suggest you get off your butt and do so as well. If you have something to say to me, leave a message at the tone. **BEEP*"
								(= local137 0)
							)
						)
						(9453
							(if (IsFlag 77)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 77)
								(gMessager say: 12 4 13 0 self 100) ; "Hi, this is Officer Miranda Duvall. I'm out saving the world right now, so obviously, I can't come to the phone. If you need a natural disaster averted, leave your name and message and I'll get back to you. **BEEP*"
								(= local137 0)
							)
						)
						(9699
							(if (IsFlag 55)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 55)
								(gMessager say: 11 4 12 0 self 100) ; "You get a busy signal."
								(= local137 0)
							)
						)
						(4875
							(if (IsFlag 56)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 56)
								(gMessager say: 10 4 11 0 self 100) ; "Hi, this is Officer Kurt Wolff. I'm probably out risking my life over a domestic dispute involving who drank the last of the orange juice, or who left the toilet seat up. Leave your name and number. If I live through the day, I'll call you. **BEEP*"
								(= local137 0)
							)
						)
						(2837
							(if (IsFlag 57)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 57)
								(gMessager say: 9 4 10 0 self 100) ; "Hi, this is Keith Mandel. I'm out making Lytton safe for future generations, so please leave your message and I'll call you back. **BEEP*"
								(= local137 0)
							)
						)
						(7783
							(if (IsFlag 58)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 58)
								(gMessager say: 8 4 9 0 self 100) ; "This is Detective Jeff Steele. I can't come to the phone right now. I'm sure I have a very good reason. If you have a very good reason, leave your name and message at the beep. **BEEP*"
								(= local137 0)
							)
						)
						(6342
							(if (IsFlag 59)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 59)
								(gMessager say: 7 4 8 0 self 100) ; "This is Jake Donaldson. I'm on vacation this week. Leave a message if it's important. If you call me at my hotel in San Diego, it had better be a life and death matter. I'm busy soakin' up rays! **BEEP*"
								(= local137 0)
							)
						)
						(9274
							(if (IsFlag 60)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 60)
								(gMessager say: 5 4 5 0 self 100) ; "Hi, this is Officer Fudley Morris. I can't come to the phone right now. I'm cleaning up the streets. Leave your number and I'll call you back. **BEEP*"
								(= local137 0)
							)
						)
						(9355
							(if (IsFlag 61)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 61)
								(gMessager say: 3 4 3 0 self 100) ; "This is Sergeant John Dooley. Leave your name and message at the tone. And if this is The Gremlin, YOU'RE DEAD! **BEEP*"
								(= local137 0)
							)
						)
						(4663
							(if (IsFlag 62)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 62)
								(gMessager say: 2 4 2 0 self 100) ; "You get a busy signal."
								(= local137 0)
							)
						)
						(7883
							(if (IsFlag 63)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 63)
								(gMessager say: 1 4 1 0 self 100) ; "What, did you expect yourself to answer? You've been working too hard, Bonds."
								(= local137 0)
							)
						)
						(3293
							(if (IsFlag 64)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 64)
								(gMessager say: 15 4 16 0 self 100) ; "This is Detective Oscar Hamiliton. I'm out scraping some poor shlock off the sidewalk right now, so I can't come to the phone. If it's important, leave me a message. If it's not, leave me the hell alone."
								(= local137 0)
							)
						)
						(7588
							(if (IsFlag 65)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 65)
								(gMessager say: 26 4 33 0 self 100) ; "Hmmm...(yawn)...Hello?"
								(= local137 0)
							)
						)
						(2273
							(if (IsFlag 66)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 66)
								(gMessager say: 28 4 36 0 self 100) ; "You get a busy signal."
								(= local137 0)
							)
						)
						(8833
							(if (IsFlag 53)
								(gMessager say: 29 4 38 0 self 100) ; "You get only a busy signal."
							else
								(SetFlag 53)
								(gMessager say: 29 4 37 0 self 100) ; "Hi, this is Detective Watts. I'm training some wet-behind-the-ears babynarc right now, so I can't come to the phone. You know what to do at the tone. Bye! **BEEP**"
							)
							(= local137 0)
						)
						(2483
							(if (IsFlag 68)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 68)
								(gMessager say: 27 4 35 0 self 100) ; "You get a busy signal."
								(= local137 0)
							)
						)
						(9473
							(if (IsFlag 51)
								(gMessager say: 25 4 32 0 self 100) ; "You don't need to pester Detective Taber right now."
								(= local137 0)
							else
								(SetFlag 51)
								(= cycles 2)
							)
						)
						(3833
							(if (IsFlag 67)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 67)
								(gMessager say: 24 4 31 0 self 100) ; "Hey, this is Steve. I'm busy scamming babes right now so leave me a message and I'll call you back. Bye! **BEEP**"
								(= local137 0)
							)
						)
						(2233
							(if (IsFlag 69)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 69)
								(gMessager say: 23 4 30 0 self 100) ; "This is Officer Shelly Kale. Leave your name and number and I'll get back to you. **BEEP**"
								(= local137 0)
							)
						)
						(9425
							(if (IsFlag 70)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 70)
								(gMessager say: 22 4 29 0 self 100) ; "Hi, this is Officer Zuckerman. If you're Oprah or Phil or Sally wanting to tell the sordid story of my life, I'll call you right back. If you're anyone else, leave your number anyway, and I'll think about it! **BEEP**"
								(= local137 0)
							)
						)
						(2275
							(if (IsFlag 71)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 71)
								(gMessager say: 19 4 26 0 self 100) ; "McCall. Leave a message. **BEEP**"
								(= local137 0)
							)
						)
						(6373
							(if (IsFlag 72)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 72)
								(gMessager say: 20 4 27 0 self 100) ; "Hi, this is Russ! I'm, like, really busy right now, so, like, leave your message at the beep, and I'll have my secretary call yours, ha ha! **BEEP**"
								(= local137 0)
							)
						)
						(4335
							(if (IsFlag 73)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 73)
								(gMessager say: 17 4 18 0 self 100) ; "Hi, Little Buckaroo, this is Officer Paul Peterowski at your service. I'm not really at your service, because I'm not here right now! Leave a message, or come down to the jail and see me. I'm dying for some company! That means you, Sonny Bonds! **BEEP*"
								(= local137 0)
							)
						)
						(2697
							(if (IsFlag 74)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 74)
								(gMessager say: 21 4 28 0 self 100) ; "You get a busy signal."
								(= local137 0)
							)
						)
						(7427
							(if (IsFlag 75)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 75)
								(gMessager say: 16 4 17 0 self 100) ; "This is Officer Billings. I can't come to the phone right now. If you're the creep who bashed the fender of my vintage Jag, leave your name and number at the tone. Believe me, I'll get back to you. **BEEP**"
								(= local137 0)
							)
						)
						(7627
							(if (not (IsFlag 42))
								(SetFlag 42)
								(gMessager say: 6 4 6 0 self 100) ; "...Hello?"
							else
								(gMessager say: 6 4 7 0 self 100) ; "You get only a busy signal."
							)
							(= local137 0)
						)
						(6272
							(if (IsFlag 76)
								(= local137 -2)
								(= cycles 2)
							else
								(SetFlag 76)
								(gMessager say: 4 4 4) ; "Hmmm, no answer."
								(= local137 0)
							)
						)
						(6887
							(if (not (IsFlag 44))
								(gMessager say: 20 0 15 0 self 54) ; "Lyvely Lytton Cab Company. May I help you?"
								(= local137 0)
							else
								(= cycles 2)
							)
						)
						(1212
							(self setScript: sInformation self)
						)
						(else
							(= local137 -1)
							(= cycles 2)
						)
					)
				)
			)
			(2
				(cond
					((== local137 -2)
						(gMessager say: 18 4 21 0 self 100) ; "You don't need to repeat that call."
						(= local137 0)
					)
					((== local137 -1)
						(switch (Random 0 2)
							(0
								(gMessager say: 18 4 23 0 self 100) ; "We're sorry. Your call can not go through as dialed. Please check the number and dial again. Thank you for using LT&T."
							)
							(1
								(gMessager say: 18 4 20 0 self 100) ; "That number seems to be busy."
							)
							(2
								(gMessager say: 18 4 25 0 self 100) ; "We're sorry, you have reached a number that is no longer in service. If you feel you have reached this recording in error,  please check the number and try your call again. Thank you for using LT&T."
							)
						)
						(= local137 0)
					)
					((== local137 7588)
						(gCurRoom drawPic: 99)
						(gCast eachElementDo: #hide)
						(gMessager say: 26 4 34 0 self 100) ; "She did, in fact, have your badge for that. You were kicked off the force in disgrace. Hope you're enjoying your new job at Brew 'N Burger."
					)
					(else
						(User canInput: 1)
						(= local142 local137)
						(client dispose:)
					)
				)
			)
			(3
				(User canInput: 1)
				(= local142 local137)
				(client dispose:)
			)
		)
	)
)

