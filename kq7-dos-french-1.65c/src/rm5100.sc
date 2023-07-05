;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5100)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use scaryInvInit)
(use eastFeat)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm5100 0
	genTalker 28
	archTalker 29
	chickenTalker 30
	guardTalker 31
	foremanTalker 32
	juryTalker 54
)

(local
	local0 = 3
	local1 = 5101
	local2
	[local3 3] = [1 2 3]
	[local6 3] = [118 175 191]
	[local9 3] = [91 91 114]
	[local12 3] = [-1 102 -1]
	local15
	local16
	local17
)

(procedure (localproc_0)
	(switch gChapter
		(4
			(gEgo setScaler: Scaler 100 48 128 88)
		)
		(else
			(gEgo setScaler: Scaler 100 45 135 88)
		)
	)
)

(instance rm5100 of KQRoom
	(properties
		picture 5100
	)

	(method (init &tmp temp0)
		(super init:)
		(SetFlag 21)
		(SetFlag 55)
		(Load rsMESSAGE 5100)
		(= local17 gFtrInitializer)
		(= gFtrInitializer roomFeatureInitCode)
		(bannerFlags init:)
		(entranceDoor init:)
		(if (== gChapter 3)
			(SetFlag 137)
			(gEgo init: put: 43 normalize: (gEgo loop:) 9050) ; Mask
		else
			(gEgo init: normalize:)
		)
		(localproc_0)
		(if (== gChapter 3)
			(gEgo disableHotspot:)
		)
		(switch gPrevRoomNum
			(5150
				(gEgo posn: 89 90 setHeading: 180)
			)
			(else
				(gEgo posn: 229 112 setHeading: 225)
			)
		)
		(switch gChapter
			(3
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 253 118 238 113 238 103 226 107 235 118 120 118 85 100 98 87 83 87 57 96 96 118 84 131 41 131 41 137 242 137
							yourself:
						)
				)
				(duke init:)
				(Load rsVIEW 9050)
				(SetFlag 137)
				(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
					((View new:)
						view: local1
						loop: local2
						cel: [local3 temp0]
						x: [local6 temp0]
						y: [local9 temp0]
						setPri: [local12 temp0]
						init:
					)
				)
				(band init:)
				(goose init:)
				(hippo init:)
				(cake init:)
				(gKqMusic1 number: 5100 loop: -1 play:)
				(partyChatter play:)
				(duke setScript: dukeDance)
			)
			(4
				(gKqMusic1 number: 5100 loop: -1 play: 40 0)
				(cake init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 49 95 0 111 0 139 249 139 249 120 240 114 240 105 126 121 91 103 97 88 85 88
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 89 112 95 125 25 125 27 112
							yourself:
						)
				)
			)
			(5
				(if (not (SetFlag 200))
					(Load rsVIEW 5106)
					(Load rsVIEW 5107)
					(Load rsVIEW 5108)
					(Load rsVIEW 8315)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 253 118 238 113 238 103 216 108 229 123 131 123 85 100 101 84 84 84 57 96 96 118 68 131 41 131 41 137 242 137
								yourself:
							)
					)
					(cake init: setPri: 106)
					(duke init: ignoreActors:)
					(chicken init: ignoreActors:)
					(badgerJury init: ignoreActors:)
					(jury init: ignoreActors:)
					(foreman init: ignoreActors:)
					(badgerGuard init: ignoreActors:)
					(gEgo normalize: 6 posn: 124 132)
					(gKqMusic1 number: 5105 loop: -1 play:)
					(localproc_0)
					(gCurRoom setScript: chap5Open)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 49 95 0 111 0 139 249 139 249 120 240 114 240 105 126 121 91 103 97 88 85 88
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 89 112 95 125 25 125 27 112
								yourself:
							)
					)
					(cake init: cel: 5 setPri: 106)
					(gKqMusic1 number: 5100 loop: -1 play: setVol: 85)
				)
				(SetFlag 140)
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (newRoom)
		(= gFtrInitializer local17)
		(if (== gChapter 3)
			(gEgo enableHotspot:)
		)
		(gKqMusic1 fade:)
		(super newRoom: &rest)
	)
)

(instance chap5Open of Script
	(properties)

	(method (dispose)
		(gKqMusic1 fade:)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(juryTalker client: badgerJury)
					(= cycles 4)
				)
				(1
					(duke view: 5107 loop: 1 cel: 0 x: 134 y: 91)
					(archTalker clientCel: -2 hide_mouth: 0 loop: 21)
					(gMessager say: 0 0 2 1 self) ; "(GRANDIOSE)Badgerth of the jury! (snort) What ith your verdict?"
				)
				(2
					(foreman setCycle: End self)
				)
				(3
					(gMessager sayRange: 0 0 2 2 3 self) ; "On the charge of moon theft, we find her..."
				)
				(4
					(gKqMusic1 number: 5106 loop: 1 play: self)
				)
				(5
					(gMessager sayRange: 0 0 2 4 5 self) ; "On the charge of impersonating a Falderalian, we find her..."
				)
				(6
					(gKqMusic1 number: 5107 loop: 1 play: self)
				)
				(7
					(gMessager sayRange: 0 0 2 6 7 self) ; "On the charges of party-crashing, sneaking, spying, and appearing in public without fur, feather or scales, we find her..."
				)
				(8
					(gKqMusic1 number: 5108 loop: 1 play: self)
				)
				(9
					(gKqMusic1 number: 5105 loop: -1 play:)
					(duke cel: (duke lastCel:) setCycle: CT 8 -1 self)
				)
				(10
					(archTalker clientCel: -2 loop: 23)
					(gMessager say: 0 0 2 8 self) ; "(VERY DRAMATIC)Valanithe of Daventry, thith ith your thententh! You mutht thpend the retht of your life in the jelly bean mineth of the faraway kingdom of Wugga Wugga Boing Boing."
				)
				(11
					(duke setCycle: Beg)
					(gEgo view: 8315 setLoop: 0 cel: 0 setCycle: End self)
				)
				(12
					(gMessager say: 0 0 2 9 self) ; "(IRRITATED)What? I never heard of such a place. You just made that up, didn't you."
				)
				(13
					(archTalker clientCel: -2 loop: 21)
					(gMessager say: 0 0 2 10 self) ; "(COYLY)Tho I did, tho I did! Doeth anyone have an idea for her thententh?"
				)
				(14
					(juryTalker client: jury loop: 27 clientCel: -2)
					(gMessager sayRange: 0 0 2 11 15 self) ; "Banish her to the Plains of Petulant Possums!"
				)
				(15
					(duke cel: 0 setCycle: CT 8 1 self)
				)
				(16
					(archTalker clientCel: -2 loop: 23)
					(gMessager say: 0 0 2 16 self) ; "The people have thpoken! You have until thunthet to put the moon back in it'th rightful plathe in the thky, Valanithe. If you do not, you will be fed to a three hundred pound hamthter in the morning."
				)
				(17
					(gMessager say: 0 0 2 17 self) ; "Oooooo!"
				)
				(18
					(gEgo setCycle: Beg self)
					(archTalker modeless: 2 hide_mouth: 0 loop: -1)
					(duke
						view: 5108
						loop: 0
						cel: 0
						x: 133
						y: 91
						setCycle: End self
					)
				)
				(19 0)
				(20
					(gEgo normalize: 6)
					(gMessager say: 0 0 2 18 self) ; "Court adjourned!"
				)
				(21
					(gKqMusic1 pause: 1)
					(gKqSound1 number: 5310 loop: -1 play:)
					(chickenTalker modeless: 2 hide_mouth: 1)
					(chicken setCycle: End chicken)
					(gMessager sayRange: 0 0 2 19 20 self) ; "The sky is falling! BAGAWK! The sky is falling!"
				)
				(22
					(badgerGuard setCycle: CT 6 1 self)
				)
				(23
					(gKqSound1 number: 5109 loop: 1 play:)
					(gKqMusic1 number: 5110 loop: -1 play:)
					(badgerGuard setCycle: End)
					(gEgo
						moveSpeed: 4
						setMotion:
							PolyPath
							(entranceDoor approachX:)
							(entranceDoor approachY:)
							self
					)
				)
				(24
					(gEgo setMotion: MoveTo 253 106 self)
				)
				(25
					(gKqMusic1 fade:)
					(gCurRoom newRoom: 5300)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gGame handsOn:)
					(gGame handsOff:)
					(gCurRoom newRoom: 5300)
				)
			)
		)
	)
)

(instance dukeDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(duke
					view: 5101
					loop: 2
					cel: 0
					x: 144
					y: 92
					setCycle: ForwardCounter 2 self
				)
			)
			(1
				(duke view: 5101 loop: 3 cel: 0 x: 147 y: 91 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance waveAtDuke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 5109
					loop: 1
					cel: 2
					x: 85
					y: 105
					setCycle: CT 15 1 self
				)
				((ScriptID 13 0) hide_mouth: 1 clientCel: -2) ; aEgoTalker
				(gMessager say: 1 8 1 1 self) ; "(CALLS OUT HEARTILY)Happy birthday, Arch-Duke Yipyap!"
			)
			(1 0)
			(2
				(duke view: 5109 loop: 2 cel: 0 x: 142 y: 91 setCycle: End self)
			)
			(3
				(archTalker hide_mouth: 1)
				(gMessager say: 1 8 1 2 self) ; "(FULL OF HIMSELF)Thank you, my loyal thubject! YipYipYip!"
			)
			(4
				(duke setCycle: Beg self)
			)
			(5
				(gMessager say: 1 8 1 3 self) ; "Hee hee!"
			)
			(6
				(gEgo setCycle: CT 17 1 self)
			)
			(7
				((ScriptID 13 0) hide_mouth: 0 clientCel: -1) ; aEgoTalker
				(gEgo normalize: 0 9050 posn: 90 106)
				(SetFlag 348)
				(duke setHotspot: 0 setScript: dukeDance)
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveFlags of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 140)
				(if (!= gChapter 3)
					(++ state)
				)
				(gEgo hide:)
				(bannerFlags cel: 1 setPri: 88 setCycle: End self)
			)
			(1
				(bannerFlags
					view: 5103
					loop: 4
					cel: 4
					posn: 94 86
					setCycle: Beg self
				)
			)
			(2
				(bannerFlags setCycle: End self)
			)
			(3
				(ClearFlag 137)
				(if (== gChapter 3)
					(gEgo get: 43) ; Mask
				)
				(bannerFlags setLoop: 0 cel: 0 x: 85 y: 88)
				(UpdateScreenItem bannerFlags)
				(FrameOut)
				(= cycles 1)
			)
			(4
				(gKqMusic1 fade:)
				(partyChatter fade:)
				(gCurRoom newRoom: 5150)
			)
		)
	)
)

(instance rosMoveFlags of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo hide:)
				(bannerFlags cel: 1 setCycle: End self)
				(UpdateScreenItem bannerFlags)
				(FrameOut)
			)
			(2
				(gKqMusic1 fade:)
				(partyChatter fade:)
				(gCurRoom newRoom: 5150)
			)
		)
	)
)

(instance exitToPlaza of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 253 106 self)
			)
			(1
				(partyChatter fade:)
				(gKqMusic1 fade:)
				(gCurRoom newRoom: 5300)
			)
		)
	)
)

(instance bannerFlags of Prop
	(properties
		approachX 79
		approachY 88
		x 85
		y 88
		view 5103
	)

	(method (init)
		(super init:)
		(self setPri: 10 setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		(if (== gChapter 4)
			(self
				view: 5105
				loop: 0
				cel: 10
				x: 96
				y: 89 approachX 85
				approachY: 89
			)
		)
	)

	(method (doVerb)
		(if (== gValOrRoz -3) ; Roz
			(gCurRoom setScript: rosMoveFlags)
		else
			(gCurRoom setScript: moveFlags)
		)
	)
)

(instance entranceDoor of ExitFeature
	(properties
		approachX 230
		approachY 108
	)

	(method (init)
		(super init:)
		(self
			exitDir: 2
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 102 220 80 217 50 269 50 254 112
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: exitToPlaza)
	)
)

(instance band of Prop
	(properties
		y 153
		view 5101
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 150 cycleSpeed: 8 setCycle: Fwd)
	)
)

(instance partyChatter of Sound
	(properties
		flags 5
		number 5102
		loop -1
	)
)

(instance duke of Prop
	(properties
		x 144
		y 92
		priority 105
		fixPriority 1
		view 5101
		loop 2
		cel 73
	)

	(method (init)
		(if (== gChapter 5)
			(self view: 5106 loop: 1 cel: 0 x: 133 y: 91)
		)
		(super init: &rest)
		(if (not (IsFlag 348))
			(self
				setHotspot: 8 10 ; Do, Exit
				approachVerbs: 8 ; Do
				approachX: 90
				approachY: 106
			)
		)
	)

	(method (cue)
		(if (< cel (/ (self lastCel:) 2))
			(duke setCycle: Beg)
		else
			(duke setCycle: End)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: waveAtDuke)
	)
)

(instance cake of View
	(properties
		approachX 150
		approachY 118
		x 172
		y 91
		priority 105
		fixPriority 1
		view 5101
		cel 4
	)

	(method (init)
		(if (== gChapter 5)
			(self view: 5106 loop: 4 cel: 0)
		)
		(super init: &rest)
		(if (== gChapter 3)
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		)
	)

	(method (doVerb)
		(gCurRoom setScript: takeIcing)
		(self setHotspot: 0)
	)
)

(instance takeIcing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 5103) ; WAVE
				(= local15 (gEgo x:))
				(= local16 (gEgo y:))
				(gEgo
					setMotion: MoveTo (cake approachX:) (cake approachY:) self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 5110
					setLoop: 3 1
					cel: 0
					posn: 150 118
					setScale: 0
					setCycle: CT 20 1 self
				)
			)
			(3
				(gKqSound1 number: 5103 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					normalize: 4 9050
					setScaler: Scaler 100 45 135 88
					setMotion: MoveTo local15 local16 self
				)
			)
			(5
				(Load rsVIEW 5110 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goose of View
	(properties
		x 101
		y 132
		priority 115
		fixPriority 1
		view 5111
	)
)

(instance hippo of Prop
	(properties
		x 37
		y 108
		view 5111
		loop 1
	)

	(method (init)
		(super init:)
		(self setScaler: Scaler 81 81 114 113)
	)
)

(instance chicken of Prop
	(properties
		x 93
		y 104
		priority 106
		fixPriority 1
		view 5108
		loop 1
	)

	(method (cue)
		(gKqSound1 loop: 0 stop:)
		(gKqMusic1 pause: 0)
		(self dispose:)
	)
)

(instance badgerJury of Prop
	(properties
		x 119
		y 93
		view 5106
	)
)

(instance jury of Actor
	(properties
		x 191
		y 108
		priority 105
		fixPriority 1
		view 5106
		loop 2
	)
)

(instance badgerGuard of Prop
	(properties
		x 113
		y 127
		view 5108
		loop 2
	)
)

(instance foreman of Prop
	(properties
		x 75
		y 93
		view 5107
		loop 2
	)
)

(instance archTalker of KQTalker
	(properties)

	(method (init)
		(= client duke)
		(super init: &rest)
	)
)

(instance guardTalker of KQTalker
	(properties)

	(method (init)
		(= client jury)
		(= loop 26)
		(super init: &rest)
	)
)

(instance chickenTalker of KQTalker
	(properties)

	(method (init)
		(= client chicken)
		(super init: &rest)
	)
)

(instance juryTalker of KQTalker
	(properties)

	(method (init)
		(super init: &rest)
	)
)

(instance foremanTalker of KQTalker
	(properties)

	(method (init)
		(= client foreman)
		(super init: &rest)
	)
)

(instance genTalker of KQTalker
	(properties)

	(method (init)
		(= client jury)
		(= loop 23)
		(super init: &rest)
	)
)

(instance roomFeatureInitCode of Code
	(properties)

	(method (doit param1)
		(if
			(and
				(not (param1 isKindOf: KQInventory))
				(param1 respondsTo: #signal)
			)
			(param1 sightAngle: 10 signal: (| (param1 signal:) $7001))
		)
	)
)

