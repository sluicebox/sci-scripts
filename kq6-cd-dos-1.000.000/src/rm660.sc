;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use rgDead)
(use KQ6Room)
(use n913)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm660 0
)

(local
	local0
	[local1 19] = [18 73 2 69 50 0 135 46 1 223 48 1 291 48 1 277 83 3 0]
	[local20 16] = [26 159 5 69 82 6 136 63 7 224 67 7 291 64 8 0]
	[local36 13] = [69 46 0 135 43 1 222 45 2 291 46 3 0]
)

(instance rm660 of KQ6Room
	(properties
		noun 4
		picture 660
		south 650
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -10 319 -10 319 174 241 159 236 146 187 147 107 151 81 159 102 167 116 173 108 179 75 189
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			posn: 160 180
			setPri: 12
			setScale: Scaler 100 64 189 74
			actions: egoActions
			init:
		)
		(riverStyx init:)
		(boat addToPic:)
		(charon
			posn: (- (boat x:) 79) (+ (boat y:) 36)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(spiritFeat init:)
		(proc70_1 torch @local1)
		(proc70_1 shimmer @local20)
		(proc70_1 glow @local36)
		(gCast eachElementDo: #checkDetail)
		(gGame handsOn:)
	)
)

(instance fx of Sound
	(properties)
)

(instance splashSound of Sound
	(properties
		number 923
	)
)

(instance swimScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 99 182 self)
			)
			(1
				(gGlobalSound number: 653 loop: 1 play:)
				(gEgo
					normal: 0
					view: 665
					setLoop: 0
					cel: 0
					posn: 89 187
					setCycle: CT 6 1 self
				)
			)
			(2
				(splashSound play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo dispose:)
				(= cycles 2)
			)
			(4
				(gMessager say: 3 3 0 1 self) ; "Alexander slips off the banks and plunges into the River Styx."
			)
			(5
				(gMessager say: 3 3 0 2 self) ; "As the black water comes into contact with his skin, Alexander feels himself going numb...from the legs up! He sinks like a stone!"
			)
			(6
				(EgoDead 31) ; "Hey, hey, what a fix! Bathin' in the River Styx!"
			)
		)
	)
)

(instance missedCharonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 6 0 9 1 self) ; "Uh, oh! Charon appears to be readying the boat to leave."
			)
			(2
				(gGlobalSound number: 601 loop: 1 play:)
				(if
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(charon x:)
							(charon y:)
						)
						40
					)
					(gEgo setMotion: PolyPath 114 160 self)
				else
					(= cycles 1)
				)
			)
			(3
				(gMessager say: 6 0 9 2 self) ; "Wait! I must get across the river."
			)
			(4
				(charon view: 667 setLoop: 0 setCycle: End self)
				(gGlobalSound2 number: 662 loop: 1 play:)
			)
			(5
				(charon setLoop: 1 setCycle: Fwd)
				(gEgo
					normal: 0
					view: 749
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setLoop: 5 cel: 0 setCycle: End)
				(charon setLoop: 0)
				(charon cel: (charon lastCel:) setCycle: Beg self)
			)
			(7
				(gMessager say: 6 0 9 3 self) ; "Apparently, Charon doesn't intend to let travelers without fare loiter on the shores of his river."
			)
			(8
				(EgoDead 39) ; "Hey! That's not fare!"
			)
		)
	)
)

(instance buyTransportScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 106 147 self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 2 7 0 1 self) ; "Will these coins do as fare for passage?"
			)
			(3
				(gGame givePoints: 3)
				(gEgo
					normal: 0
					put: 7 -1 ; deadMansCoin
					view: 661
					setLoop: 0
					cel: 0
					posn: 110 150
					setCycle: End self
				)
				(charon setCycle: End)
			)
			(4
				(fx number: 661 loop: 1 play:)
				(gEgo
					reset: 7
					setPri: 12
					posn: (- (gEgo x:) 2) (- (gEgo y:) 1)
				)
				(charon setCycle: Beg self)
			)
			(5
				(= seconds 1)
			)
			(6
				(gMessager say: 2 7 0 2 self) ; "Charon accepts the fare and waves Alexander onto the boat."
			)
			(7
				(= seconds 1)
			)
			(8
				(gEgo setMotion: MoveTo 124 144 self)
			)
			(9
				(gEgo
					normal: 0
					view: 661
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(10
				(= ticks 15)
			)
			(11
				(boat dispose:)
				(charon view: 668 setLoop: 0 cel: 0 setCycle: End self)
				(UnLoad 128 663)
			)
			(12
				(gEgo setPri: -1 dispose:)
				(charon dispose:)
				(if global169
					(DrawPic 660 15)
				else
					(gCurRoom drawPic: 660)
				)
				(boat
					signal: 16384
					ignoreActors: 1
					view: 662
					setLoop: 0
					cel: 0
					setScale: Scaler 100 50 137 59
					init:
				)
				(UnLoad 128 668)
				(UnLoad 128 661)
				(= ticks 10)
			)
			(13
				(boat cel: 1)
				(= ticks 10)
			)
			(14
				(boat setLoop: 1 cel: 0)
				(= ticks 10)
			)
			(15
				(boat cel: 1)
				(= ticks 10)
			)
			(16
				(boat view: 6621 setLoop: 0 cel: 0)
				(= ticks 10)
			)
			(17
				(boat
					ignoreActors: 1
					ignoreHorizon: 1
					setPri: 3
					setMotion: MoveTo 345 63 self
				)
			)
			(18
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance getWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 119 184 self)
			)
			(1
				(gEgo
					normal: 0
					view: 666
					setLoop: 0
					cel: 0
					posn: 110 189
					setCycle: CT 3 1 self
				)
			)
			(2
				(fx number: 924 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 3 44 (if (IsFlag 68) 4 else 3) 0 self)
			)
			(5
				(gEgo reset: 1 setPri: 12 posn: 119 184)
				(= cycles 1)
			)
			(6
				(UnLoad 128 666)
				(SetFlag 58)
				(gGame givePoints: 1)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance playFlute of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 85 0) self) ; playTheFlute
			)
			(1
				(gMessager say: 8 31 0 0 self) ; "Alexander decides to play his flute for the ferryman."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance playNightingale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 93 0) self) ; nightScript
			)
			(1
				(gMessager say: 8 37 0 0 self) ; "Alexander decides to try a little of nature's music on the River Styx ferryman."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryToBoardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(charon x:)
							(charon y:)
						)
						20
					)
					(gEgo setMotion: MoveTo 112 149 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo charon self)
			)
			(2
				(charonHead
					posn: (- (charon x:) 5) (- (charon y:) 43)
					init:
					setCycle: Fwd
				)
				(= cycles 15)
			)
			(3
				(charonHead dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkCharonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(charon x:)
							(charon y:)
						)
						20
					)
					(gEgo setMotion: MoveTo 112 149 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo charon self)
			)
			(2
				(gMessager say: 2 register 0 1 self)
			)
			(3
				(if (!= (charon cel:) 3)
					(charon setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(charonHead
					posn: (- (charon x:) 5) (- (charon y:) 43)
					init:
					setCycle: Fwd
				)
				(= cycles 15)
			)
			(5
				(if (OneOf register 48 2 37)
					(gMessager say: 2 register 0 2 self)
				else
					(= cycles 1)
				)
			)
			(6
				(charonHead dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance charonHead of Prop
	(properties
		view 663
		loop 2
		priority 12
		signal 16400
	)
)

(instance torch of Prop
	(properties
		noun 7
		view 660
		loop 8
		priority 5
		signal 16400
		detailLevel 1
	)
)

(instance shimmer of Prop
	(properties
		noun 3
		view 660
		loop 5
		priority 1
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb)
		(riverStyx doVerb: theVerb &rest)
	)
)

(instance glow of Prop
	(properties
		noun 4
		view 664
		signal 16400
		detailLevel 1
	)
)

(instance spiritFeat of Feature
	(properties
		noun 5
	)

	(method (init)
		(= onMeCheck
			(= local0
				((Polygon new:)
					type: PTotalAccess
					init: 132 117 138 121 151 124 169 115 186 122 193 130 185 139 177 141 119 142 119 131 127 119
					yourself:
				)
			)
		)
		(super init: &rest)
	)
)

(instance boat of Actor
	(properties
		x 156
		y 108
		noun 1
		view 663
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(super dispose:)
		(gWalkHandler delete: self)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOVE)
				(super handleEvent: event)
			)
			((spiritFeat onMe: event)
				(spiritFeat handleEvent: event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gGame handsOff:)
				(gCurRoom setScript: tryToBoardScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance charon of Actor
	(properties
		noun 2
		view 663
		loop 1
	)

	(method (init)
		(super init: &rest)
		(cond
			((== ((ScriptID 0 6) client:) (ScriptID 70 0)) 0) ; CharonTimer, rgDead
			((IsFlag 121)
				(gGame handsOff:)
				(gCurRoom setScript: missedCharonScript)
			)
			(else
				((ScriptID 0 6) setReal: (ScriptID 70 0) 0 2 0) ; CharonTimer, rgDead
			)
		)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(super dispose:)
		(gWalkHandler delete: self)
	)

	(method (doit)
		(super doit:)
		(cond
			((gCurRoom script:) 0)
			((IsFlag 121)
				(gGame handsOff:)
				(gCurRoom setScript: missedCharonScript)
			)
			((and (< (self distanceTo: gEgo) 40) (!= cel 3) (not cycler))
				(self setCycle: End)
			)
			((and (> (self distanceTo: gEgo) 40) cel (not cycler))
				(self setCycle: Beg)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; deadMansCoin
				(gGame handsOff:)
				((ScriptID 0 6) dispose:) ; CharonTimer
				(gCurRoom setScript: buyTransportScr)
			)
			(3 ; Walk
				(gGame handsOff:)
				(gCurRoom setScript: tryToBoardScript)
			)
			(31 ; flute
				(gGame handsOff:)
				(gCurRoom setScript: playFlute)
			)
			(37 ; nightingale
				(gGame handsOff:)
				(gCurRoom setScript: playNightingale)
			)
			(else
				(if (OneOf theVerb 2 5 1 13 28 8 30 48 50 16 35) ; Talk, Do, Look, mirror, spellBook, dagger, feather, gauntlet, handkerchief, scythe, skeletonKey
					(gGame handsOff:)
					(gCurRoom setScript: talkCharonScript 0 theVerb)
				else
					(gGame handsOff:)
					(gCurRoom setScript: talkCharonScript 0 0)
				)
			)
		)
	)
)

(instance riverStyx of Feature
	(properties
		noun 3
		onMeCheck 2
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(if (not (IsFlag 58))
					(gGame handsOff:)
					(gCurRoom setScript: getWaterScr)
				else
					(gMessager say: noun theVerb 5) ; "The teacup already contains some water from the River Styx."
				)
			)
			(3 ; Walk
				(gGame handsOff:)
				(gCurRoom setScript: swimScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gWalkHandler delete: self)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; flute
				(gGame handsOff:)
				(gCurRoom setScript: playFlute)
			)
			(37 ; nightingale
				(gGame handsOff:)
				(gCurRoom setScript: playNightingale)
			)
			(else
				(return 0)
			)
		)
	)
)

