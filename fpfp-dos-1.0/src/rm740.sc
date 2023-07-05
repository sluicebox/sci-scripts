;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Inset)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm740 0
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance rm740 of FPRoom
	(properties
		picture 720
		style 100
		north 730
		south 260
	)

	(method (init)
		(gEgo
			init:
			normalize:
			setSpeed: 7
			x: 119
			y: 107
			setHeading: 270
			setScale: Scaler 97 75 172 143
		)
		(Palette palSET_INTENSITY 0 256 0)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 27 154 139 122 319 162 319 189 0 189 0 0 319 0 319 145 254 131 242 139 201 130 201 117 149 109 103 103 94 91 70 91 70 99 94 99 97 104 16 115 17 120 74 109 93 120 7 143
					yourself:
				)
		)
		(bench init: setOnMeCheck: 1 2)
		(bigDesk init: setOnMeCheck: 1 4)
		(blackBoard init: setOnMeCheck: 1 8)
		(book1 init: setOnMeCheck: 1 16)
		(book2 init: setOnMeCheck: 1 32)
		(book3 init: setOnMeCheck: 1 64)
		(broom init: setOnMeCheck: 1 128)
		(coatrack init: setOnMeCheck: 1 256)
		(desks init: setOnMeCheck: 1 512)
		(flag init: setOnMeCheck: 1 1024)
		(globe init: setOnMeCheck: 1 2048)
		(lamp init: setOnMeCheck: 1 4096)
		(paintbrushes init: setOnMeCheck: 1 8192)
		(stove init: setOnMeCheck: 1 16384)
		(smallPix init: setOnMeCheck: 1 2)
		(smallPix2 init: setOnMeCheck: 1 2)
		(smallPix3 init: setOnMeCheck: 1 2)
		(woodCarrier init: setOnMeCheck: 1 4)
		(bigMap init:)
		(bookshelf init:)
		(bucket init:)
		(closedWindow init:)
		(kidPix init:)
		(openWindow init:)
		(smallMap init:)
		(washington init:)
		(basementDoor init: hide:)
		(schoolbook init: stopUpd:)
		(schoolbook2 init: stopUpd:)
		(penelope init: setScale: -1 gEgo)
		(self setScript: sAfterBasement)
		(box init: stopUpd: setScale: -1 gEgo)
		(sword1 init: stopUpd:)
		(sword2 init: stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(if (== (gCurRoom script:) sGetReady)
					((gCurRoom script:) cue:)
				else
					(gCurRoom setScript: sFreddyDies)
				)
				(= local8 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gCurRoom setScript: sFastForward)
	)
)

(instance sFastForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_15 1 5 self)
			)
			(1
				(= local9 1)
				(= next sPennyDies)
				(self dispose:)
			)
		)
	)
)

(instance sShowInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(client dispose:)
			)
		)
	)
)

(instance sAfterBasement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(proc0_15 0 5 self)
			)
			(2
				(penelope view: 726 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(localSound number: 2147 play:)
				(basementDoor
					cel: (basementDoor lastCel:)
					setCycle: Beg self
					show:
				)
			)
			(4
				(basementDoor stopUpd:)
				(gMessager say: 18 0 0 0 self) ; "Justice will be done, madam!"
			)
			(5
				(UnLoad 128 726)
				(penelope view: 727 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(penelope setCycle: End)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(gUser canControl: 0)
				(sword1 dispose:)
				(= seconds 10)
			)
			(7
				(gGame handsOff:)
				(gMessager say: 51 0 0 0 self) ; "While you're stupidly standing there taking in the scenery, Penelope decides you're not really interested in fighting back."
			)
			(8
				(UnLoad 128 727)
				(penelope
					view: 740
					setLoop: 2
					setSpeed: 7
					setCycle: Walk
					setMotion: MoveTo 78 112 self
				)
			)
			(9
				(proc0_5 gEgo penelope)
				(= cycles 3)
			)
			(10
				(UnLoad 128 740)
				(pennySound number: 2747 play:)
				(penelope
					view: 744
					cel: 4
					posn: 79 110
					setSpeed: 10
					setCycle: End self
				)
				(gEgo hide:)
			)
			(11
				(= global122 14)
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sGetReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 77 117 self)
			)
			(1
				(gEgo view: 727 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(sword2 dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(UnLoad 128 727)
				(gEgo normalize: setMotion: MoveTo 130 119 self)
			)
			(4
				(UnLoad 128 842)
				(gEgo view: 748 loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(penelope setMotion: MoveTo 51 116 self)
			)
			(6
				(UnLoad 128 802)
				(UnLoad 128 727)
				(penelope
					view: 748
					setLoop: 0
					cel: 0
					setSpeed: 10
					setCycle: CT 7 1 self
				)
				(pennySound number: 745 play:)
			)
			(7
				(gEgo loop: 2 cel: 0 setCycle: End self)
				(penelope setPri: 10 setCycle: End)
			)
			(8
				(localSound number: 2550 play: self)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(= ticks 30)
			)
			(11
				(gMessager say: 18 0 6 0 self) ; "Did I forget to mention downstairs that Meadville Normal had the nation's first female fencing team?"
			)
			(12
				(UnLoad 128 748)
				(penelope
					view: 740
					setLoop: 2
					posn: 65 131
					setCycle: Walk
					setSpeed: 7
					setMotion: MoveTo 90 126 self
				)
				(gEgo view: 741 loop: 3 setSpeed: 7 setCycle: Walk)
			)
			(13
				(= next sStartTheFight)
				(self dispose:)
			)
		)
	)
)

(instance sStartTheFight of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((== local6 3)
				(gCurRoom setScript: sFreddyDies)
			)
			((== local6 -3)
				(gCurRoom setScript: sPennyDies)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMouseDownHandler addToFront: penelope)
				(gGame setCursor: 999 1)
				(LoadMany rsVIEW 740)
				(gGameMusic1 number: 746 loop: -1 play:)
				(switch
					(Print
						font: gUserFont
						mode: 1
						addTitle: 23 0 7 1 740
						addButton: 1 24 0 0 1 0 0 740 ; "I can take her! Hell, she's just a girl!"
						addButton: 2 24 0 0 2 0 18 740 ; "Hmmm. I dunno. That was a pretty impressive half-gainer."
						addButton: 3 24 0 0 3 0 48 740 ; "Oh, my God.   I'm going to die. Give me a break!"
						init:
					)
					(0
						(= local7 1)
						(= local4 2)
						(= local5 5)
						(= cycles 2)
					)
					(1
						(= local7 0)
						(= local4 5)
						(= local5 2)
						(= cycles 2)
					)
					(2
						(= local7 2)
						(= local4 3)
						(= local5 3)
						(= cycles 2)
					)
					(3
						(= local7 1)
						(= local4 2)
						(= local5 5)
						(= cycles 2)
					)
				)
			)
			(1
				(UnLoad 128 748)
				(gGame setCursor: 2 1)
				(gGame handsOn:)
				(gUser canControl: 0)
				(gTheIconBar disable: 0 1 2 3)
				(proc0_9 1000 gCurRoom)
				(= ticks 90)
			)
			(2
				(cond
					((== local0 local4)
						(penelope
							view: 740
							setLoop: 2
							setCycle: Rev
							setMotion:
								MoveTo
								(- (penelope x:) 10)
								(+ (penelope y:) 5)
								self
						)
						(gEgo
							view: 741
							setLoop: 2
							setCycle: Fwd
							setMotion:
								MoveTo
								(- (gEgo x:) 10)
								(+ (gEgo y:) 5)
						)
						(-- local6)
						(= local0 0)
						(= local1 0)
					)
					((== local1 local5)
						(penelope
							view: 740
							setLoop: 2
							setCycle: Fwd
							setMotion:
								MoveTo
								(+ (penelope x:) 10)
								(- (penelope y:) 5)
								self
						)
						(gEgo
							view: 741
							setLoop: 2
							setCycle: Rev
							setMotion:
								MoveTo
								(+ (gEgo x:) 10)
								(- (gEgo y:) 5)
						)
						(++ local6)
						(= local0 0)
						(= local1 0)
					)
					(else
						(= cycles 5)
					)
				)
			)
			(3
				(penelope view: 740 setLoop: 2 cel: 0 cel: (penelope lastCel:))
				(gEgo view: 741 setLoop: 3 cel: 0 setMotion: 0 setCycle: 0)
				(= ticks 30)
			)
			(4
				(penelope loop: (Random 0 1) setCycle: End self)
				(= local3 0)
				(= ticks 60)
			)
			(5
				(if local2
					(++ local1)
				else
					(= local2 1)
				)
				(self changeState: 2)
			)
		)
	)
)

(instance sFreddyDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors:)
				(penelope ignoreActors:)
				(UnLoad 128 740)
				(UnLoad 128 842)
				(gEgo hide:)
				(penelope view: 744 loop: 0 setCycle: End self)
				(pennySound number: 2747 play:)
			)
			(1
				(if local8
					(gMessager say: 50 0 0 0 self) ; "He who fights and runs away..."
				else
					(= cycles 2)
				)
			)
			(2
				(gMouseDownHandler delete: penelope)
				(= global122 14)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sPennyDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_9 0)
				(gGame handsOff:)
				(if (!= local9 1)
					(gEgo setMotion: PolyPath 88 143 self)
					(penelope setMotion: PolyPath 45 149 self)
				else
					(self changeState: 2)
				)
			)
			(1)
			(2
				(UnLoad 128 741)
				(UnLoad 128 740)
				(gEgo
					view: 742
					setLoop: 0
					setCel: 0
					x: 62
					y: 143
					setSpeed: 10
					setPri: 9
				)
				(penelope
					view: 747
					setLoop: 2
					setCel: 0
					x: 50
					y: 153
					setPri: 9
					hide:
				)
				(= cycles 1)
			)
			(3
				(if (== local9 1)
					(proc0_15 0 5 self)
				else
					(= cycles 1)
				)
			)
			(4
				(pennySound number: 2747 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gMessager say: 18 0 2 0 self) ; "Curses! You've foiled me!"
				(if (not local9)
					(gGame points: 35)
				)
			)
			(6
				(gEgo
					view: 747
					setLoop: 0
					setCel: 0
					x: 77
					y: 147
					setCycle: End self
				)
				(penelope show:)
				(kenny init: setScript: sKennyEnters)
			)
			(7
				(gMouseDownHandler delete: penelope)
				(self dispose:)
			)
		)
	)
)

(instance sKennyEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 pause: 1)
				(gGameMusic2 number: 724 loop: 1 play:)
				(kenny
					view: 810
					moveSpeed: 7
					cycleSpeed: 7
					setScale: -1 gEgo
					setCycle: StopWalk -1
					setMotion: PolyPath 283 143 self
				)
			)
			(1
				(gGameMusic2 number: 2701 loop: 1 play: self)
				(kenny view: 749 loop: 0 cel: 0 setCycle: End)
				(UnLoad 128 810)
			)
			(2
				(gGameMusic1 pause: 0)
				(gEgo stopUpd:)
				(penelope stopUpd:)
				(= cycles 5)
			)
			(3
				(gMessager say: 19 0 0 1 self) ; "Why, it's you! I recognize you now! From the old neighborhood. Freddy something!"
			)
			(4
				(gMessager say: 19 0 0 2 self) ; "Good to see you again, Kenny. I hope I didn't hurt your hand out there in the street."
			)
			(5
				(kenny setCycle: Beg self)
			)
			(6
				(kenny stopUpd:)
				(= cycles 3)
			)
			(7
				(gGame handsOn:)
				(if (gEgo has: 49) ; Sharp_Ear
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(8
				(gMessager say: 19 0 0 3 self) ; "Whoa! That was you, out there? I didn't recognize you. Have you done something with your hair?"
			)
			(9
				(if (gEgo has: 49) ; Sharp_Ear
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(10
				(if (gEgo has: 49) ; Sharp_Ear
					(gMessager say: 19 0 3 0 self) ; "It's funny, Pharkas! I thought I killed your sorry ass back in St. Louis!"
					(= next sKennyKillsFreddy)
				else
					(gMessager say: 19 0 4 1 self) ; "Not my hair, Kenny, but with THIS!"
					(= next sFreddyKillsKenny)
				)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance sFreddyKillsKenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 2765 2766 2763)
				(gGame handsOff: points: 35)
				(= ticks 60)
			)
			(1
				(gEgo setLoop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(freddySound number: 2763 play:)
			)
			(3
				(ear init: setSpeed: 7 setMotion: MoveTo 249 106 self)
			)
			(4
				(ear dispose:)
				(freddySound number: 2765 play: self)
				(kenny view: 745 loop: 0 cel: 0 setCycle: End self)
			)
			(5)
			(6
				(freddySound number: 2766 play:)
				(gMessager say: 19 0 4 2 self) ; "Wielding your sharpened ear like a Chinese throwing star, you whip it across the room at Kenny, and it catches him right in the throat!"
			)
			(7
				(kenny loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(kenny stopUpd:)
				(UnLoad 128 747)
				(penelope hide:)
				(gEgo
					view: 743
					loop: 0
					cel: 0
					setPri: 9
					setCycle: CT 3 1 self
				)
				(freddySound number: 2762 play: self)
			)
			(9)
			(10
				(gEgo cel: 3 setCycle: CT 5 1 self)
			)
			(11
				(gTheIconBar disable:)
				(freddySound number: 2762 play:)
				(gEgo setCycle: End self)
			)
			(12
				(gCast eachElementDo: #hide)
				(gCurRoom setInset: rxInset self)
			)
			(13
				(gCast eachElementDo: #show)
				(smoke init: setLoop: 8 setPri: 8 setCycle: End self)
			)
			(14
				(UnLoad 132 2763)
				(UnLoad 132 2765)
				(UnLoad 132 2766)
				(smoke setCycle: ROsc -1 5 9)
				(penelope show:)
				(gEgo view: 746 loop: 0 cel: 0 setCycle: End self)
			)
			(15
				(gGameMusic1 number: 750 loop: 1 play: self)
				(gEgo setScale: 0 setLoop: 1 cel: 0 setCycle: End self)
			)
			(16)
			(17
				(proc0_15 1 5 self)
			)
			(18
				(gCast eachElementDo: #hide)
				(= cycles 3)
			)
			(19
				(gCurRoom drawPic: 750)
				(= cycles 30)
			)
			(20
				(proc0_15 0 5 self)
			)
			(21
				(localSound number: 2751 play: self)
				(ShakeScreen 24 ssFULL_SHAKE)
			)
			(22
				(= gAct 5)
				(gCurRoom newRoom: 26) ; actBreak
			)
		)
	)
)

(instance sKennyKillsFreddy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kenny view: 749 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(1
				(freddySound number: 2101 play:)
				(kenny setCycle: End self)
			)
			(2
				(gEgo view: 747 loop: 3 cel: 0 setPri: -1 setCycle: End self)
			)
			(3
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 101
		y 102
		view 720
		signal 16384
		detailLevel 2
	)
)

(instance ear of Actor
	(properties
		x 119
		y 106
		view 720
		signal 16384
		scaleSignal 5
	)

	(method (init)
		(self
			setCycle: Fwd
			setScale: -1 gEgo
			setLoop: 7
			setStep: 50 -1
			setSpeed: 2
		)
		(|= scaleSignal $0004)
		(super init:)
	)
)

(instance kenny of Actor
	(properties
		x 330
		y 160
		view 810
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; Sharp_Ear
				(gGame handsOff:)
				(gEgo put: 49) ; Sharp_Ear
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance penelope of Actor
	(properties
		x 29
		y 122
		noun 14
		view 726
		signal 16384
	)

	(method (handleEvent event &tmp temp0)
		(event claimed: 1)
		(if (and (not local3) (== gTheCursor 94))
			(= local2 0)
			(= local3 1)
			(= temp0 (/ (+ y nsTop) 2))
			(sStartTheFight ticks: 0)
			(gEgo
				loop: (if (<= (event y:) temp0) 0 else 1)
				setCycle: End sStartTheFight
			)
			(if
				(or
					(and (== loop 0) (<= (event y:) temp0))
					(and (== loop 1) (> (event y:) temp0))
				)
				(= local1 0)
				(++ local0)
				(pennySound number: 2747 play:)
			else
				(= local0 0)
				(++ local1)
			)
		)
	)
)

(instance basementDoor of Prop
	(properties
		x 107
		y 100
		noun 52
		view 720
		loop 3
		signal 16384
	)
)

(instance sword1 of Prop
	(properties
		x 42
		y 64
		noun 21
		view 720
		priority 7
		signal 16400
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 97 75 172 143)
	)
)

(instance sword2 of Prop
	(properties
		x 50
		y 64
		noun 21
		view 720
		cel 1
		priority 7
		signal 16400
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 97 75 172 143)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(penelope setMotion: 0)
				(gEgo get: -1 55) ; Sword
				(gGame points: 1)
				(gCurRoom setScript: sGetReady)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box of Prop
	(properties
		x 33
		y 102
		view 720
		loop 4
		priority 9
		signal 16400
		detailLevel 2
	)
)

(instance schoolbook of View
	(properties
		x 168
		y 172
		noun 22
		view 720
		loop 4
		cel 3
		priority 10
		signal 16400
	)
)

(instance schoolbook2 of View
	(properties
		x 9
		y 104
		noun 22
		view 720
		loop 4
		cel 5
		priority 10
		signal 16400
	)
)

(instance bench of Feature
	(properties
		x 296
		y 124
		noun 25
		nsTop 114
		nsLeft 274
		nsBottom 134
		nsRight 319
	)
)

(instance bigDesk of Feature
	(properties
		x 45
		y 111
		noun 26
	)
)

(instance blackBoard of Feature
	(properties
		x 46
		y 81
		noun 28
	)
)

(instance book1 of Feature
	(properties
		x 49
		y 172
		noun 29
	)
)

(instance book2 of Feature
	(properties
		x 154
		y 180
		noun 30
	)
)

(instance book3 of Feature
	(properties
		x 176
		y 187
		noun 32
	)
)

(instance broom of Feature
	(properties
		x 197
		y 98
		noun 33
	)
)

(instance coatrack of Feature
	(properties
		x 310
		y 85
		noun 36
	)
)

(instance desks of Feature
	(properties
		x 223
		y 158
		noun 37
	)
)

(instance flag of Feature
	(properties
		x 8
		y 70
		noun 38
	)
)

(instance globe of Feature
	(properties
		x 99
		y 171
		noun 39
	)
)

(instance lamp of Feature
	(properties
		x 80
		y 26
		noun 41
	)
)

(instance paintbrushes of Feature
	(properties
		x 16
		y 162
		noun 43
	)
)

(instance stove of Feature
	(properties
		x 235
		y 84
		noun 47
	)
)

(instance bigMap of Feature
	(properties
		x 151
		y 77
		noun 27
		nsTop 60
		nsLeft 141
		nsBottom 94
		nsRight 161
	)
)

(instance bookshelf of Feature
	(properties
		x 171
		y 50
		noun 31
		nsTop 45
		nsLeft 132
		nsBottom 55
		nsRight 211
	)
)

(instance bucket of Feature
	(properties
		x 212
		y 111
		noun 34
		nsTop 103
		nsLeft 207
		nsBottom 119
		nsRight 217
	)
)

(instance closedWindow of Feature
	(properties
		x 182
		y 77
		noun 35
		nsTop 56
		nsLeft 171
		nsBottom 98
		nsRight 194
	)
)

(instance kidPix of Feature
	(properties
		x 208
		y 80
		noun 40
		nsTop 63
		nsLeft 200
		nsBottom 97
		nsRight 216
	)
)

(instance openWindow of Feature
	(properties
		x 284
		y 80
		noun 42
		nsTop 54
		nsLeft 269
		nsBottom 106
		nsRight 299
	)
)

(instance smallMap of Feature
	(properties
		x 130
		y 76
		noun 45
		nsTop 64
		nsLeft 123
		nsBottom 88
		nsRight 138
	)
)

(instance washington of Feature
	(properties
		x 33
		y 44
		noun 48
		nsTop 33
		nsLeft 37
		nsBottom 55
		nsRight 55
	)
)

(instance woodCarrier of Feature
	(properties
		x 251
		y 123
		noun 49
		nsTop 116
		nsLeft 245
		nsBottom 130
		nsRight 257
	)
)

(instance smallPix of Feature
	(properties
		x 99
		y 48
		noun 46
	)
)

(instance smallPix2 of Feature
	(properties
		x 257
		y 80
		noun 46
	)
)

(instance smallPix3 of Feature
	(properties
		x 250
		y 68
		noun 46
	)
)

(instance rxInset of Inset
	(properties
		picture 740
		hideTheCast 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: sShowInset)
	)
)

(instance runTheLoop of Code ; UNUSED
	(properties)

	(method (doit param1 param2 param3)
		(param1
			setLoop: param2
			setCel: 0
			setCycle: End (if (> argc 2) param3 else 0)
		)
	)
)

(instance freddySound of FPSound
	(properties
		flags 1
	)
)

(instance pennySound of FPSound
	(properties
		flags 1
	)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

