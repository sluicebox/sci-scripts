;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 822)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use TopWindow)
(use Full)
(use Interface)
(use LoadMany)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmEndCartoon3 0
)

(local
	saveEgoX
	saveEgoY
	egoView
	egoLoop
	egoCel
	firstAdded
	[msgStr 500]
)

(procedure (DoTalk speaker parmColor parmBack timeToCue toCue)
	(TopWindow color: parmColor back: parmBack)
	(Print
		&rest
		#font
		gUserFont
		#title
		speaker
		#window
		TopWindow
		#width
		280
		#mode
		1
		#dispose
		toCue
		#time
		timeToCue
	)
)

(procedure (AddToPicCrowd)
	(if firstAdded
		(gCurRoom picture: 230 style: 16 drawPic: 230)
	else
		(= firstAdded 1)
		(gCurRoom picture: 230 style: 7 drawPic: 230)
	)
	(InitAddToPics
		sultan
		guard2Body
		guard3Body
		crowd
		crowd2
		crowd3
		crowd4
		crowd5
		ShemaShameen
		Walid
		Aziza
	)
	(NormalEgo)
	(gEgo illegalBits: 0 ignoreActors: view: 4 init:)
	(if saveEgoX
		(ResetEgo)
	)
	(if gHowFast
		(guard1 init:)
		(guard2 init:)
		(guard3 init:)
		(haremGirls init:)
		(haremGirlsBody init:)
	else
		(InitAddToPics
			guard1Slow
			guard2Slow
			guard3Slow
			haremGirlsSlow
			haremGirlsBodySlow
		)
		(gEgo stopUpd:)
	)
	(Zayishah init: stopUpd:)
	(saurus init: stopUpd:)
	(jaafar init: stopUpd:)
	(Zayishah init: stopUpd:)
	(Rakeesh init: stopUpd:)
)

(procedure (AddToPicBorder paletteToUse)
	(SaveEgo)
	(gCast eachElementDo: #dispose)
	(gCurRoom picture: 2 style: 6 drawPic: 2)
	(gAddToPics
		add: frame1 frame2 frame3 frame4 frame5 frame6 frame7 frame8
		eachElementDo: #palette paletteToUse
		eachElementDo: #init
		doit:
	)
)

(procedure (JaafarTalk timeToCue toCue)
	(DoTalk {Ja'afar:} 12 0 timeToCue toCue &rest)
)

(procedure (ZayishahTalk timeToCue toCue)
	(zayishahHead setCycle: Full 2)
	(DoTalk {Zayishah:} 0 11 timeToCue toCue &rest)
)

(procedure (EmirTalk timeToCue toCue)
	(saurusHead setCycle: Full 2)
	(DoTalk {Emir:} 15 0 timeToCue toCue &rest)
)

(procedure (SultanTalk timeToCue toCue)
	(sultanFace setCycle: Full 2)
	(DoTalk {Harun al-Rashid:} 5 15 timeToCue toCue &rest)
)

(procedure (RakeeshTalk timeToCue toCue)
	(rakeeshHead setCycle: Full 2)
	(DoTalk {Rakeesh:} 0 11 timeToCue toCue &rest)
)

(procedure (SaveEgo)
	(= saveEgoX (gEgo x:))
	(= saveEgoY (gEgo y:))
	(= egoView (gEgo view:))
	(= egoLoop (gEgo loop:))
	(= egoCel (gEgo cel:))
)

(procedure (ResetEgo)
	(gEgo x: saveEgoX)
	(gEgo y: saveEgoY)
	(gEgo view: egoView)
	(gEgo loop: egoLoop)
	(gEgo cel: egoCel)
)

(instance rmEndCartoon3 of Rm
	(properties
		picture 2
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 230 231 4 233 235 237 238 239 242 820 50)
		(LoadMany rsPIC 230 900)
		(Load rsSCRIPT 78)
		(Load rsSOUND 830)
		(super init:)
		(gEgo illegalBits: 0 ignoreActors:)
		(self setScript: endCartoon2)
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance endCartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(AddToPicCrowd)
				(= cycles 1)
			)
			(1
				(SetCursor gTheCursor 0)
				(self setScript: zayishahSpeak self)
			)
			(2
				(JaafarTalk 4 self 822 0)
			)
			(3
				(self setScript: saurusSpeak self)
			)
			(4
				(if (not (IsFlag 135)) ; fRobbedPurse
					(JaafarTalk 4 self 822 1)
				else
					(self cue:)
				)
			)
			(5
				(if (IsFlag 135) ; fRobbedPurse
					(self cue:)
				else
					(self setScript: sultanSpeak self)
				)
			)
			(6
				(CheckPaladin)
				(if (== gHeroType 3) ; Paladin
					(self setScript: rakeeshSpeak self)
				else
					(self cue:)
				)
			)
			(7
				(if (!= gHeroType 3) ; Paladin
					(gEgo setHeading: 180 self)
				else
					(self cue:)
				)
			)
			(8
				(if (!= gHeroType 3) ; Paladin
					(gEgo view: 50 loop: 0 setCycle: End)
				)
				(= seconds 8)
			)
			(9
				(HandsOn)
				(gCSound fade:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 900)
				(= seconds 2)
			)
			(10
				(gCSound number: 830 loop: -1 play:)
				(= seconds 5)
			)
			(11
				(gCurRoom newRoom: 840) ; CharSave
				(self dispose:)
			)
		)
	)
)

(instance zayishahSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Zayishah setCycle: End self)
			)
			(1
				(Face gEgo Zayishah)
				(DoTalk
					{Zayishah:}
					0
					11
					4
					self
					(Format @msgStr {I shall speak for %s.} @gUserName)
				)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(- (Zayishah x:) 25)
						(+ (Zayishah y:) 5)
						self
				)
			)
			(3
				(Face gEgo Zayishah)
				(= seconds 2)
			)
			(4
				(AddToPicBorder 0)
				(InitAddToPics zayishahBody egoBodyRight egoHeadRight)
				(zayishahHead init:)
				(ZayishahTalk 6 self 822 2)
			)
			(5
				(ZayishahTalk 8 self 822 3)
			)
			(6
				(ZayishahTalk 6 self 822 4)
			)
			(7
				(ZayishahTalk 4 self 822 5)
			)
			(8
				(zayishahHead setCel: 0)
				(= seconds 2)
			)
			(9
				(AddToPicCrowd)
				(zayishahHead dispose:)
				(= cycles 2)
			)
			(10
				(Zayishah setCycle: Beg)
				(= seconds 4)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance saurusSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(saurus setCycle: End self)
			)
			(1
				(Face gEgo saurus)
				(DoTalk {Saurus:} 0 15 4 self 822 6) ; "Gronk."
			)
			(2
				(JaafarTalk 4 self 822 7)
			)
			(3
				(gEgo setMotion: MoveTo 158 118 self)
			)
			(4
				(HighPrint 822 8 103 25 4) ; "You offer a dispel potion which was prepared by Harik for this occasion."
				(Face gEgo saurus)
				(= seconds 2)
			)
			(5
				(gEgo
					view: 820
					loop: 7
					cel: 0
					cycleSpeed: 1
					setCycle: CT 2 1
				)
				(= seconds 3)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					posn: (- (gEgo x:) 4) (- (gEgo y:) 2)
					view: 4
					loop: 5
				)
				(= cycles 5)
			)
			(8
				(AddToPicBorder 0)
				(InitAddToPics egoBodyLeft egoHeadLeft)
				(saurusBody init:)
				(= seconds 2)
			)
			(9
				(saurusBody palette: 2)
				(= cycles 5)
			)
			(10
				(saurusBody palette: 3)
				(= cycles 5)
			)
			(11
				(saurusBody palette: 4)
				(= cycles 5)
			)
			(12
				(saurusBody cel: 1 palette: 5)
				(= cycles 5)
			)
			(13
				(saurusBody palette: 6)
				(= cycles 5)
			)
			(14
				(saurusBody palette: 7)
				(= cycles 5)
			)
			(15
				(saurusBody cel: 2 palette: 4)
				(= cycles 5)
			)
			(16
				(saurusBody palette: 3)
				(= cycles 5)
			)
			(17
				(saurusBody palette: 2)
				(= cycles 5)
			)
			(18
				(saurusBody palette: 1)
				(= cycles 5)
			)
			(19
				(saurusHead init:)
				(EmirTalk 8 self 822 9)
			)
			(20
				(EmirTalk
					8
					self
					(Format
						@msgStr
						{Yet this man showed me his courage, kindness, and honor, and I knew that %s would restore me.}
						@gUserName
					)
				)
			)
			(21
				(= seconds 2)
			)
			(22
				(AddToPicCrowd)
				(saurus
					posn: (- (gEgo x:) 23) (+ (gEgo y:) 4)
					view: 820
					loop: 6
					cel: 0
				)
				(gEgo view: 4 loop: 5 cel: 0)
				(saurusHead dispose:)
				(saurusBody dispose:)
				(= cycles 2)
			)
			(23
				(self dispose:)
			)
		)
	)
)

(instance sultanSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jaafar setCycle: End self)
			)
			(1
				(Face gEgo jaafar)
				(DoTalk
					{Ja'Afar:}
					5
					15
					4
					self
					(Format @msgStr {The Sultan shall speak for %s.} @gUserName)
				)
			)
			(2
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (- (jaafar x:) 25) (+ (jaafar y:) 3) self
				)
			)
			(3
				(Face gEgo jaafar)
				(= seconds 2)
			)
			(4
				(AddToPicBorder 3)
				(InitAddToPics jaafarBody egoHeadRight sultanHead)
				(egoBodyR loop: 5 init: stopUpd:)
				(sultanFace init:)
				(jaafarArms init: stopUpd:)
				(jaafarHeadLook init: setCycle: End)
				(SultanTalk 6 self 822 10)
			)
			(5
				(SultanTalk 6 self 822 11)
			)
			(6
				(SultanTalk 4 self 822 12)
			)
			(7
				(SultanTalk 4 self 822 13)
			)
			(8
				(SultanTalk 4 self 822 14)
			)
			(9
				(SultanTalk 4 self 822 15)
			)
			(10
				(sultanFace setCycle: 0 setCel: 0)
				(jaafarHeadLook setCycle: Beg)
				(jaafarArms setCycle: End self)
			)
			(11
				(egoBodyR loop: 3 setPri: 13 setCycle: End)
				(= seconds 2)
			)
			(12
				(AddToPicCrowd)
				(egoBodyR dispose:)
				(sultanFace dispose:)
				(jaafarArms dispose:)
				(jaafarHeadLook dispose:)
				(= cycles 2)
			)
			(13
				(jaafar setCycle: Beg)
				(= seconds 3)
			)
			(14
				(self dispose:)
			)
		)
	)
)

(instance rakeeshSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JaafarTalk 8 self 822 16)
			)
			(1
				(Rakeesh setCycle: End self)
			)
			(2
				(RakeeshTalk
					4
					self
					(Format @msgStr {I shall speak for %s.} @gUserName)
				)
			)
			(3
				(Face gEgo Rakeesh)
				(= seconds 2)
			)
			(4
				(gEgo
					setMotion:
						MoveTo
						(- (Rakeesh x:) 30)
						(+ (Rakeesh y:) 10)
						self
				)
			)
			(5
				(Face gEgo Rakeesh)
				(= seconds 2)
			)
			(6
				(AddToPicBorder 0)
				(InitAddToPics rakeeshBody egoHeadL)
				(egoBodyL init: stopUpd:)
				(rakeeshHead init:)
				(rakeeshArms init: stopUpd:)
				(RakeeshTalk 6 self 822 17)
			)
			(7
				(RakeeshTalk 6 self 822 18)
			)
			(8
				(RakeeshTalk 6 self 822 19)
			)
			(9
				(RakeeshTalk 4 self 822 20)
			)
			(10
				(RakeeshTalk 4 self 822 21)
			)
			(11
				(RakeeshTalk
					6
					self
					(Format
						@msgStr
						{give to %s my sword, "Soulforge".}
						@gUserName
					)
				)
				(rakeeshArms setCycle: End)
			)
			(12
				(rakeeshHead setCycle: 0 setCel: 0)
				(rakeeshArms stopUpd:)
				(egoBodyL loop: 2 setCycle: End)
				(RakeeshTalk 4 self 822 22)
				(SolvePuzzle 683 10)
			)
			(13
				(= seconds 2)
			)
			(14
				(AddToPicCrowd)
				(egoBodyL dispose:)
				(rakeeshHead dispose:)
				(rakeeshArms dispose:)
				(Rakeesh loop: 9)
				(= cycles 2)
			)
			(15
				(gEgo
					view: 820
					loop: 10
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(Rakeesh setCycle: Beg)
			)
			(16
				(flamingSword
					x: (- (gEgo x:) 4)
					y: (- (gEgo y:) 53)
					init:
					setCycle: Fwd
				)
				(self dispose:)
			)
		)
	)
)

(instance sultan of PicView
	(properties
		x 220
		y 95
		view 820
		loop 12
	)
)

(instance guard1 of Extra
	(properties
		x 53
		y 189
		view 231
		cel 2
		cycleSpeed 3
		minPause 20
		maxPause 60
		minCycles 4
		maxCycles 8
	)
)

(instance guard2 of Extra
	(properties
		x 298
		y 133
		view 231
		loop 1
		priority 15
		signal 16
		cycleSpeed 3
		minPause 20
		maxPause 60
		minCycles 4
		maxCycles 8
	)
)

(instance guard3 of Extra
	(properties
		x 252
		y 145
		view 231
		loop 3
		cel 1
		priority 16
		signal 16
		cycleSpeed 3
		minPause 20
		maxPause 60
		minCycles 4
		maxCycles 8
	)
)

(instance haremGirls of Extra
	(properties
		x 26
		y 27
		view 231
		loop 5
		cel 3
		cycleSpeed 3
		minPause 20
		maxPause 60
		minCycles 4
		maxCycles 8
	)
)

(instance haremGirlsBody of Extra
	(properties
		x 28
		y 55
		view 231
		loop 6
		cel 3
		priority 12
		signal 16
		cycleSpeed 3
		minPause 20
		maxPause 60
		minCycles 4
		maxCycles 8
	)
)

(instance guard1Slow of PicView
	(properties
		x 53
		y 189
		view 231
		cel 2
	)
)

(instance guard2Slow of PicView
	(properties
		x 298
		y 133
		view 231
		loop 1
		priority 15
		signal 16
	)
)

(instance guard3Slow of PicView
	(properties
		x 252
		y 145
		view 231
		loop 3
		cel 1
		priority 16
		signal 16
	)
)

(instance haremGirlsSlow of PicView
	(properties
		x 26
		y 27
		view 231
		loop 5
		cel 3
	)
)

(instance haremGirlsBodySlow of PicView
	(properties
		x 28
		y 55
		view 231
		loop 6
		cel 3
		priority 12
		signal 16
	)
)

(instance saurus of Prop
	(properties
		x 101
		y 128
		view 820
		loop 4
	)
)

(instance ShemaShameen of PicView
	(properties
		x 206
		y 150
		view 820
		loop 1
	)
)

(instance Zayishah of Prop
	(properties
		x 266
		y 129
		view 820
		loop 2
		cycleSpeed 3
	)
)

(instance Walid of PicView
	(properties
		x 160
		y 167
		view 820
	)
)

(instance Aziza of PicView
	(properties
		x 114
		y 165
		view 820
		loop 3
	)
)

(instance Rakeesh of Prop
	(properties
		x 170
		y 93
		view 820
		loop 8
	)
)

(instance jaafar of Prop
	(properties
		x 241
		y 100
		view 820
		loop 13
		cycleSpeed 2
	)
)

(instance guard2Body of PicView
	(properties
		x 298
		y 166
		view 231
		loop 2
		priority 15
		signal 16
	)
)

(instance guard3Body of PicView
	(properties
		x 242
		y 122
		view 231
		loop 4
		priority 15
		signal 16
	)
)

(instance crowd of PicView
	(properties
		x 150
		y 59
		view 230
		priority 0
		signal 16
	)
)

(instance crowd2 of PicView
	(properties
		x 43
		y 68
		view 230
		priority 0
		signal 16
	)
)

(instance crowd3 of PicView
	(properties
		x 291
		y 64
		view 230
		loop 1
		priority 0
		signal 16
	)
)

(instance crowd4 of PicView
	(properties
		x 288
		y 73
		view 230
		loop 1
		priority 2
		signal 16
	)
)

(instance crowd5 of PicView
	(properties
		x 229
		y 61
		view 230
	)
)

(instance egoBodyR of Prop
	(properties
		x 105
		y 156
		view 233
		loop 5
		signal 16384
	)
)

(instance egoHeadR of PicView ; UNUSED
	(properties
		x 83
		y 119
		view 233
		loop 1
		signal 16384
	)
)

(instance egoBodyL of Prop
	(properties
		x 223
		y 156
		view 233
		loop 4
		signal 16384
	)
)

(instance egoHeadL of PicView
	(properties
		x 245
		y 119
		view 233
		signal 16384
	)
)

(instance egoBodyRight of PicView
	(properties
		x 105
		y 156
		view 233
		loop 5
	)
)

(instance egoHeadRight of PicView
	(properties
		x 83
		y 119
		view 233
		loop 1
	)
)

(instance egoBodyLeft of PicView
	(properties
		x 210
		y 156
		view 233
		loop 4
	)
)

(instance egoHeadLeft of PicView
	(properties
		x 231
		y 119
		view 233
	)
)

(instance zayishahBody of PicView
	(properties
		x 217
		y 156
		view 235
	)
)

(instance zayishahHead of Prop
	(properties
		x 222
		y 115
		view 235
		loop 1
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance saurusBody of View
	(properties
		x 97
		y 156
		view 237
		signal 16384
	)
)

(instance saurusHead of Prop
	(properties
		x 97
		y 98
		view 237
		loop 4
		priority 12
		signal 16400
		cycleSpeed 2
	)
)

(instance jaafarBody of PicView
	(properties
		x 202
		y 156
		view 239
		signal 16384
	)
)

(instance sultanHead of PicView
	(properties
		x 181
		y 55
		view 239
		cel 1
		priority 10
		signal 16400
	)
)

(instance sultanFace of Prop
	(properties
		x 177
		y 96
		view 239
		loop 1
		priority 12
		signal 16400
		cycleSpeed 2
	)
)

(instance jaafarHeadLook of Prop
	(properties
		x 243
		y 96
		view 239
		loop 2
		priority 12
		signal 16
	)
)

(instance jaafarArms of Prop
	(properties
		x 270
		y 110
		view 239
		loop 3
		priority 12
		signal 16400
	)
)

(instance rakeeshBody of PicView
	(properties
		x 85
		y 156
		view 238
		loop 1
	)
)

(instance rakeeshHead of Prop
	(properties
		x 95
		y 92
		view 238
		cel 4
		priority 12
		signal 16400
		cycleSpeed 2
	)
)

(instance rakeeshArms of Prop
	(properties
		x 120
		y 133
		view 238
		loop 2
		priority 12
		signal 16
	)
)

(instance flamingSword of Prop
	(properties
		view 820
		loop 11
		priority 9
		signal 16
	)
)

(instance frame1 of PicView
	(properties
		x 81
		y 33
		view 242
		priority 15
		signal 16
	)
)

(instance frame2 of PicView
	(properties
		x 239
		y 33
		view 242
		loop 1
		priority 15
		signal 16
	)
)

(instance frame3 of PicView
	(properties
		x 19
		y 94
		view 242
		cel 1
		priority 15
		signal 16
	)
)

(instance frame4 of PicView
	(properties
		x 20
		y 156
		view 242
		cel 2
		priority 15
		signal 16
	)
)

(instance frame5 of PicView
	(properties
		x 81
		y 189
		view 242
		cel 3
		priority 15
		signal 16
	)
)

(instance frame6 of PicView
	(properties
		x 238
		y 189
		view 242
		loop 1
		cel 3
		priority 15
		signal 16
	)
)

(instance frame7 of PicView
	(properties
		x 300
		y 156
		view 242
		loop 1
		cel 2
		priority 15
		signal 16
	)
)

(instance frame8 of PicView
	(properties
		x 301
		y 94
		view 242
		loop 1
		cel 1
		priority 15
		signal 16
	)
)

