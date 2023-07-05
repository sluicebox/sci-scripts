;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use Talker)
(use Language)
(use MoveFwd)
(use ForwardCounter)
(use LoadMany)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm341 0
)

(local
	[local0 14] = [-1 -1 -30 29 15 360 67 -30 108 4096 0 290 210 -32768]
	[local14 16] = [-1 0 -20 300 0 -30 30 360 35 4096 15 -30 168 195 360 -32768]
	[local30 16] = [-1 1 360 170 15 -20 210 360 183 240 167 8192 -1 -30 156 16384]
)

(instance rm341 of EcoRoom
	(properties
		picture 340
		style -32761
		horizon 20
		north 335
		south 200
	)

	(method (init)
		(LoadMany rsVIEW 343 231 802)
		(NormalEgo)
		(gEgo init: ignoreHorizon: hide:)
		(super init:)
		(self setRegions: 51 50) ; bubblesRegion, regionFish
		((ScriptID 50 0) addFish: @local14 @local30 @local0) ; regionFish
		(cond
			((and (IsFlag 40) (not (IsFlag 43)))
				(gCurRoom setScript: swimThru)
			)
			((== ((Inv at: 10) owner:) 335) ; bikeCage
				(= picture 901)
				(gCurRoom setScript: cagePuzzleDone)
			)
			(else
				(gCurRoom setScript: enterScript)
			)
		)
		(gLongSong number: 332 loop: -1 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4) ; "Adam is swimming underwater between Eluria and the fisherman's boat."
			)
			(3 ; Do
				(Narrator init: 5) ; "There's nothing to do with the water except what Adam is already doing - swimming in it."
			)
			(4 ; Inventory
				(Narrator init: 5) ; "There's nothing to do with the water except what Adam is already doing - swimming in it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((OneOf (gEgo edgeHit:) 2 4)
				(gCurRoom setScript: cantGoThatWay)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gPrevRoomNum 335)
					(gEgo setHeading: 180 posn: 160 -20)
				else
					(gEgo setHeading: 0 posn: 160 210)
				)
				(= cycles 2)
			)
			(1
				(gEgo show: setMotion: MoveFwd 45 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance swimThru of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bottle init:)
				(manatee setLoop: 3 init:)
				(pump init:)
				(sandwich init:)
				(= cycles 2)
			)
			(1
				(gEgo
					posn: 175 260
					setHeading: 0
					show:
					cycleSpeed: 12
					yStep: 2
					setCycle: Walk
					setMotion: MoveTo 175 -25
				)
				(manatee setCycle: Walk setMotion: MoveTo 145 107)
				(sandwich setLoop: 2 setCycle: Fwd setMotion: MoveTo 286 210)
				(bottle setLoop: 1 setCycle: Fwd setMotion: MoveTo 225 210)
				(pump
					setLoop: 0
					setCycle: ForwardCounter 6
					setMotion: MoveTo 154 77 self
				)
				(= cycles 20)
			)
			(2
				(Narrator init: 1) ; "A load of garbage appears from somewhere above."
			)
			(3
				(gSoundEffects number: 333 loop: 1 play:)
				(manatee y: (+ (manatee y:) 1))
				(pump
					view: 343
					loop: 3
					cel: 0
					x: 144
					y: 108
					priority: 14
					signal: 16400
				)
				(= cycles 3)
			)
			(4
				(Gregarious init: 1 1 self) ; "Ouch!"
			)
			(5
				(manatee y: (+ (manatee y:) 1))
				(pump
					view: 343
					loop: 0
					cel: 1
					x: 150
					y: 81
					priority: 14
					signal: 16400
				)
				(= cycles 3)
			)
			(6
				(manatee y: (+ (manatee y:) 1))
				(pump
					view: 343
					loop: 0
					cel: 2
					x: 148
					y: 80
					priority: 14
					signal: 16400
				)
				(= cycles 3)
			)
			(7
				(manatee y: (- (manatee y:) 1))
				(pump
					view: 343
					loop: 0
					cel: 3
					x: 146
					y: 81
					priority: 14
					signal: 16400
				)
				(= cycles 3)
			)
			(8
				(manatee y: (- (manatee y:) 1))
				(pump
					view: 343
					loop: 0
					cel: 4
					x: 144
					y: 81
					priority: 14
					signal: 16400
				)
				(= cycles 3)
			)
			(9
				(manatee y: (- (manatee y:) 1))
				(pump
					view: 343
					loop: 0
					cel: 0
					x: 142
					y: 82
					priority: 14
					signal: 16400
				)
				(= cycles 3)
			)
			(10
				(manatee setMotion: MoveTo 145 -50)
				(pump
					setLoop: 0
					yStep: 3
					setCycle: Fwd
					setMotion: MoveTo 142 210 self
				)
			)
			(11
				(SetFlag 65)
				(SetFlag 66)
				(SetFlag 46)
				(pump dispose:)
				(manatee dispose:)
				(HandsOn)
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance cagePuzzleDone of Script
	(properties)

	(method (changeState newState &tmp [temp0 250])
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(proc932_8 99 341 6 @temp0)
				(= register (Display @temp0 dsCOORD 20 85 dsCOLOR global207 dsFONT 300 dsSAVEPIXELS))
				(= seconds 7)
			)
			(2
				(Display {} dsRESTOREPIXELS register)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance cantGoThatWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Narrator init: 3 self) ; "The ocean is a huge place. Adam should stick to the path Gregarious showed him between Eluria and the boat."
			)
			(2
				(if (== (gEgo edgeHit:) 4)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 40) (gEgo y:) self
					)
				else
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 40) (gEgo y:) self
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance manatee of Actor
	(properties
		x 145
		y 220
		yStep 4
		view 231
		signal 24576
		xStep 5
	)
)

(instance pump of Actor
	(properties
		x 154
		y -10
		yStep 3
		view 343
		priority 14
		signal 24592
	)
)

(instance bottle of Actor
	(properties
		x 225
		y 80
		yStep 4
		view 343
		loop 1
		signal 16384
		cycleSpeed 4
	)
)

(instance sandwich of Actor
	(properties
		x 286
		y -50
		view 343
		loop 2
		signal 8192
		cycleSpeed 5
	)
)

(instance Gregarious of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 240
		viewInPrint 1
		charNum 7
		keepWindow 1
	)

	(method (init)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of Prop
	(properties
		view 240
		cel 1
	)
)

(instance gEyes of Prop
	(properties
		nsTop 9
		nsLeft 9
		view 240
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of Prop
	(properties
		nsTop 12
		nsLeft 4
		view 240
		loop 1
		cycleSpeed 10
	)
)

