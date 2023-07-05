;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm520 0
	bTalker 1
	dTalker 12
	fTalker 13
	qTalker 14
	egoTalker 15
	sTalker 17
)

(local
	local0 = 1
	local1 = 3
	local2
	local3
	local4
	local5
)

(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)

(instance rm520 of Rm
	(properties
		picture 74
		style 10
	)

	(method (init &tmp temp0)
		(theExit init:)
		(theFlo init:)
		(theDroole init:)
		(gWalkHandler addToFront: theExit)
		(gCurRoom setRegions: 505) ; sbar
		(switch global125
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 524 522)
				(gCurRoom setScript: sWaitress self)
			)
			(1
				(gGame handsOff:)
				(LoadMany rsVIEW 524 521)
				(gCurRoom setScript: sSalesman self)
			)
			(2
				(gGame handsOff:)
				(LoadMany rsVIEW 524 523)
				(gCurRoom setScript: sQuirk self)
			)
			(3
				(gGame handsOn:)
				(LoadMany rsVIEW 524)
				(gCurRoom setScript: sCrew self)
			)
			(else
				(gGame handsOn:)
				(LoadMany rsVIEW 524)
				(gCurRoom setScript: sCrew self)
			)
		)
		(super init:)
	)

	(method (dispose)
		(gWalkHandler delete: theExit)
		(super dispose: &rest)
	)
)

(instance sCrew of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 500 setLoop: -1 play:)
				(= local0 0)
				(rogHead init:)
				(rogArms init:)
				(drink init:)
				(flodrink init: stopUpd:)
				(drooldrink init: stopUpd:)
				(if (IsFlag 48)
					(drink setScript: sMonkeys)
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sQuirk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 500 setLoop: -1 play:)
				(= local0 2)
				(drink init:)
				(flodrink init:)
				(drooldrink init:)
				(rogHead init:)
				(rogArms init:)
				(quirkBody init:)
				(quirkHead init:)
				(= seconds 1)
			)
			(1
				(rogHead cel: 2)
				(= cycles 1)
			)
			(2
				(gMessager say: 5 0 0 0 self) ; "Well, well, well, look who it isn't."
			)
			(3
				(= global124 9)
				(= global125 3)
				(ClearFlag 50)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sWaitress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 500 setLoop: -1 play:)
				(rogHead init:)
				(rogArms init:)
				(theMusic4 number: 121 setLoop: -1 play:)
				(roboWaitress init: x: 0 y: 32 setMotion: MoveTo 73 42 self)
				(door init:)
				(light init: setCycle: Fwd)
				(lites1 init: setCycle: Fwd)
				(lites2 init: setCycle: Fwd)
				(lites3 init: setCycle: Fwd)
				(lites4 init: setCycle: Fwd)
			)
			(1
				(rogHead setCel: 0)
				(= cycles 1)
			)
			(2
				(gMessager say: 0 0 0 0 self) ; "Hello... I am your cocktail waitress analog, Bzzzzt."
			)
			(3
				(gSq5Music2 number: 503 loop: 1 play:)
				(door loop: 1 cel: 0 x: 91 y: 70 setCycle: End self)
			)
			(4
				(gSq5Music2 stop:)
				(drink
					init:
					x: 108
					y: 89
					view: 522
					loop: 6
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				(drink setLoop: 7 setCel: 1 x: 125 y: 101)
				(= ticks 10)
			)
			(6
				(drink setCel: 2 x: 131 y: 119)
				(= ticks 10)
			)
			(7
				(drink setCel: 3 x: 118 y: 140)
				(= ticks 10)
			)
			(8
				(gSq5Music2 number: 520 loop: 1 play:)
				(drink stopUpd:)
				(= ticks 1)
			)
			(9
				(flodrink
					init:
					setLoop: 4
					setCel: 0
					x: 109
					y: 90
					setCycle: End self
				)
			)
			(10
				(flodrink setLoop: 5 cel: 1 x: 125 y: 105)
				(= ticks 10)
			)
			(11
				(flodrink cel: 2 x: 116 y: 130)
				(= ticks 10)
			)
			(12
				(flodrink cel: 3 x: 102 y: 148)
				(= ticks 10)
			)
			(13
				(gSq5Music2 number: 520 loop: 1 play:)
				(flodrink stopUpd:)
				(= ticks 10)
			)
			(14
				(drooldrink
					init:
					setLoop: 2
					setCel: 0
					x: 113
					y: 84
					setCycle: End self
				)
			)
			(15
				(drooldrink setLoop: 3 cel: 1 x: 138 y: 101)
				(= ticks 10)
			)
			(16
				(drooldrink cel: 2 x: 169 y: 123)
				(= ticks 10)
			)
			(17
				(drooldrink cel: 3 x: 207 y: 139)
				(= ticks 10)
			)
			(18
				(gSq5Music2 number: 520 loop: 1 play:)
				(drooldrink stopUpd:)
				(= ticks 10)
			)
			(19
				(door loop: 1 cel: 2 x: 91 y: 70 setCycle: Beg self)
				(gSq5Music2 number: 503 loop: 1 play:)
			)
			(20
				(gSq5Music2 stop:)
				(rogHead cel: 1)
				(roboWaitress
					setLoop: 0
					cel: 0
					x: 73
					y: 42
					setMotion: MoveTo -10 32 self
				)
			)
			(21
				(theMusic4 fade:)
				(roboWaitress dispose:)
				(= seconds 1)
			)
			(22
				(= global124 7)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sSalesman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theMusic3 number: 500 setLoop: -1 play:)
				(rogHead init:)
				(rogArms init:)
				(sMan init:)
				(sHead init:)
				(sArms init:)
				(drink init:)
				(flodrink init:)
				(drooldrink init:)
				(= seconds 1)
			)
			(1
				(sArms view: 521 loop: 4 cel: 0)
				(sHead view: 521 loop: 1 cel: 0)
				(gSq5Music2 number: 502 loop: 1 play:)
				(rogHead cel: 0)
				(= seconds 1)
			)
			(2
				(gMessager say: 8 0 0 0 self) ; "Hello there, suck... I mean, pardner. May I have a moment?"
			)
			(3
				(gSq5Music2 number: 502 loop: 1 play:)
				(gEgo get: 13 14) ; Space_Monkeys_Package
				(= cycles 1)
			)
			(4
				(= global124 8)
				(gCurRoom newRoom: 500)
				(self dispose:)
			)
		)
	)
)

(instance sMonkeysInDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(SetScore 214 50)
				(rogHead init: view: 524 loop: 0 setCel: 1)
				(rogArms init: view: 524 loop: 5 setCel: 0)
				(= seconds 1)
			)
			(2
				(gSq5Music1 number: 25 loop: -1 play:)
				(gSq5Music2 number: 256 loop: -1 play:)
				(rogArms init: view: 524 loop: 5 setCel: 1)
				(drink init:)
				(m1 init:)
				(m2 init:)
				(m3 init: setScript: sMonks1)
				(= seconds 3)
			)
			(3
				(theMusic4 number: 506 loop: 1 play:)
				(rogHead init: view: 524 loop: 0 setCel: 3)
				(m4 init: setScript: sMonks2)
				(= seconds 2)
			)
			(4
				(rogArms view: 524 loop: 4 setCel: 0)
				(= seconds 2)
			)
			(5
				(rogHead view: 524 loop: 0 setCel: 4)
				(= cycles 1)
			)
			(6
				(= seconds 6)
			)
			(7
				(gSq5Music1 fade:)
				(gSq5Music2 stop:)
				(theMusic4 stop:)
				(gGame handsOn:)
				(= global124 11)
				(gEgo put: 13) ; Space_Monkeys_Package
				(SetFlag 48)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sMonkeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(m1 init:)
				(m2 init:)
				(m3 init: setScript: sMonks1)
				(m4 init: setScript: sMonks2)
				(= seconds 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sMonks1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(m3 show: x: 124 y: 127 setMotion: MoveTo 127 73 self)
			)
			(1
				(m3 hide:)
				(theMusic4 number: 506 loop: 1 play:)
				(m3split init: setCycle: End self)
			)
			(2
				(m3split dispose:)
				(m3a init: show: x: 117 y: 73 setMotion: MoveTo 53 27 self)
				(m3b init: show: x: 135 y: 73 setMotion: MoveTo 282 33 self)
			)
			(3 0)
			(4
				(m3a hide:)
				(m3b hide:)
				(= seconds (Random 1 4))
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sMonks2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(m4 show: x: 118 y: 129 setMotion: MoveTo 120 56 self)
			)
			(1
				(theMusic4 number: 506 loop: 1 play:)
				(m4 hide:)
				(m4split init: setCycle: End self)
			)
			(2
				(m4split dispose:)
				(m4a
					init:
					show:
					x: 137
					y: 49
					scaleSignal: 1
					scaleX: 121
					scaleY: 121
					setMotion: MoveTo 183 5 self
				)
				(m4b
					init:
					show:
					x: 107
					y: 51
					scaleSignal: 1
					scaleX: 33
					scaleY: 33
					setMotion: MoveTo 41 36 self
				)
			)
			(3 0)
			(4
				(m4a hide:)
				(m4b hide:)
				(= seconds (Random 1 4))
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance m1 of Actor
	(properties
		x 112
		y 125
		view 526
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 0
			cel: 0
			x: 112
			y: 125
			setCycle: Fwd
			setMotion: MoveTo 91 8 self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance m2 of Actor
	(properties
		x 125
		y 123
		view 526
		loop 5
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 5
			cel: 0
			x: 125
			y: 123
			setCycle: Fwd
			setMotion: MoveTo 138 7 self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance m3 of Actor
	(properties
		x 124
		y 127
		view 526
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 1 cel: 0 x: 124 y: 127 setCycle: Fwd)
	)
)

(instance m3split of Actor
	(properties
		x 126
		y 73
		view 526
		loop 7
		cel 7
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 7 cel: 7)
	)
)

(instance m3a of Actor
	(properties
		x 117
		y 73
		view 526
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 1 setCycle: Fwd)
	)
)

(instance m3b of Actor
	(properties
		x 135
		y 73
		view 526
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 0 setCycle: Fwd)
	)
)

(instance m3b1 of Actor ; UNUSED
	(properties
		x 160
		y 45
		view 526
		loop 4
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 4 setCycle: Fwd)
	)
)

(instance m4 of Actor
	(properties
		x 118
		y 129
		view 526
		loop 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 2 cel: 0 x: 118 y: 129 setCycle: Fwd)
	)
)

(instance m4split of Actor
	(properties
		x 120
		y 56
		view 526
		loop 10
		cel 7
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 10 cel: 7 x: 120 y: 56 setCycle: Fwd)
	)
)

(instance m4a of Actor
	(properties
		x 137
		y 49
		view 526
		loop 12
		signal 16384
		scaleSignal 1
		scaleX 121
		scaleY 121
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 12 setCycle: Fwd)
	)
)

(instance m4b of Actor
	(properties
		x 107
		y 51
		view 526
		loop 13
		signal 16384
		scaleSignal 1
		scaleX 33
		scaleY 33
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 13 setCycle: Fwd)
	)
)

(instance sMan of View
	(properties
		x 60
		y 58
		view 521
	)
)

(instance sHead of View
	(properties
		x 89
		y 30
		view 521
		loop 1
		priority 5
		signal 16
	)
)

(instance sArms of View
	(properties
		x 68
		y 95
		view 521
		loop 4
	)
)

(instance quirkBody of View
	(properties
		x 84
		y 46
		view 523
	)
)

(instance quirkHead of View
	(properties
		x 84
		y 46
		view 523
		loop 1
	)
)

(instance quirkMouth of Prop ; UNUSED
	(properties
		x 80
		y 33
		view 523
		loop 3
		priority 5
		signal 16
	)
)

(instance quirkYell of Prop ; UNUSED
	(properties
		x 78
		y 33
		view 523
		loop 4
		priority 5
		signal 16
	)
)

(instance quirkBrows of Prop ; UNUSED
	(properties
		x 79
		y 20
		view 523
		loop 5
		priority 5
		signal 16
	)
)

(instance rogHead of View
	(properties
		x 168
		y 88
		noun 7
		view 524
		signal 16384
	)

	(method (init)
		(switch global125
			(0
				(self cel: 1)
			)
			(1
				(self cel: 1)
			)
			(2
				(self cel: 1)
			)
			(3
				(if (== local3 1)
					(self cel: 3)
				else
					(self cel: 1)
				)
			)
		)
		(super init: &rest)
	)
)

(instance rogArms of View
	(properties
		x 178
		y 121
		view 524
		loop 4
		signal 16384
	)

	(method (init)
		(if (== local3 1)
			(self loop: 5 cel: 1)
		)
		(super init: &rest)
	)
)

(instance roboWaitress of Actor
	(properties
		view 522
		signal 16384
	)

	(method (init)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		view 522
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (roboWaitress x:) 18) y: (+ (roboWaitress y:) 28))
	)

	(method (doit)
		(if (roboWaitress mover:)
			(self x: (+ (roboWaitress x:) 18) y: (+ (roboWaitress y:) 28))
		)
		(super doit: &rest)
	)
)

(instance light of Prop
	(properties
		view 522
		loop 9
		priority 3
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (roboWaitress x:) 55) y: (roboWaitress y:))
	)

	(method (doit)
		(self x: (+ (roboWaitress x:) 55) y: (roboWaitress y:))
		(super doit: &rest)
	)
)

(instance lites1 of Prop
	(properties
		view 522
		loop 8
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (roboWaitress x:) 1) y: (+ (roboWaitress y:) 57))
	)

	(method (doit)
		(self x: (+ (roboWaitress x:) 1) y: (+ (roboWaitress y:) 57))
		(super doit: &rest)
	)
)

(instance lites2 of Prop
	(properties
		view 522
		loop 8
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (roboWaitress x:) 19) y: (+ (roboWaitress y:) 57))
	)

	(method (doit)
		(self x: (+ (roboWaitress x:) 19) y: (+ (roboWaitress y:) 57))
		(super doit: &rest)
	)
)

(instance lites3 of Prop
	(properties
		view 522
		loop 8
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (roboWaitress x:) 37) y: (+ (roboWaitress y:) 57))
	)

	(method (doit)
		(self x: (+ (roboWaitress x:) 37) y: (+ (roboWaitress y:) 57))
		(super doit: &rest)
	)
)

(instance lites4 of Prop
	(properties
		view 522
		loop 8
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (roboWaitress x:) 55) y: (+ (roboWaitress y:) 57))
	)

	(method (doit)
		(self x: (+ (roboWaitress x:) 55) y: (+ (roboWaitress y:) 57))
		(super doit: &rest)
	)
)

(instance drink of Prop
	(properties
		x 118
		y 140
		noun 6
		view 522
		loop 7
		cel 3
	)

	(method (init)
		(super init: &rest)
		(if (== local3 1)
			(self view: 524 setLoop: 6 cel: 0 setCycle: Fwd x: 118 y: 140)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(34 ; Space_Monkeys_Package
				(= local3 1)
				(gCurRoom setScript: sMonkeysInDrink)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flodrink of Prop
	(properties
		x 102
		y 148
		noun 3
		view 522
		loop 5
		cel 3
	)

	(method (init)
		(super init: &rest)
	)
)

(instance drooldrink of Prop
	(properties
		x 207
		y 139
		noun 1
		view 522
		loop 3
		cel 3
	)

	(method (init)
		(super init: &rest)
	)
)

(instance egoTalker of Talker
	(properties
		x 152
		y 51
		view 524
		signal 16384
		talkWidth 180
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp0 talkWidth)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if showTitle
			(Print addTitle: name)
		)
		(Print
			window: temp1
			posn: x y
			font: font
			width: temp0
			addText: param1
			modeless: 1
			init:
		)
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 170 tailY: 45 xOffset: 40 isBottom: 1)
		(switch local0
			(0
				(self loop: 0 cel: 1 x: 153 y: 50)
			)
			(1
				(self loop: 0 cel: 0)
			)
			(2
				(self loop: 0 cel: 2 x: 153 y: 51)
			)
		)
		(egoMouth init:)
		(super init: 0 0 egoMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance egoMouth of Prop
	(properties
		nsTop 22
		nsLeft 1
		view 524
		loop 1
		signal 16384
	)

	(method (init)
		(switch local0
			(0
				(self setLoop: 3 cel: 0 nsLeft: 5 nsTop: 27)
			)
			(1
				(self setLoop: 1 cel: 0)
			)
			(2
				(self setLoop: 2 cel: 0 nsLeft: 0)
			)
		)
		(super init: &rest)
	)
)

(instance sTalker of Talker
	(properties
		x 69
		y 29
		view 521
		loop 1
		talkWidth 195
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow
			tailX: 112
			tailY: (Localize 60 50 50 50 50)
			xOffset: 100
			isBottom: 1
		)
		(self cel: 0 loop: 1)
		(super init: 0 sBrows sMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance sMouth of Prop
	(properties
		nsTop 26
		nsLeft 21
		view 521
		loop 2
		signal 16384
	)
)

(instance sBrows of Prop
	(properties
		nsTop 14
		nsLeft 12
		view 521
		loop 5
		priority 7
		signal 16
	)
)

(instance qTalker of Talker
	(properties
		x 68
		y 9
		view 523
		loop 1
		talkWidth 200
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow
			tailX: 110
			tailY: 31
			xOffset: 105
			isBottom: (Localize 0 1 1 1 1)
		)
		(switch local1
			(3
				(self loop: 1 cel: 0)
			)
			(4
				(self loop: 1 cel: 0)
			)
			(5
				(self loop: 2 cel: 0)
			)
		)
		(super init: 0 qBrows qMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance qMouth of Prop
	(properties
		nsTop 24
		nsLeft 12
		view 523
		loop 3
		signal 16384
	)

	(method (init)
		(switch local1
			(3
				(self loop: 3 cel: 0)
			)
			(4
				(self loop: 1 cel: 0)
			)
		)
		(super init: &rest)
	)
)

(instance qBrows of Prop
	(properties
		nsTop 11
		nsLeft 11
		view 523
		loop 5
		priority 5
		signal 16
	)
)

(instance dTalker of Talker
	(properties
		x 221
		y 60
		view 525
		loop 3
		talkWidth 200
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp0 talkWidth)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if showTitle
			(Print addTitle: name)
		)
		(Print
			window: temp1
			posn: x y
			font: font
			width: temp0
			addText: param1
			modeless: 1
			init:
		)
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow
			tailX: 195
			tailY: (Localize 50 40 40 40 40)
			xOffset: -70
			isBottom: 1
		)
		(= talkWidth 200)
		(super init: 0 0 dMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance dMouth of Prop
	(properties
		nsTop 11
		nsLeft 2
		view 525
		loop 1
		signal 16384
	)
)

(instance fTalker of Talker
	(properties
		x 65
		y 77
		view 525
		loop 2
		talkWidth 200
	)

	(method (init)
		(switch global125
			(0
				(self loop: 2)
			)
			(else
				(self loop: 4)
			)
		)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow
			tailX: 71
			tailY: (Localize 58 48 48 48 48)
			xOffset: 60
			isBottom: 1
		)
		(super init: 0 0 fMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance fMouth of Prop
	(properties
		nsTop 12
		nsLeft 7
		view 525
		signal 16384
	)
)

(instance bTalker of Narrator
	(properties
		talkWidth 220
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 125 tailY: 30 xOffset: 30)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance theExit of Feature
	(properties
		x 1
		y 1
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global124 11)
				(gCurRoom newRoom: 500)
			)
			(3 ; Walk
				(= global124 11)
				(gCurRoom newRoom: 500)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theFlo of Feature
	(properties
		x 65
		y 55
		noun 4
		nsTop 50
		nsLeft 60
		nsBottom 103
		nsRight 82
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local4
					(0
						(= local4 1)
						(gMessager say: 4 2 0 0) ; "Did you notice the alien sitting with Quirk in the upper booth when we came in, Captain?"
					)
					(else
						(gMessager say: 4 2 1 0) ; "I don't feel like talking much right now, sir. This whole incident has thrown my biorythms out of whack."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDroole of Feature
	(properties
		x 220
		y 50
		noun 2
		nsTop 45
		nsLeft 218
		nsBottom 89
		nsRight 248
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local5
					(0
						(= local5 1)
						(gMessager say: 2 2 0 0) ; "Why did you say 'Uh-oh, here we go again?' when we came into the bar?"
					)
					(else
						(gMessager say: 2 2 1 0) ; "Why don't you get started on your 'project' sir."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

