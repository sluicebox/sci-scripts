;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Path)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	EndGame 0
)

(local
	[local0 29] = [208 57 199 52 194 48 198 47 202 45 212 44 220 46 227 49 238 52 249 49 261 47 272 45 288 43 294 40 -32768]
	[local29 15] = [270 48 256 53 239 60 226 65 216 70 201 74 184 76 -32768]
	[local44 11] = [90 144 106 151 124 156 141 159 160 162 -32768]
	[local55 19] = [193 162 214 156 240 148 263 140 282 131 297 119 309 109 318 100 332 90 -32768]
	[local74 8] = [140 145 122 122 137 127 129 139]
	local82
	local83
	local84
	local85 = 10
	local86 = 10
	[local87 7] = [3 3 3 2 160 120 0]
)

(procedure (localproc_0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gCast eachElementDo: #dispose 84)
	(switch (gCurRoom script:)
		(awardScript
			(gCurRoom setScript: heroScript)
		)
		(heroScript
			(gCurRoom setScript: bigScript)
		)
		(bigScript
			(gCurRoom setScript: flyScript)
		)
		(flyScript
			(gCurRoom setScript: dragScript)
		)
	)
)

(procedure (localproc_1)
	(SetCursor gTheCursor 1)
	(DisposeScript 983)
	(gCurRoom newRoom: 601) ; CharSave
)

(instance creditWindow of SysWindow
	(properties)
)

(instance endStatus of Code
	(properties)

	(method (doit param1)
		(Format param1 600 0 gScore) ; "So You've Become A Hero! [score %d of 500]"
	)
)

(instance baron of Prop
	(properties
		y 111
		x 157
		view 139
		loop 3
		cel 1
	)
)

(instance bug1 of Prop
	(properties
		y 188
		x 251
		view 139
		loop 5
	)
)

(instance bug2 of Prop
	(properties
		y 188
		x 61
		view 139
		loop 6
	)
)

(instance yoric of Act
	(properties
		y 134
		x -20
		view 139
		loop 7
	)
)

(instance jr of PV
	(properties
		y 106
		x 193
		view 139
		loop 1
		cel 3
	)
)

(instance elsa of PV
	(properties
		y 108
		x 119
		view 139
		loop 1
		cel 2
	)
)

(instance p1 of PV
	(properties
		y 117
		x 157
		view 139
		loop 8
	)
)

(instance p1Mirror of PV
	(properties
		y 117
		x 157
		view 139
		loop 9
	)
)

(instance p2 of PV
	(properties
		y 111
		x 96
		view 139
		loop 1
	)
)

(instance p3 of PV
	(properties
		y 119
		x 220
		view 139
		loop 2
		cel 5
	)
)

(instance p4 of PV
	(properties
		y 123
		x 84
		view 139
		loop 2
		cel 7
	)
)

(instance p5 of PV
	(properties
		y 123
		x 241
		view 139
		loop 2
		cel 8
	)
)

(instance p6 of PV
	(properties
		y 146
		x 301
		view 139
		loop 2
		cel 10
	)
)

(instance p7 of PV
	(properties
		y 158
		x 311
		view 139
		loop 2
		cel 11
	)
)

(instance p8 of PV
	(properties
		y 138
		x 29
		view 139
		loop 2
	)
)

(instance p9 of PV
	(properties
		y 187
		x 306
		view 139
		loop 2
		cel 1
	)
)

(instance p10 of PV
	(properties
		y 151
		x 291
		view 139
		loop 2
		cel 3
	)
)

(instance p11 of PV
	(properties
		y 116
		x 260
		view 139
		loop 2
		cel 4
	)
)

(instance p12 of PV
	(properties
		y 164
		x 16
		view 139
		loop 2
		cel 6
	)
)

(instance p13 of PV
	(properties
		y 181
		x 26
		view 139
		loop 2
		cel 9
	)
)

(instance p14 of PV
	(properties
		y 119
		x 81
		view 139
		loop 2
		cel 2
	)
)

(instance Ger of PV
	(properties
		y 122
		x 62
		view 139
		cel 1
	)
)

(instance Jer of PV
	(properties
		y 114
		x 238
		view 139
		cel 2
	)
)

(instance Kenn of PV
	(properties
		y 114
		x 280
		view 139
		cel 3
	)
)

(instance Lar of PV
	(properties
		y 143
		x 314
		view 139
		cel 4
	)
)

(instance Jeff of PV
	(properties
		y 115
		x 253
		view 139
		cel 5
	)
)

(instance Bob of PV
	(properties
		y 119
		x 294
		view 139
		cel 6
	)
)

(instance Cindy of PV
	(properties
		y 121
		x 45
		view 139
		cel 7
	)
)

(instance Lori of PV
	(properties
		y 182
		x 295
		view 139
		cel 8
	)
)

(instance Cori of PV
	(properties
		y 126
		x 16
		view 139
	)
)

(instance Mark of PV
	(properties
		y 125
		x 30
		view 139
		cel 9
	)
)

(instance hero of View
	(properties
		y 189
		x 157
		view 148
	)
)

(instance sparkle of Prop
	(properties
		y 138
		x 142
		view 148
		loop 1
	)
)

(instance lightning of Prop
	(properties
		view 148
		loop 6
	)
)

(instance hairL of Prop
	(properties
		y 79
		x 131
		view 148
		loop 2
	)
)

(instance hairR of Prop
	(properties
		y 69
		x 138
		view 148
		loop 3
	)
)

(instance hairM of Prop
	(properties
		y 92
		x 168
		view 148
		loop 4
	)
)

(instance cape of Prop
	(properties
		y 144
		x 198
		view 148
		loop 5
	)
)

(instance bck of Act
	(properties
		y 182
		x -50
		yStep 1
		view 101
		loop 8
		xStep 2
	)
)

(instance mid of Act
	(properties
		y 182
		x -17
		yStep 1
		view 101
		loop 8
		cel 1
		xStep 2
	)
)

(instance frt of Act
	(properties
		y 180
		x 16
		yStep 1
		view 101
		loop 8
		cel 2
		xStep 2
	)
)

(instance carpet of Act
	(properties)
)

(instance upPath of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance wizTurn of Path
	(properties)

	(method (at param1)
		(return [local29 param1])
	)
)

(instance fortPath of Path
	(properties)

	(method (at param1)
		(return [local44 param1])
	)
)

(instance awayPath of Path
	(properties)

	(method (at param1)
		(return [local55 param1])
	)
)

(instance glimmer of Prop
	(properties
		y 151
		x 238
		view 101
		loop 4
	)
)

(instance shadow of Prop
	(properties
		view 101
	)

	(method (doit)
		(super doit:)
		(self
			loop:
				(switch (carpet loop:)
					(0 5)
					(1 6)
					(2 6)
					(3 7)
				)
			setPri: (carpet priority:)
			posn: (carpet x:) (+ (carpet y:) 16)
		)
		(if local82
			(= local82 0)
			(self cel: (mod (+ (self cel:) 1) 5))
		else
			(= local82 1)
		)
	)
)

(instance bigCarpet of Act
	(properties)
)

(instance ii of Prop
	(properties
		y 83
		x 242
		view 925
		loop 1
	)
)

(instance trial of Prop
	(properties
		y 167
		x 214
		view 925
		loop 3
	)
)

(instance heros of Prop
	(properties
		y 33
		x 77
		view 909
		loop 1
	)
)

(instance quest of Prop
	(properties
		y 33
		x 246
		view 909
		loop 3
	)
)

(instance claw1 of Prop
	(properties
		y 92
		x 111
		view 906
		priority 3
	)
)

(instance claw2 of Prop
	(properties
		y 87
		x 187
		view 906
		loop 1
		cel 1
		priority 3
	)
)

(instance head of Prop
	(properties
		y 49
		x 147
		view 906
		loop 2
	)
)

(instance flame of Act
	(properties
		view 907
	)
)

(instance EndGame of Rm
	(properties
		picture 39
		style 1
	)

	(method (dispose)
		(SL code: gStatusCode)
		(super dispose:)
	)

	(method (init)
		(DisposeScript 298)
		(DisposeScript 297)
		(DisposeScript 205)
		(DisposeScript 206)
		(DisposeScript 204)
		(Load rsSOUND (SoundFX 99))
		(LoadMany rsPIC 148 906 101 750)
		(LoadMany rsVIEW 139 101 148 925 909 906 907)
		(SolvePuzzle 734 25)
		(SL code: endStatus enable:)
		(super init: &rest)
		(gContMusic stop:)
		(DoSound sndSET_SOUND 1)
		(gGame setSpeed: 6)
		(gKeyHandler eachElementDo: #dispose 84)
		(gKeyHandler add: self)
		(HandsOff)
		(+= [gInvNum 2] 110) ; gold
		(+= [gInvNum 2] 30) ; gold
		(self setScript: awardScript)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(if (== (event message:) KEY_F5)
			(gGame save:)
		)
	)
)

(instance awardScript of Script
	(properties)

	(method (init)
		(elsa init:)
		(gAddToPics add: elsa)
		(if (IsFlag 170)
			(jr init:)
			(gAddToPics add: jr)
		)
		(p1 priority: 6)
		(p1Mirror priority: 6)
		(p2 cel: (if (IsFlag 237) 0 else 1))
		(gAddToPics
			add:
				Mark
				Lori
				Cori
				Cindy
				Bob
				Jeff
				Lar
				Kenn
				Jer
				Ger
				p1
				p1Mirror
				p2
				p3
				p4
				p5
				p6
				p7
				p8
				p9
				p10
				p11
				p12
				p13
				p14
			eachElementDo: #init
			doit:
		)
		(super init: &rest)
		(NormalEgo)
		(gEgo posn: 160 215 init:)
	)

	(method (doit &tmp temp0)
		(= temp0 0)
		(switch (gContMusic prevSignal:)
			(10
				(= temp0 3)
			)
			(20
				(localproc_0)
			)
		)
		(if (> temp0 state)
			(= seconds (= cycles 0))
			(self changeState: temp0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baron init:)
				(bug1 init:)
				(bug2 init:)
				(= cycles 1)
			)
			(1
				(SetCursor gTheCursor 0)
				(gEgo setMotion: MoveTo 160 184)
				(= seconds 3)
			)
			(2
				(gContMusic number: (SoundFX 99) loop: 1 play:)
				(if gHowFast
					(bug1 cycleSpeed: gHowFast setCycle: End)
				else
					(bug1 cel: 2)
				)
				(= seconds 4)
			)
			(3
				(bug1 stopUpd:)
				(if gHowFast
					(bug2 cycleSpeed: gHowFast setCycle: End self)
				else
					(bug2 cel: 2)
					(= cycles 1)
				)
			)
			(4
				(bug2 stopUpd:)
				(= seconds 5)
			)
			(5
				(yoric
					init:
					cycleSpeed: gHowFast
					moveSpeed: gHowFast
					setCycle: Fwd
					setLoop: 7
					setStep: 10 1
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 340 134
				)
				(= seconds 6)
			)
			(6
				(gEgo setMotion: MoveTo 160 120)
				(= seconds 4)
			)
			(7
				(baron cycleSpeed: 2 setCycle: End)
				(= seconds 4)
			)
			(8
				(gEgo
					view: 139
					setLoop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= seconds 12)
			)
			(9
				(localproc_0)
			)
		)
	)
)

(instance post1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(creditWindow color: 0 back: 7)
				(if (and (IsFlag 325) (IsFlag 170))
					(Print ; "Thus the hero from the East Freed the man from form of beast Saved beauty from the brigand's band And forced the Ogress to flee the land."
						600
						1
						#at
						2
						30
						#width
						84
						#mode
						1
						#dispose
						#time
						14
						#window
						creditWindow
					)
				else
					(Print ; "You have defeated the brigands And become a true Hero of Spielburg"
						600
						2
						#at
						2
						30
						#width
						84
						#mode
						1
						#dispose
						#time
						14
						#window
						creditWindow
					)
				)
			)
		)
	)
)

(instance post2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(creditWindow color: 14 back: 9)
				(if (IsFlag 325)
					(= local84
						(Print ; "The brigand band has been dispersed Their treasure has been reimbursed."
							600
							3
							#at
							224
							70
							#width
							80
							#mode
							1
							#dispose
							#time
							14
							#window
							creditWindow
						)
					)
				else
					(= local84
						(Print ; "So with the Kattas and the Merchant You board a magic carpet to the land of Shapeir."
							600
							4
							#at
							224
							70
							#width
							80
							#mode
							1
							#dispose
							#time
							10
							#window
							creditWindow
						)
					)
				)
				(= gModelessDialog 0)
				(= seconds 5)
			)
			(2
				(if (IsFlag 325)
					(Print ; "And so with Kattas and Abdulla Doo You bid the valley a fond adieu."
						600
						5
						#at
						6
						14
						#width
						80
						#mode
						1
						#dispose
						#time
						16
						#window
						creditWindow
					)
				else
					(Print ; "Unfortunately, since the Baron is still cursed, and Baba Yaga remains to work her evil deeds, terror will continue to rule the land."
						600
						6
						#at
						6
						14
						#width
						100
						#mode
						1
						#dispose
						#time
						23
						#window
						creditWindow
					)
				)
				(= seconds 8)
			)
			(3
				(local84 dispose:)
			)
		)
	)
)

(instance heroScript of Script
	(properties)

	(method (init)
		(sparkle setCycle: Fwd cycleSpeed: 3)
		(lightning setCycle: Fwd cycleSpeed: 0)
		(hairL setCycle: Fwd cycleSpeed: 1)
		(hairR setCycle: Fwd cycleSpeed: 1)
		(hairM setCycle: Fwd cycleSpeed: 1)
		(cape setCycle: Fwd cycleSpeed: 2)
		(hero setPri: 3 init: addToPic:)
		(sparkle setPri: 5 init:)
		(lightning setPri: 2 init:)
		(hairL setPri: 5 init:)
		(hairR setPri: 5 init:)
		(hairM setPri: 5 init:)
		(cape setPri: 2 init:)
		(= local83 55)
		(super init: &rest)
		(SL disable:)
		(MenuBar hide:)
		(gCurRoom style: 0 drawPic: 148)
		(self setScript: post1)
	)

	(method (doit)
		(if (== (gContMusic prevSignal:) 30)
			(localproc_0)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (* (Random 0 3) 2))
				(sparkle
					setCycle: End self
					x: [local74 temp0]
					y: [local74 (+ temp0 1)]
				)
				(lightning
					setCycle: End
					cycleSpeed: 0
					x: (Random 70 245)
					y: (Random 25 45)
				)
			)
			(1
				(lightning cel: 0 setCycle: 0)
				(sparkle cel: 0 setCycle: 0)
				(if local83
					(-- local83)
					(self changeState: 0)
				else
					(localproc_0)
				)
			)
		)
	)
)

(instance bigScript of Script
	(properties)

	(method (init &tmp temp0 temp1)
		(bck init:)
		(mid init:)
		(frt init:)
		(= temp0
			(switch gHowFast
				(0 4)
				(1 3)
				(2 2)
			)
		)
		(= temp1
			(switch gHowFast
				(0 2)
				(1 1)
				(2 1)
			)
		)
		(bck setStep: temp0 temp1)
		(mid setStep: temp0 temp1)
		(frt setStep: temp0 temp1)
		(super init: &rest)
		(gCurRoom style: 7 drawPic: 750)
		(self setScript: post2)
	)

	(method (doit &tmp temp0)
		(if (== (gContMusic prevSignal:) 40)
			(localproc_0)
		)
		(if (= temp0 (Random 0 2))
			(mid y: (- (+ (bck y:) temp0) 1))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bck
					ignoreActors:
					setLoop: 8
					setCel: 0
					setMotion: MoveTo 340 22
				)
				(mid
					ignoreActors:
					setLoop: 8
					setCel: 1
					setMotion: MoveTo 373 22
				)
				(frt
					ignoreActors:
					setLoop: 8
					setCel: 2
					setMotion: MoveTo 406 20
				)
			)
		)
	)
)

(instance flyScript of Script
	(properties)

	(method (doit)
		(if (== (gContMusic prevSignal:) 50)
			(localproc_0)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(carpet
			view: 101
			setLoop: 0
			setCel: 0
			setStep: 1 1
			posn: 208 57
			ignoreActors: 1
			init:
		)
		(glimmer cycleSpeed: 1 setCycle: Fwd init:)
		(shadow init:)
		(gCurRoom style: 1 drawPic: 101)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carpet
					setStep: 2 2
					setScript: cornyCredits
					setMotion: upPath self
				)
			)
			(1
				(carpet
					setLoop: 1
					cel: 0
					setCycle: 0
					setMotion: MoveTo 305 39 self
				)
			)
			(2
				(carpet cel: 1 setPri: 8 setMotion: MoveTo 311 42 self)
			)
			(3
				(carpet cel: 2 setMotion: MoveTo 300 52 self)
			)
			(4
				(carpet cel: 3 setMotion: MoveTo 291 56 self)
			)
			(5
				(carpet setMotion: wizTurn self)
			)
			(6
				(carpet setMotion: MoveTo 169 81 self)
			)
			(7
				(carpet setMotion: MoveTo 155 85 self)
			)
			(8
				(carpet cel: 4 setMotion: MoveTo 135 83 self)
			)
			(9
				(carpet cel: 5 setMotion: MoveTo 128 74 self)
			)
			(10
				(carpet cel: 6 setMotion: MoveTo 138 71 self)
			)
			(11
				(carpet setMotion: MoveTo 149 68 self)
			)
			(12
				(carpet cel: 7 setMotion: MoveTo 165 64 self)
			)
			(13
				(carpet cel: 8 setMotion: MoveTo 181 66 self)
			)
			(14
				(carpet cel: 9 setMotion: MoveTo 192 70 self)
			)
			(15
				(carpet cel: 10 setMotion: MoveTo 182 76 self)
			)
			(13
				(carpet cel: 11 setMotion: MoveTo 168 88 self)
			)
			(14
				(carpet cel: 12 setMotion: MoveTo 158 100 self)
			)
			(15
				(carpet cel: 13 setMotion: MoveTo 140 107 self)
			)
			(16
				(carpet cel: 14 setMotion: MoveTo 130 115 self)
			)
			(17
				(carpet setPri: 0 setMotion: MoveTo 115 122 self)
			)
			(18
				(carpet setMotion: MoveTo 99 127 self)
			)
			(19
				(carpet setMotion: MoveTo 88 131 self)
			)
			(20
				(carpet setLoop: 2 cel: 0 setMotion: MoveTo 69 127 self)
			)
			(21
				(carpet setMotion: MoveTo 57 114 self)
			)
			(22
				(carpet setPri: 8 setMotion: MoveTo 46 106 self)
			)
			(23
				(carpet cel: 1 setMotion: MoveTo 49 119 self)
			)
			(24
				(carpet setMotion: MoveTo 60 130 self)
			)
			(25
				(carpet setMotion: MoveTo 70 138 self)
			)
			(26
				(carpet cel: 2 setMotion: fortPath self)
			)
			(27
				(creditWindow color: 9 back: 1)
				(carpet
					setLoop: 3
					cel: 0
					cycleSpeed: 2
					setCycle: Fwd
					setMotion: awayPath
				)
			)
		)
	)
)

(instance dragScript of Script
	(properties)

	(method (doit)
		(switch (gContMusic prevSignal:)
			(60
				(gContMusic prevSignal: 0)
				(self changeState: 1)
			)
			(70
				(gContMusic prevSignal: 0)
				(self changeState: 3)
			)
			(80
				(gContMusic prevSignal: 0)
				(self changeState: 7)
			)
			(90
				(gContMusic prevSignal: 0)
				(self changeState: 8)
			)
		)
		(if (not (gContMusic loop:))
			(self changeState: 13)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 906)
				(bigCarpet
					init:
					view: 925
					setLoop: 0
					posn: -10 100
					setStep: 3 3
					moveSpeed: 0
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 340 92
				)
			)
			(1
				(claw1 cel: 0 init: cycleSpeed: 2 setCycle: End self)
			)
			(2
				(ShakeScreen 3)
			)
			(3
				(claw1 stopUpd: addToPic:)
				(claw2 cel: 0 init: cycleSpeed: 2 setCycle: End)
				(= cycles local86)
			)
			(4
				(claw2 stopUpd: addToPic:)
				(ShakeScreen 3)
				(head
					setLoop: 2
					cel: 0
					setPri: 6
					posn: 143 68
					init:
					cycleSpeed: (if (== gHowFast 0) 0 else 2)
					setCycle: End self
				)
			)
			(5
				(head setLoop: 3 cel: 0 posn: 147 49 init: setCycle: CT 4 1)
				(= seconds 4)
			)
			(6
				(heros init: stopUpd:)
				(quest init: stopUpd:)
			)
			(7
				(ii init: setCycle: End)
			)
			(8
				(head setCycle: CT 5 1 self)
			)
			(9
				(flame
					posn: 145 76
					setLoop: 0
					setCel: -1
					cel: 0
					setPri: 8
					ignoreActors:
					illegalBits: 0
					init:
					xStep: 3
					yStep: 6
					setMotion: MoveTo 256 228
					setCycle: End self
				)
			)
			(10
				(trial init: cycleSpeed: 0 setCycle: End self)
				(flame
					setLoop: 1
					cel: 0
					cycleSpeed: (if (== gHowFast 0) 0 else 1)
					setMotion: MoveTo 256 228
					setCycle: Fwd
				)
				(head setCycle: End)
			)
			(11
				(trial setLoop: 4 setCycle: Fwd)
				(ii setLoop: 2 setCycle: End self)
			)
			(12
				(ii setCycle: Fwd)
				(heros setCycle: Fwd)
				(quest setCycle: Fwd)
			)
			(13
				(localproc_1)
			)
		)
	)
)

(instance cornyCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(creditWindow back: 9 color: 14)
				(Print 600 7 #at 40 30 #width 120 #mode 1 #dispose #time 6 #window creditWindow) ; "Script and Whip: Lori Ann Cole"
				(= seconds 6)
			)
			(2
				(creditWindow color: 14 back: 6)
				(Print 600 8 #at 185 135 #width 120 #mode 1 #dispose #time 6 #window creditWindow) ; "Vicious Art: Kenn Nishiuye"
				(= seconds 6)
			)
			(3
				(creditWindow color: 11 back: 3)
				(Print 600 9 #at 50 70 #width 110 #mode 1 #dispose #time 3 #window creditWindow) ; "Silly Stuff: Jeff Crowe"
				(= seconds 3)
			)
			(4
				(creditWindow color: 13 back: 1)
				(Print ; "Next Generation Graphics: Jerry Moore"
					600
					10
					#at
					178
					132
					#width
					110
					#mode
					1
					#dispose
					#time
					5
					#window
					creditWindow
				)
				(= seconds 5)
			)
			(5
				(creditWindow back: 8 color: 7)
				(Print 600 11 #at 80 130 #width 130 #mode 1 #dispose #time 6 #window creditWindow) ; "Marathon Coding and Rude Puns: Bob Fischbach"
				(= seconds 7)
			)
			(6
				(creditWindow color: 10 back: 2)
				(Print 600 12 #at 30 100 #width 130 #mode 1 #dispose #time 5 #window creditWindow) ; "Algorithmic Gyrations: Larry Scott"
				(= seconds 5)
			)
			(7
				(creditWindow color: 13 back: 1)
				(Print 600 13 #at 160 22 #width 110 #mode 1 #dispose #time 5 #window creditWindow) ; "Cameo Coding: Jerry Shaw"
				(= seconds 6)
			)
			(8
				(creditWindow back: 9 color: 14)
				(Print 600 14 #at 40 30 #width 110 #mode 1 #dispose #time 5 #window creditWindow) ; "Insidious System Software: Corey Cole"
				(= seconds 6)
			)
			(9
				(creditWindow color: 10 back: 2)
				(Print 600 15 #at 80 50 #width 130 #mode 1 #dispose #time 6 #window creditWindow) ; "Magical Mystical Music: Mark Seibert"
				(= seconds 7)
			)
			(10
				(creditWindow color: 14 back: 6)
				(Print 600 16 #at 40 32 #width 120 #mode 1 #dispose #time 6 #window creditWindow) ; "Underground Art: Cindy Walker"
				(= seconds 7)
			)
			(11
				(creditWindow color: 11 back: 3)
				(Print 600 17 #at 130 30 #width 140 #mode 1 #dispose #time 6 #window creditWindow) ; "Yogic Sympathy and Support: Guruka Singh Khalsa"
				(= seconds 7)
			)
			(12
				(creditWindow back: 9 color: 1)
				(Print 600 18 #at -1 26 #width 260 #mode 1 #dispose #time 15 #window creditWindow) ; "Promotional Considerations: Erasmus' Rootin' Tootin' Root Beer Spielburg Chamber of Commerce Shapeir Magic Carpet Tours Famous Adventurer's Correspondence School for Heroes"
			)
		)
	)
)

