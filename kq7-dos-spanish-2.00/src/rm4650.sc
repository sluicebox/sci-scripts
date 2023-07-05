;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4650)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4650 0
)

(local
	[local0 2] = [0 1]
)

(instance rm4650 of KQRoom
	(properties
		picture 4650
		horizon 52
	)

	(method (newRoom)
		(ClearFlag 192)
		(if (dogTimer client:)
			(dogTimer client: 0 delete: dispose:)
		)
		((ScriptID 7001 1) client: 0 hide_mouth: 0) ; maliciaTalker
		(gKqMusic1 fade:)
		(super newRoom: &rest)
	)

	(method (init)
		(super init:)
		(gKqMusic1 number: 4650 loop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 71 43 8 43 38 92 26 125 198 125 198 116 155 116 106 103 76 102 46 81 56 60
					yourself:
				)
		)
		(Load rsMESSAGE 4650)
		(gGame handsOn:)
		(switch gChapter
			(4
				(Load rsVIEW 4651)
				(Load rsVIEW 4652)
				(Load rsVIEW 4653)
				(gEgo setScaler: Scaler 100 67 108 61)
				(cond
					((IsFlag 194)
						(largeHole init:)
						(if (and (IsFlag 161) (!= gPrevRoomNum 4450))
							(largeHole setHotspot: 0)
						)
					)
					((IsFlag 193)
						(smallHole init:)
					)
					(else
						(roots init:)
					)
				)
				(switch gPrevRoomNum
					(4550
						(gGame handsOff:)
						(self setScript: sFromNorth)
					)
					(4600
						(veil init:)
						(if (IsFlag 5)
							(gEgo
								init:
								normalize:
								posn: 132 117
								script: sLeaveHouse
							)
							(sLeaveHouse client: gEgo changeState: 5)
							(gEgo setScaler: Scaler 100 67 108 61)
						else
							(veil init:)
							(Load rsVIEW 992)
							(gEgo init: hide: setScript: sLeaveHouse)
						)
					)
					(4450
						(veil init:)
						(cond
							((gEgo has: 63) ; Sling
								(Load rsVIEW 992)
								(gEgo init: hide: setScript: sLeaveHouse)
								(largeHole setHotspot: 0)
							)
							(
								(and
									(IsFlag 161)
									(or
										(not (gEgo has: 62)) ; Device
										(not (gEgo has: 61)) ; Woolen_Stocking
									)
								)
								(self setScript: sLeaveHouseDeadNoItems)
							)
							((IsFlag 163)
								(self setScript: sLeaveHouseDeadUntidy)
							)
							(else
								(Load rsVIEW 992)
								(gEgo init: hide: setScript: sLeaveHouse)
								(largeHole setHotspot: 0)
							)
						)
					)
					(else
						(gGame handsOff:)
						(SetFlag 151)
						(self setScript: sFromNorth)
					)
				)
			)
			(5
				(SetFlag 192)
				(largeHole init:)
				(if (IsFlag 497)
					(largeHole setHotspot: 0)
				)
				(gEgo init: hide:)
				(gEgo setScaler: Scaler 100 64 115 49)
				(switch gPrevRoomNum
					(4550
						(self setScript: sFromNorth)
					)
					(3150
						(if (IsFlag 5)
							(ClearFlag 5)
							(gEgo init: normalize: posn: 132 117)
							(gEgo setScaler: Scaler 100 64 115 49)
						else
							(self setScript: sRunFromWereWoods)
						)
					)
					(4450
						(if (IsFlag 5)
							(gEgo init: normalize: posn: 132 117)
						else
							(gEgo init: hide: setScript: sLeaveHouse)
							(gEgo setScaler: Scaler 100 64 115 49)
						)
					)
					(4600
						(gEgo setScript: sLeaveHouse)
					)
					(else
						(gGame handsOff:)
						(self setScript: sFromNorth)
					)
				)
			)
		)
		(if (and (not script) (not (gEgo script:)) (not (IsFlag 5)))
			(gEgo init: posn: 40 85 normalize:)
			(if (== gValOrRoz -3) ; Roz
				(gEgo setScaler: Scaler 100 67 108 61)
			else
				(gEgo setScaler: Scaler 100 64 115 49)
			)
		)
		(ClearFlag 5)
		(if (IsFlag 162)
			(dogTimer scratch: (Random 4 10) cue:)
		)
		(nExit init:)
	)

	(method (notify)
		(gEgo put: 54 -1) ; Veil
		((gEgo script:) register: 1 seconds: 0 cycles: 1)
	)

	(method (doit)
		(if
			(and
				(not script)
				(== gChapter 4)
				(not (IsFlag 151))
				(or (< (gEgo x:) 60) (< (gEgo y:) 95))
			)
			(self setScript: boogeyKill)
		)
		(super doit:)
	)
)

(instance veil of Prop
	(properties
		x 131
		y 113
		view 4652
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 setPri: 0) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gChapter 5)
					(return)
				)
				(if (gEgo script:)
					(self setHotspot: 0)
					((gEgo script:) register: 1 cycles: 1)
				)
			)
		)
	)
)

(instance smallHole of Prop
	(properties
		x 149
		y 120
		view 4650
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: (- priority 20) setHotspot: 8 10 75) ; Do, Exit, Shovel
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sUnableToDigHole)
			)
			(75 ; Shovel
				(gCurRoom setScript: sDigHoleShovel)
			)
		)
	)
)

(instance largeHole of Prop
	(properties
		x 149
		y 120
		view 4650
	)

	(method (init)
		(super init: &rest)
		(self cel: 4 setPri: (- priority 20) setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: 0)
				(gCurRoom setScript: sCrawlIntoHouse)
			)
		)
	)
)

(instance roots of Prop
	(properties
		x 149
		y 120
		view 4650
	)

	(method (init)
		(super init: &rest)
		(self setPri: (- priority 20) setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 151)
					(SetFlag 193)
					(gCurRoom setScript: sDigHoleHands)
				else
					(gCurRoom setScript: boogeyKill)
				)
			)
		)
	)
)

(instance malKill of Actor
	(properties
		x 108
		y 121
		view 4655
	)
)

(instance boogeyKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(if (gEgo script:)
					((gEgo script:) seconds: 0)
				else
					(= scratch 0)
				)
				(gKqSound1
					number:
						(switch (Random 0 2)
							(0 4353)
							(1 4501)
							(2 4502)
						)
					setLoop: 1
					play: self
				)
			)
			(1
				((= register (Actor new:))
					view: 43510
					x: (gEgo x:)
					y: (- (gEgo y:) 1)
					z: 1
					setPri: (gEgo priority:)
					loop: 3
					cel: 0
					scaleSignal: 1
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					init:
					setCycle: End self
				)
			)
			(2
				(gKqSound1 number: 4402 setLoop: 1 play:)
				(gEgo hide:)
				(register view: 43512 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(EgoDead 19 self)
			)
			(4
				(if (or (< (gEgo x:) 60) (< (gEgo y:) 95))
					(gEgo x: 92 y: 113)
				)
				(ClearFlag 5)
				(register dispose:)
				(if (gEgo script:)
					((gEgo script:) seconds: 10)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDigHoleHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 182 111 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gKqSound1 number: 3304 setLoop: 1 play: 64 0)
				(roots cel: (+ (roots cel:) 1))
				(gEgo
					view: 4651
					cel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gEgo view: 4651 setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(smallHole init:)
				(= cycles 10)
			)
			(6
				(gEgo heading: 315 normalize:)
				(= cycles 10)
			)
			(7
				(gMessager say: 1 8 0 0 self) ; "(WHISPERING)Will you look at that! I think we've found our way in!"
			)
			(8
				(gGame handsOn:)
				(roots dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDigHoleShovel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 182 111 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gKqSound1 number: 4081 loop: 1 play:)
				(gEgo
					view: 4651
					cycleSpeed: 10
					setLoop: 2
					cel: 0
					setCycle: End self
				)
				(smallHole cel: (+ (smallHole cel:) 1))
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gKqSound1 number: 40810 loop: 1 play:)
				(gEgo setCycle: End self)
				(smallHole cel: (+ (smallHole cel:) 1))
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gKqSound1 number: 40810 loop: 1 play:)
				(gEgo setCycle: End self)
				(SetFlag 194)
				(largeHole init:)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gKqSound1 stop:)
				(gEgo normalize:)
				(smallHole dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUnableToDigHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 182 111 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 4651 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo heading: 315 normalize:)
				(= cycles 2)
			)
			(6
				(gMessager say: 2 8 1 0 self) ; "(THINKS TO HERSELF)It's too small. I'll need something to enlarge it."
			)
			(7
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sCrawlIntoHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 192)
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo cycleSpeed: 12)
				(if (== gChapter 4)
					(= register (IsFlag 151))
					(if register
						(gEgo setMotion: PolyPath 112 108 self)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (== gChapter 4)
					(if register
						(gKqSound1 number: 4659 play:)
						(gEgo view: 4652 setLoop: 1)
						(gEgo
							cel: 0
							setCycle: CT (- (gEgo lastCel:) 1) 1 self
						)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== gChapter 4)
					(if register
						(ClearFlag 151)
						(veil view: 4652 setLoop: 3 setPri: 0 cel: 0 init:)
						(gEgo setCycle: End self)
					else
						(= cycles 1)
					)
				else
					(gEgo setMotion: PolyPath 194 128 self)
				)
			)
			(4
				(if (== gChapter 4)
					(if register
						(gEgo
							normalize:
							setMotion:
								PolyPath
								(gEgo x:)
								(+ (gEgo y:) 30)
								self
						)
					else
						(= cycles 1)
					)
				else
					(gEgo setHeading: 315 self)
				)
			)
			(5
				(if (== gChapter 4)
					(gEgo normalize: setMotion: PolyPath 194 125 self)
				else
					(gEgo view: 4654 setLoop: 0 cel: 0 setCycle: End self)
				)
			)
			(6
				(if (== gChapter 4)
					(gEgo view: 4652 setLoop: 2 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(7
				(gEgo hide:)
				(= cycles 2)
			)
			(8
				(ClearFlag 192)
				(if (IsFlag 162)
					(if (== gChapter 5)
						(gCurRoom newRoom: 4450)
					else
						(gCurRoom newRoom: 4600)
					)
				else
					(gCurRoom newRoom: 4450)
				)
			)
		)
	)
)

(instance sLeaveHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 192)
				(gGame handsOff:)
				(gEgo setPri: 230)
				(if (== gChapter 4)
					(gEgo
						view: 4653
						loop: 4
						cel: 0
						setScale: 0
						illegalBits: 0
						posn: 186 111
						ignoreActors: 1
						show:
					)
				else
					(gEgo view: 4665 posn: 181 115 loop: 0 cel: 0 show:)
				)
				(= seconds 2)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(if (== gChapter 4)
					(= cycles 1)
				else
					(gKqSound1 number: 847 play:)
					(gEgo setLoop: 1 cel: 0 setCycle: End self)
				)
			)
			(3
				(gEgo normalize: 2 setPri: -1)
				(if (== gChapter 4)
					(= cycles 1)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self)
			)
			(5
				(gGame handsOn:)
				(= seconds 15)
			)
			(6
				(if register
					(gGame handsOff:)
					(= register 0)
					(= cycles 1)
				else
					(-- state)
					(if scratch
						(= scratch 0)
						(= seconds 15)
					else
						(= scratch 1)
						(gCurRoom setScript: boogeyKill self)
					)
				)
			)
			(7
				(gEgo setMotion: PolyPath 118 110 self)
			)
			(8
				(= cycles 2)
			)
			(9
				(gEgo setHeading: 90 self)
			)
			(10
				(gEgo view: 4652 loop: 1)
				(gEgo cel: (- (gEgo lastCel:) 1) setCycle: Beg self)
				(veil dispose:)
			)
			(11
				(SetFlag 151)
				(ClearFlag 192)
				(gEgo normalize:)
				(gEgo setScaler: Scaler 100 67 108 61)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveHouseDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsPIC 999)
				(Load rsVIEW 4566)
				(Load rsVIEW 4565)
				(Load rsVIEW 4655)
				(SetFlag 192)
				(gGame handsOff:)
				(gEgo setPri: 230)
				(if (== gChapter 4)
					(gEgo view: 4653 loop: 4 cel: 0 posn: 186 111 init:)
				else
					(gEgo view: 4665 loop: 0 cel: 0 posn: 181 115 init:)
				)
				(= seconds 2)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(if (== gChapter 4)
					(= cycles 1)
				else
					(gKqSound1 number: 847 play:)
					(gEgo setLoop: 1 cel: 0 setCycle: End self)
				)
			)
			(3
				(gEgo
					normalize: 2
					setPri: -1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(4
				(gKqMusic1 stop:)
				(malTheme number: 941 loop: -1 play:)
				(= seconds 2)
			)
			(5
				(malKill init: setCycle: End self)
				(gEgo setHeading: 270)
				(malSound number: 816 loop: 1 play:)
				(valSound number: 4660 loop: 1 play:)
			)
			(6
				((ScriptID 7001 1) ; maliciaTalker
					client: malKill
					view: -1
					loop: -1
					mouth_x: -999
					mouth_y: -999
					hide_mouth: 0
				)
				(gMessager say: 0 0 2 0 self) ; "(ANGRY BUT TRIUMPHANT)There you are, you wretched little vandal!"
			)
			(7
				(malSound number: 4552 loop: 1 play: self)
			)
			(8
				(malKill view: 4655 setLoop: 1 cel: 0 setCycle: End self)
			)
			(9
				(malSound number: 845 loop: 1 play:)
				(gEgo view: 4655 loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(gCast eachElementDo: #dispose)
				(malTheme stop:)
				(malSound stop:)
				(valSound stop:)
				(gCurRoom drawPic: 999 0 1)
				(= cycles 10)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance sLeaveHouseDeadUntidy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: sLeaveHouseDead self)
			)
			(1
				(EgoDead 56 self)
			)
			(2
				(gCurRoom newRoom: 4450)
			)
		)
	)
)

(instance sLeaveHouseDeadNoItems of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: sLeaveHouseDead self)
			)
			(1
				(EgoDead 56 self)
			)
			(2
				(gCurRoom newRoom: 4450)
			)
		)
	)
)

(instance sRunFromWereWoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo init: posn: 40 85 normalize:)
				(if (IsFlag 151)
					(gEgo setScaler: Scaler 100 67 108 61)
				else
					(gEgo setScaler: Scaler 100 64 115 49)
				)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: posn: 39 75 normalize: 2)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sToNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(1
				(self dispose:)
				(gCurRoom newRoom: 4550)
			)
		)
	)
)

(instance dogTimer of Timer
	(properties)

	(method (cue)
		(if (or (== gChapter 4) (and (== gChapter 5) (IsFlag 544)))
			(if (and (>= (-- scratch) 0) (IsFlag 162))
				(dogSound number: 917 loop: 1 play:)
				(self setReal: self (Random 10 18))
			else
				(ClearFlag 162)
				(self delete: dispose:)
			)
		else
			(dogSound number: 917 loop: 1 play:)
			(self setReal: self (Random 10 18))
		)
	)
)

(instance dogSound of Sound
	(properties)
)

(instance wExit of ExitFeature ; UNUSED
	(properties
		nsTop 60
		nsRight 50
		nsBottom 118
		approachX 5
		approachY 80
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gCurRoom newRoom: 3150)
			)
		)
	)
)

(instance nExit of ExitFeature
	(properties
		nsTop 12
		nsRight 92
		nsBottom 60
		approachX 39
		approachY 86
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gGame handsOff:)
				(gCurRoom setScript: sToNorth)
			)
		)
	)
)

(instance malTheme of Sound
	(properties)
)

(instance malSound of Sound
	(properties)
)

(instance valSound of Sound
	(properties)
)

