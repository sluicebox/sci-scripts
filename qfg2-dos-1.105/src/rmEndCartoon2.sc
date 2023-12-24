;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 821)
(include sci.sh)
(use Main)
(use n001)
(use TopWindow)
(use Full)
(use Interface)
(use LoadMany)
(use Extra)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rmEndCartoon2 0
)

(local
	saveEgoX
	saveEgoY
	egoView
	egoLoop
	egoCel
	[msgStr 500]
)

(procedure (DoTalk speaker parmColor parmBack timeToCue toCue &tmp [tmpStr 500])
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

(procedure (Include maxVal curVal minVal) ; UNUSED
	(return
		(cond
			((<= curVal minVal) minVal)
			((>= curVal maxVal) maxVal)
			(else curVal)
		)
	)
)

(procedure (AddToPicCrowd)
	(gCurRoom picture: 230 style: 16 drawPic: 230)
	(InitAddToPics
		jaafar
		guard2Body
		guard3Body
		crowd
		crowd2
		crowd3
		crowd4
		crowd5
		Zayishah
		saurus
		sultan
		Zayishah
		Rakeesh
	)
	(NormalEgo)
	(gEgo illegalBits: 0 ignoreActors: view: 4 loop: 6 posn: 158 118 init:)
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
	(ShemaShameen init: stopUpd:)
	(Walid init: stopUpd:)
	(Aziza init: stopUpd:)
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

(procedure (ShemaTalk timeToCue toCue)
	(shameenHead stopUpd: hide:)
	(shameenLook show:)
	(shemaLook hide:)
	(shemaHead startUpd: setCycle: Full 2 show:)
	(DoTalk {Shema:} 14 6 timeToCue toCue &rest)
)

(procedure (ShameenTalk timeToCue toCue)
	(shameenHead startUpd: setCycle: Full 2 show:)
	(shameenLook hide:)
	(shemaLook show:)
	(shemaHead stopUpd: hide:)
	(DoTalk {Shameen:} 15 6 timeToCue toCue &rest)
)

(procedure (JaafarTalk timeToCue toCue)
	(Face gEgo jaafar)
	(DoTalk {Ja'afar:} 12 0 timeToCue toCue &rest)
)

(procedure (WarriorTalk timeToCue toCue)
	(walidFace cel: 0 setCycle: Full 2)
	(DoTalk {Warrior:} 0 7 timeToCue toCue &rest)
)

(procedure (AzizaTalk timeToCue toCue)
	(azizaFace setCycle: Full 4)
	(DoTalk {Aziza:} 13 0 timeToCue toCue &rest)
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

(instance rmEndCartoon2 of Rm
	(properties
		picture 2
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 4 236 230 242 233 231 234 232 820)
		(LoadMany rsPIC 230 2)
		(Load rsSOUND 820)
		(Load rsSCRIPT 78)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(super init: &rest)
		(gEgo illegalBits: 0 ignoreActors:)
		(= gSpeed
			(switch gHowFast
				(0 0)
				(1 2)
				(2 6)
				(else 6)
			)
		)
		(self setScript: endCartoon)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(event claimed: 1)
		(if (== (event type:) evKEYBOARD)
			(if (== (event message:) KEY_F9)
				(gGame restart:)
			)
			(if (== (event message:) KEY_F2)
				(soundOnOff)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance endCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMiscSound fade:)
				(gCSound fade:)
				(= cycles 10)
			)
			(1
				(gCSound number: 820 loop: -1 playBed:)
				(HandsOff)
				(AddToPicCrowd)
				(= cycles 1)
			)
			(2
				(SetCursor gTheCursor 0)
				(DoTalk {The Palace of the Sultan} 15 0 5 self 821 0)
			)
			(3
				(= seconds 3)
			)
			(4
				(JaafarTalk
					5
					self
					(Format
						@msgStr
						{%s, thou shalt stand before the Sultan Harun al-Rashid (May He Reign Forever!) to be judged.}
						@gUserName
					)
				)
			)
			(5
				(JaafarTalk 4 self 821 1)
			)
			(6
				(self setScript: shemaShameenSpeak self)
			)
			(7
				(JaafarTalk 4 self 821 2)
			)
			(8
				(if (IsFlag 154) ; fNotKilledEOF
					(self setScript: warriorSpeak self)
				else
					(self cue:)
				)
			)
			(9
				(if (IsFlag 122) ; fGotFruit
					(self setScript: azizaSpeak self)
				else
					(self cue:)
				)
			)
			(10
				(HandsOn)
				(gCurRoom newRoom: 822) ; rmEndCartoon3
				(self dispose:)
			)
		)
	)
)

(instance shemaShameenSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShemaShameen setCycle: End self)
			)
			(1
				(Face gEgo ShemaShameen)
				(DoTalk
					{Shameen and Shema:}
					15
					6
					4
					self
					(Format @msgStr {We shall speak for %s.} @gUserName)
				)
			)
			(2
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion:
						MoveTo
						(- (ShemaShameen x:) 20)
						(- (ShemaShameen y:) 8)
						self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(AddToPicBorder 0)
				(InitAddToPics shameenBody shemaBody egoBodyLeft egoHeadLeft)
				(shameenHead init:)
				(shameenLook init: hide:)
				(shemaHead init: hide:)
				(shemaLook init:)
				(ShameenTalk 10 self 821 3)
			)
			(5
				(ShemaTalk 4 self (Format @msgStr {We met %s.} @gUserName))
			)
			(6
				(ShameenTalk 8 self 821 4)
			)
			(7
				(ShemaTalk 4 self 821 5)
			)
			(8
				(ShameenTalk 10 self 821 6)
			)
			(9
				(ShemaTalk 4 self 821 7)
			)
			(10
				(shemaHead setCel: 0)
				(= seconds 2)
			)
			(11
				(AddToPicCrowd)
				(shameenHead dispose:)
				(shameenLook dispose:)
				(shemaHead dispose:)
				(shemaLook dispose:)
				(= cycles 10)
			)
			(12
				(ShemaShameen setCycle: Beg)
				(= seconds 2)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance warriorSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Walid setCycle: End self)
			)
			(1
				(Face gEgo Walid)
				(DoTalk
					{Warrior:}
					0
					7
					4
					self
					(Format @msgStr {I shall speak for %s.} @gUserName)
				)
			)
			(2
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (+ (Walid x:) 10) (- (Walid y:) 10) self
				)
			)
			(3
				(Face gEgo Walid)
				(= seconds 2)
			)
			(4
				(AddToPicBorder 0)
				(InitAddToPics walidBody walidHead egoBodyLeft egoHeadLeft)
				(walidFace init:)
				(walidArms init: stopUpd:)
				(WarriorTalk 8 self 821 8)
			)
			(5
				(WarriorTalk 8 self 821 9)
			)
			(6
				(WarriorTalk 8 self 821 10)
			)
			(7
				(walidArms setCel: 1)
				(WarriorTalk 6 self 821 11)
			)
			(8
				(walidFace setCycle: 0 setCel: 0)
				(= seconds 2)
			)
			(9
				(AddToPicCrowd)
				(walidFace dispose:)
				(walidArms dispose:)
				(= cycles 2)
			)
			(10
				(Walid setCycle: Beg)
				(= seconds 4)
			)
			(11
				(Face gEgo jaafar)
				(JaafarTalk 4 self 821 12)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance azizaSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Aziza setCycle: End self)
			)
			(1
				(DoTalk
					{Aziza:}
					13
					0
					4
					self
					(Format @msgStr {I shall speak for %s.} @gUserName)
				)
			)
			(2
				(Face gEgo Aziza)
				(= seconds 2)
			)
			(3
				(gEgo
					setMotion: MoveTo (+ (Aziza x:) 10) (- (Aziza y:) 11) self
				)
			)
			(4
				(Face gEgo Aziza)
				(= seconds 2)
			)
			(5
				(AddToPicBorder 0)
				(InitAddToPics azizaBody egoBodyLeft egoHeadLeft)
				(azizaFace init:)
				(azizaArm init: stopUpd:)
				(AzizaTalk 6 self 821 13)
			)
			(6
				(AzizaTalk 8 self 821 14)
			)
			(7
				(AzizaTalk 12 self 821 15)
			)
			(8
				(if (< gBeastCare 3)
					(self changeState: 11)
				else
					(AzizaTalk 6 self 821 16)
				)
			)
			(9
				(AzizaTalk
					8
					self
					(Format
						@msgStr
						{Though it was wicked and most foul, %s turned aside its wickedness and restored its humanity.}
						@gUserName
					)
				)
			)
			(10
				(AzizaTalk 6 self 821 17)
			)
			(11
				(AzizaTalk 6 self 821 18)
				(azizaArm cycleSpeed: 2 setCycle: End self)
			)
			(12 0)
			(13
				(azizaFace setCycle: 0 setCel: 0)
				(azizaEyes init:)
				(azizaArm setCycle: Beg self)
			)
			(14
				(= seconds 2)
			)
			(15
				(AddToPicCrowd)
				(azizaFace dispose:)
				(azizaEyes dispose:)
				(azizaArm dispose:)
				(= cycles 2)
			)
			(16
				(Aziza setCycle: Beg)
				(= seconds 4)
			)
			(17
				(JaafarTalk 4 self 821 19)
			)
			(18
				(self dispose:)
			)
		)
	)
)

(instance jaafar of PicView
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
		cycleSpeed 2
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
		cycleSpeed 2
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

(instance saurus of PicView
	(properties
		x 101
		y 128
		view 820
		loop 4
	)
)

(instance ShemaShameen of Prop
	(properties
		x 206
		y 150
		view 820
		loop 1
		cycleSpeed 2
	)
)

(instance Zayishah of PicView
	(properties
		x 266
		y 129
		view 820
		loop 2
	)
)

(instance Walid of Prop
	(properties
		x 160
		y 167
		view 820
		cycleSpeed 2
	)
)

(instance Aziza of Prop
	(properties
		x 114
		y 165
		view 820
		loop 3
		cycleSpeed 2
	)
)

(instance Rakeesh of PicView
	(properties
		x 170
		y 93
		view 820
		loop 8
	)
)

(instance sultan of PicView
	(properties
		x 241
		y 100
		view 820
		loop 13
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

(instance egoBodyRight of PicView ; UNUSED
	(properties
		x 105
		y 156
		view 233
		loop 5
	)
)

(instance egoHeadRight of PicView ; UNUSED
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

(instance shemaHead of Prop
	(properties
		x 129
		y 126
		view 234
		loop 1
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance shameenHead of Prop
	(properties
		x 80
		y 127
		view 234
		loop 2
		priority 12
		signal 16
		cycleSpeed 1
	)
)

(instance shemaLook of View
	(properties
		x 129
		y 126
		view 234
		loop 3
		priority 12
		signal 16
	)
)

(instance shameenLook of View
	(properties
		x 80
		y 127
		view 234
		loop 4
		priority 12
		signal 16
	)
)

(instance shameenBody of PicView
	(properties
		x 82
		y 156
		view 234
		signal 16384
	)
)

(instance shemaBody of PicView
	(properties
		x 131
		y 156
		view 234
		cel 1
		priority 9
		signal 16
	)
)

(instance walidBody of PicView
	(properties
		x 106
		y 156
		view 232
		signal 16384
	)
)

(instance walidArms of Prop
	(properties
		x 109
		y 150
		view 232
		loop 1
		priority 12
		signal 16400
		cycleSpeed 20
	)
)

(instance walidHead of PicView
	(properties
		x 96
		y 102
		view 232
		loop 2
		priority 12
		signal 16400
	)
)

(instance walidFace of Prop
	(properties
		x 99
		y 102
		view 232
		loop 3
		priority 13
		signal 16400
		cycleSpeed 1
	)
)

(instance azizaBody of PicView
	(properties
		x 101
		y 157
		view 236
		loop 1
	)
)

(instance azizaFace of Prop
	(properties
		x 118
		y 101
		view 236
		loop 3
		priority 13
		signal 16400
		cycleSpeed 2
	)
)

(instance azizaArm of Prop
	(properties
		x 136
		y 108
		view 236
		signal 16384
	)
)

(instance azizaEyes of View
	(properties
		x 110
		y 84
		view 236
		loop 2
		priority 13
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

