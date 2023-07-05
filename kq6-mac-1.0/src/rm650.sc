;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use rgDead)
(use KQ6Room)
(use Inset)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	[local0 16] = [158 52 0 299 58 1 113 82 2 65 87 3 49 87 4 0]
	local16
	local17
	local18
	local19
)

(instance rm650 of KQ6Room
	(properties
		noun 3
		picture 650
		horizon 88
		north 660
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 105 189 105 178 253 178 267 151 267 112 253 109 199 108 123 108 77 112 52 106 52 0 319 0 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 168 0 0 43 0 43 104 57 112 87 115 122 110 210 110 251 113 265 117 265 137 152 168
					yourself:
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(660
				(gEgo posn: 79 113)
				(= local18 1)
			)
			(else
				(gGlobalSound number: 650 loop: -1 play:)
				(gEgo posn: 47 172)
			)
		)
		(proc70_1 flames @local0)
		(glow1 init: setCycle: RandCycle)
		(glow2 init: setCycle: RandCycle)
		(riverStyx init:)
		(fallFeat init:)
		(knight init:)
		(gEgo
			init:
			baseSetter: bSetter
			observeControl: -32768
			setScale: Scaler 100 65 150 100
		)
		(path init:)
		(gGame handsOn:)
		(ghost init: hide: setScript: ghostScript)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((>= (gEgo y:) 186)
				(gGame handsOff:)
				(self setScript: cantLeaveSouth)
			)
			((<= (gEgo x:) 5)
				(gGame handsOff:)
				(self setScript: cantLeaveWest)
			)
			((& temp0 $0800)
				(if
					(and
						(not (gEgo isStopped:))
						(or
							(< ((gEgo mover:) y:) (gEgo y:))
							(OneOf (gEgo loop:) 3 6 7)
						)
					)
					(self setScript: egoNorthOverKnightScr)
				)
			)
			((& temp0 $0002)
				(if
					(and
						local18
						(not (gEgo isStopped:))
						(or
							(> ((gEgo mover:) y:) (gEgo y:))
							(OneOf (gEgo loop:) 2 4 5)
						)
					)
					(self setScript: egoSouthOverKnightScr)
				)
			)
			((& temp0 $1000)
				(self newRoom: north)
			)
			((not (or (& temp0 $4000) (& temp0 $2000) (& temp0 $0002)))
				(gGame handsOff:)
				(self setScript: egoFallScr)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 991)
	)
)

(instance egoNorthOverKnightScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gEgo mover:) ((gEgo mover:) isKindOf: PolyPath))
					(= local16 ((gEgo mover:) finalX:))
					(= local17 ((gEgo mover:) finalY:))
				)
				(gGame handsOff:)
				(gEgo
					normal: 0
					view: 652
					loop: 2
					cel: 3
					posn: (+ (gEgo x:) 1) (+ (gEgo y:) 5)
					setPri: 9
				)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: CT 7 1 self)
			)
			(2
				(gEgo setPri: 8 x: (+ (gEgo x:) 2) setCycle: End self)
			)
			(3
				(gEgo posn: (- (gEgo x:) 2) (- (gEgo y:) 11) reset: 3)
				(= cycles 2)
			)
			(4
				(if
					(and
						local16
						(>
							(GetDistance
								local16
								local17
								(gEgo x:)
								(gEgo y:)
							)
							20
						)
					)
					(gEgo setMotion: PolyPath local16 local17)
					(= local16 0)
				)
				(gGame handsOn:)
				(= local18 1)
				(self dispose:)
			)
		)
	)
)

(instance egoSouthOverKnightScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gEgo mover:) ((gEgo mover:) isKindOf: PolyPath))
					(= local16 ((gEgo mover:) finalX:))
					(= local17 ((gEgo mover:) finalY:))
				)
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: 2
					setCycle: 0
					setPri: 9
					setMotion: JumpTo 261 137 self
				)
			)
			(2
				(gEgo reset:)
				(= local18 0)
				(if
					(and
						local16
						(>
							(GetDistance
								local16
								local17
								(gEgo x:)
								(gEgo y:)
							)
							20
						)
					)
					(gEgo setMotion: PolyPath local16 local17)
					(= local16 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoFallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 124)
					(= register 1)
					(gEgo setMotion: PolyPath 163 108 self)
				else
					(= register 0)
					(gEgo setMotion: PolyPath 119 168 self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 3 3 3 1 self) ; "Alexander slips off the path and plunges into the River Styx."
			)
			(3
				(gGlobalSound stop:)
				(gGlobalSound number: 653 loop: 1 play:)
				(if register
					(gEgo
						normal: 0
						view: 653
						setLoop: 0
						cel: 0
						cycleSpeed: 5
						setCycle: End self
					)
				else
					(gEgo
						normal: 0
						view: 653
						setLoop: 1
						cel: 0
						setPri: 8
						cycleSpeed: 5
						setCycle: End self
					)
				)
			)
			(4
				(gEgo dispose:)
				(splashSound play: self)
			)
			(5
				(gMessager say: 3 3 3 2 self) ; "As soon as the water touches his skin, Alexander's mind and body go numb. He sinks like a lifeless stone."
			)
			(6
				(EgoDead 31) ; "Hey, hey, what a fix! Bathin' in the River Styx!"
			)
		)
	)
)

(instance splashSound of Sound
	(properties
		number 923
	)
)

(instance flames of Prop
	(properties
		noun 12
		view 650
		priority 3
		signal 16400
	)
)

(instance glow1 of Prop
	(properties
		x 299
		y 51
		view 650
		loop 6
		priority 2
		signal 16400
	)
)

(instance glow2 of Prop
	(properties
		x 65
		y 84
		view 650
		loop 7
		priority 2
		signal 16400
	)
)

(instance knightInset of Inset
	(properties
		view 652
		x 228
		y 112
		disposeNotOnMe 1
		noun 8
	)

	(method (handleEvent event)
		(cond
			((ribbonFeat onMe: event)
				(ribbonFeat handleEvent: event)
			)
			((handFeat onMe: event)
				(handFeat handleEvent: event)
			)
			((knightFeat onMe: event)
				(knightFeat handleEvent: event)
			)
			((knightInsetFeat onMe: event)
				(knightInsetFeat handleEvent: event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (init)
		(knightInsetFeat init:)
		(knightFeat init:)
		(ribbonFeat init:)
		(handFeat init:)
		(super init: &rest)
		(if (== ((gInventory at: 15) owner:) gCurRoomNum) ; gauntlet
			(gauntlet init:)
		)
	)

	(method (dispose)
		(ribbonFeat dispose:)
		(knightFeat dispose:)
		(knightInsetFeat dispose:)
		(handFeat dispose:)
		(super dispose:)
	)
)

(instance getGauntletScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(knightInset dispose:)
				(gEgo reset: 0)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: PolyPath 267 130 self)
			)
			(2
				(gEgo
					normal: 0
					view: 652
					loop: 1
					cycleSpeed: 6
					cel: 0
					posn: 277 131
					setCycle: End self
				)
				(scrape play:)
			)
			(3
				(gEgo reset: 0 posn: 267 130 get: 15) ; gauntlet
				(= cycles 2)
			)
			(4
				(gGame givePoints: 1)
				(gMessager say: 6 5 0 0 self) ; "Alexander takes the knight's black gauntlet and examines the writing on it."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scrape of Sound
	(properties
		number 652
	)
)

(instance gauntlet of Prop
	(properties
		x 198
		y 120
		noun 6
		view 652
		cel 1
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getGauntletScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knightGhost of Prop
	(properties
		x 249
		y 145
		view 651
		priority 9
		signal 16
	)
)

(instance ghost of Prop
	(properties
		x 95
		y 112
		noun 10
		view 650
		loop 5
		priority 8
		signal 16
		cycleSpeed 7
	)
)

(instance ghostScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 90 300))
			)
			(1
				(ghost show: setCycle: End self)
			)
			(2
				(ghost hide:)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance ghostTormentScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(gEgo setMotion: 0 setHeading: 45)
				)
				(gGlobalSound number: 651 loop: 1 play:)
				((ScriptID 70 0) setIt: 4) ; rgDead
				(knightGhost init: cycleSpeed: 10 setCycle: End self)
			)
			(1
				(gEgo hide:)
				(knightGhost loop: 1 cel: 0 setPri: -1 setCycle: End self)
			)
			(2
				(gEgo show:)
				(knightGhost
					loop: 2
					cel: 0
					posn: 201 127
					setPri: 4
					setCycle: End self
				)
			)
			(3
				(gGlobalSound stop:)
				(gGlobalSound number: 650 loop: -1 play:)
				(knightGhost dispose:)
				(= seconds 2)
			)
			(4
				(gMessager say: 1 0 4 1 self) ; "Apparently, Alexander's not the only one who's curious about the body on the path!"
			)
			(5
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance knightInsetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(knight approachX:)
						(knight approachY:)
						self
				)
			)
			(1
				(if (not ((ScriptID 70 0) isSet: 4)) ; rgDead
					(self setScript: ghostTormentScr self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5)
				(knightInset init: self gCurRoom)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knight of Feature
	(properties
		x 300
		y 128
		noun 4
		sightAngle 40
		onMeCheck 2
		approachX 251
		approachY 147
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 1) ; Do, Look
			(gGame handsOff:)
			(gCurRoom setScript: knightInsetScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fallFeat of Feature
	(properties
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gGame handsOff:)
			(gCurRoom setScript: egoFallScr)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(super init:)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance riverStyx of Feature
	(properties
		noun 9
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gGame handsOff:)
			(gCurRoom setScript: egoFallScr)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(super init:)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance bSetter of Code
	(properties)

	(method (doit param1)
		(param1 brTop: (param1 y:))
		(param1 brBottom: (param1 y:))
		(param1 brLeft: (param1 x:))
		(param1 brRight: (param1 x:))
	)
)

(instance path of Feature
	(properties
		noun 13
		onMeCheck 16384
	)
)

(instance cantLeaveSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 3 2 0 self) ; "The door to the Underworld refuses to budge. As with all things of this realm, there is no turning back."
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 3)
						(- (gEgo y:) 10)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cantLeaveWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 3 2 0 self) ; "The door to the Underworld refuses to budge. As with all things of this realm, there is no turning back."
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(- (gEgo y:) 3)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knightInsetFeat of Feature
	(properties
		noun 8
		nsTop 62
		nsLeft 154
		nsBottom 155
		nsRight 307
	)
)

(instance ribbonFeat of Feature
	(properties
		noun 7
		nsTop 99
		nsLeft 232
		nsBottom 107
		nsRight 248
	)
)

(instance handFeat of Feature
	(properties
		noun 11
		nsTop 114
		nsLeft 187
		nsBottom 130
		nsRight 212
	)
)

(instance knightFeat of Feature
	(properties
		noun 5
	)

	(method (init)
		(= onMeCheck
			(= local19
				((Polygon new:)
					type: PTotalAccess
					init: 298 68 298 81 290 91 303 103 304 118 282 151 267 153 280 124 265 129 256 152 234 152 237 142 218 133 157 141 156 127 230 110 253 86 269 89 275 68
					yourself:
				)
			)
		)
		(super init: &rest)
	)
)

