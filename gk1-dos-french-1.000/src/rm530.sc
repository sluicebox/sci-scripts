;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use n013)
(use Germany)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	local0
)

(instance rm530 of Room
	(properties
		noun 1
		picture 530
		style 14
		exitStyle 13
	)

	(method (init)
		(gGkMusic1
			number: 530
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(gGkSound2 number: 532 setLoop: -1 play:)
		(super init:)
		(self setRegions: 501) ; Germany
		(Load rsMESSAGE 530)
		(Load rsVIEW 901)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 266 145 266 139 304 136 281 131 267 132 222 123 72 120 64 123 164 124 157 136 133 135 33 133 0 140 0 146
					yourself:
				)
		)
		(cond
			((== gPrevRoomNum 500)
				(gCurRoom setScript: wakeUp)
				(Germany windowIsOpen: 0)
			)
			((== gPrevRoomNum 510)
				(gCurRoom setScript: enterFromHall)
			)
			((== gPrevRoomNum 520)
				(gCurRoom setScript: enterFromLibrary)
			)
			(else
				(gEgo
					view: 901
					setCel: 0
					setLoop: 0
					setCycle: StopWalk -1
					signal: (| (gEgo signal:) $1000)
					init:
					state: 2
					ignoreActors: 1
					posn: 195 129
					actions: doTheScissors
					scaleSignal: 4
					setScaler: Scaler 100 55 145 115
				)
			)
		)
		(flame init:)
		(if (Germany windowIsOpen:)
			(theWindow init: setCel: 1)
		else
			(theWindow init: setCel: 0)
		)
		(if
			(and
				(== gDay 7)
				(not (gEgo has: 61)) ; chamPot
				(not (Germany potOnAltar:))
			)
			(theChamberPot init:)
		)
		(if (not (gEgo has: 66)) ; scissors
			(theScissors init:)
		)
		(if (and (== gDay 8) (not (gEgo has: 68))) ; wolfKey
			(theKey init:)
		)
		(firePlace init:)
		(bed init:)
		(bedTable init:)
		(canopy init:)
		(cabinet init:)
		(hallDoor init:)
		(portalWords init:)
		(lionHead init:)
		(mirror init:)
		(keyHole init:)
		(rug init:)
		(leftDoor init:)
		(windowSeat init:)
		(displayCase init:)
		(leftLintel init:)
		(rightLintel init:)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(gGkSound2 stop:)
		(DisposeScript 64935)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5331)
				(gEgo setMotion: PolyPath 237 121 self)
			)
			(1
				(gGkSound1 number: 531 setLoop: 1 play:)
				(gEgo
					setScale: 0
					view: 5331
					setCel: 0
					setLoop: 2
					posn: 248 124
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: 0 901)
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance enterFromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGkSound1 number: 531 setLoop: 1 play:)
				(gEgo
					setScale: 0
					view: 533
					setCel: 0
					setLoop: 2
					posn: 248 124
					init:
					setCycle: End self
				)
			)
			(1
				(gEgo
					normalize: 1 901
					actions: doTheScissors
					scaleSignal: 4
					setScaler: Scaler 100 55 145 115
					posn: 235 123
					setMotion: MoveTo 230 123 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 244) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 244 128 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== local0 105)
					(gEgo
						setScale: 0
						view: 530
						setLoop: 0
						setCel: 14
						setCycle: Beg self
					)
				else
					(gGkSound1 number: 535 setLoop: 1 play:)
					(gEgo
						setScale: 0
						view: 530
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
					(gMessager say: 21 12 13 0) ; "(CURIOUS)This scroll looks interesting."
				)
			)
			(2
				(gGkSound1 number: 536 setLoop: 1 play:)
				(if (== local0 105)
					(gEgo put: 63) ; scroll
					(= cycles 1)
				else
					(gEgo get: 63 getPoints: 182 1) ; scroll
					(= seconds 2)
				)
			)
			(3
				(gEgo normalize: 0 901 setScaler: Scaler 100 55 145 115)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openTheWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 186 123 self)
			)
			(1
				(if (Germany windowIsOpen:)
					(gEgo
						view: 532
						setCel: 0
						setLoop: 0
						setScale: 0
						posn: 186 116
						setCycle: CT 5 1 self
					)
				else
					(gGkSound1 number: 533 setLoop: 1 play:)
					(gEgo
						view: 532
						setCel: 0
						setLoop: 0
						setScale: 0
						posn: 186 116
						setCycle: End self
					)
				)
			)
			(2
				(if (Germany windowIsOpen:)
					(Germany windowIsOpen: 0)
					(theWindow setCel: 0)
					(gEgo setCel: 13 setLoop: 0 setCycle: CT 5 -1 self)
					(gGkSound1 number: 533 setLoop: 1 play:)
				else
					(Germany windowIsOpen: 1)
					(theWindow setCel: 1)
					(= cycles 1)
				)
			)
			(3
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(gEgo
					normalize: 2 901
					setScaler: Scaler 100 55 145 115
					posn: 186 123
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance washHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 186 123 self)
			)
			(1
				(if (Germany windowIsOpen:)
					(gEgo
						view: 532
						setCel: 0
						setLoop: 0
						setScale: 0
						posn: 186 116
						setCycle: CT 5 1 self
					)
				else
					(gGkSound1 number: 533 setLoop: 1 play:)
					(gEgo
						view: 532
						setCel: 0
						setLoop: 0
						setScale: 0
						posn: 186 116
						setCycle: End self
					)
				)
			)
			(2
				(theWindow setCel: 1)
				(gMessager say: 20 8 8 0) ; "Thinking of the first chapel panel, Gabriel washes his hands in the snow."
				(gGkSound1 number: 534 setLoop: 1 play:)
				(gEgo
					setCel: 0
					setLoop: 1
					cycleSpeed: 10
					setCycle: Osc 3 self
				)
			)
			(3
				(theWindow setCel: 0)
				(gEgo setCel: 13 setLoop: 0 setCycle: CT 5 -1 self)
				(gGkSound1 number: 533 setLoop: 1 play:)
			)
			(4
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(gEgo getPoints: -999 1)
				(Germany handsAreWashed: 1)
				(gEgo
					normalize: 2 901
					setScaler: Scaler 100 55 145 115
					posn: 186 123
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getThePot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 104)
					(gEgo put: 61) ; chamPot
				else
					(gEgo get: 61) ; chamPot
				)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 255 129 self)
			)
			(1
				(gEgo getPoints: 181 1)
				(gGkSound1 number: 537 setLoop: 1 play:)
				(if (== local0 104)
					(gEgo view: 531 loop: 0 cel: 6 setCycle: CT 4 -1 self)
				else
					(gEgo view: 531 loop: 0 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(2
				(if (== local0 104)
					(gEgo view: 531 loop: 0 cel: 3 setCycle: Beg self)
					(theChamberPot init:)
				else
					(gEgo view: 531 loop: 0 cel: 3 setCycle: End self)
					(theChamberPot dispose:)
				)
			)
			(3
				(gEgo normalize: 0 901 setScaler: Scaler 100 55 145 115)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheScissors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 246) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 246 128 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== local0 107)
					(gEgo
						view: 530
						setLoop: 1
						setCel: 5
						setCycle: CT 3 -1 self
					)
				else
					(gEgo
						view: 530
						setLoop: 1
						setCel: 0
						setCycle: CT 2 1 self
					)
					(gMessager say: 13 12 7 0) ; "Gabriel takes the scissors."
				)
			)
			(2
				(if (== local0 107)
					(theScissors init:)
					(gEgo put: 66 setCel: 2 setCycle: Beg self) ; scissors
				else
					(theScissors dispose:)
					(gEgo get: 66 setCel: 3 setCycle: End self) ; scissors
				)
			)
			(3
				(= local0 0)
				(gEgo
					normalize: 0 901
					setScaler: Scaler 100 55 145 115
					getPoints: 180 1
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openTheDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5331)
				(gEgo setMotion: PolyPath 36 135 self)
			)
			(1
				(if (not (IsFlag 444))
					(gEgo
						setScale: 0
						view: 5331
						setLoop: 0
						setCel: 0
						setCycle: Osc 1 self
					)
					(gMessager say: 16 6 0 0 self) ; "It's locked."
				else
					(gGkSound1 number: 521 setLoop: 1 play: self)
					(gEgo getPoints: 183 3)
					(gEgo
						setScale: 0
						view: 5331
						setCel: 0
						setLoop: 1
						posn: 2 134
						setCycle: End self
					)
					(if (not (IsFlag 404))
						(gMessager say: 16 108 19 0) ; "(TO HIMSELF. EXCITED)It fits!"
					)
				)
			)
			(2)
			(3
				(if (and (IsFlag 444) (DoSound sndGET_AUDIO_CAPABILITY))
					(gGkSound1 number: 531 setLoop: 1 play: self)
				else
					(self cue:)
				)
			)
			(4
				(if (not (IsFlag 444))
					(gGame handsOn:)
					(gEgo normalize: 1 901 setScaler: Scaler 100 55 145 115)
					(self dispose:)
				else
					(SetFlag 404)
					(gCurRoom newRoom: 520)
				)
			)
		)
	)
)

(instance enterFromLibrary of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					init:
					setScale: 0
					view: 533
					loop: 1
					cel: 0
					posn: 2 134
					setCycle: End self
				)
				(gGkSound1 number: 531 setLoop: 1 play:)
			)
			(1
				(gEgo
					normalize: 0 901
					posn: 36 136
					setScaler: Scaler 100 55 145 115
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 165 132 self)
			)
			(1
				(gEgo view: 535 setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(2
				(gEgo view: 535 setCel: 4 setLoop: 1 setCycle: End self)
				(theKey dispose:)
				(gEgo getPoints: -999 1)
			)
			(3
				(gEgo
					get: 68 ; wolfKey
					normalize: 1 901
					setScaler: Scaler 100 55 145 115
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wakeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					view: 534
					setCel: 0
					setLoop: 0 1
					posn: 95 119
					setPri: 135
					init:
				)
				(= seconds 3)
			)
			(1
				(gEgo setCel: 0 setLoop: 0 cycleSpeed: 10 setCycle: End self)
				(gMessager say: 22 0 16 0) ; "(GETTING UP AFTER NIGHTMARE)What a night! I'm sore all over!"
			)
			(2
				(gEgo setCel: 0 setLoop: 1 posn: 95 135 setCycle: End self)
			)
			(3
				(if (gEgo has: 63) ; scroll
					(gEgo put: 63) ; scroll
				)
				(gEgo
					normalize: 2 901
					actions: doTheScissors
					scaleSignal: 4
					setScaler: Scaler 100 55 145 115
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cutTheHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 246 128 self)
			)
			(1
				(gEgo
					view: 530
					setCel: 0
					setLoop: 2
					cycleSpeed: 10
					setCycle: End self
				)
				(gGkSound1 number: 538 setLoop: 1 play:)
				(gMessager say: 19 107 8 0) ; "Thinking of the second chapel panel, Gabriel cuts his hair."
			)
			(2
				(gEgo getPoints: -999 1)
				(Germany cutHair: 1)
				(theScissors init:)
				(gEgo
					put: 66 ; scissors
					normalize: 0 901
					setScaler: Scaler 100 55 145 115
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance checkTheHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not (== (gEgo x:) 246))
						(not (== (gEgo y:) 128))
					)
					(gEgo setMotion: PolyPath 246 128 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 537
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 9 1 self
				)
			)
			(2
				(gEgo cel: 4 setCycle: CT 9 1 self)
			)
			(3
				(gEgo cel: 10 setCycle: End self)
			)
			(4
				(gEgo normalize: 0 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flame of Prop
	(properties
		noun 8
		sightAngle 20
		x 128
		y 112
		view 533
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 403)
					(gMessager say: noun theVerb 0 0) ; "A fire blazes steadily in the stone fireplace."
				else
					(SetFlag 403)
					(if (== gDay 7)
						(gMessager say: noun theVerb 25 0) ; "Either Wolfgang left VERY recently, or Gerde feels quite at home in this room herself."
					else
						(gMessager say: noun theVerb 24 0) ; "(TO HIMSELF. LOOKING AT FIRE)Maybe that's why I dreamed about fire last night."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWindow of View
	(properties
		noun 20
		x 185
		y 106
		view 532
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (Germany windowIsOpen:)
					(super doVerb: theVerb)
				else
					(gMessager say: 5 theVerb 0 0) ; "A gothic-style window looks out over an incredible view."
				)
			)
			(8 ; Operate
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 2 0) ; "(ADAMANT)Sticking my hands in that cold snow once was enough!"
					)
					((not (Germany windowIsOpen:))
						(gEgo setScript: openTheWindow)
					)
					((Germany handsAreWashed:)
						(gMessager say: noun theVerb 12 0) ; "(ADAMANT)Sticking my hands in that cold snow once was enough!"
					)
					((IsFlag 261)
						(gEgo setScript: washHands)
					)
					(else
						(gMessager say: noun theVerb 9 0) ; "Gabriel would need a pretty good reason to stick his hands in that snow."
					)
				)
			)
			(6 ; Open
				(gEgo setScript: openTheWindow)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theChamberPot of View
	(properties
		noun 12
		sightAngle 20
		x 273
		y 106
		view 536
	)

	(method (init)
		(super init:)
		(self setPri: 130)
	)

	(method (doVerb theVerb)
		(= local0 theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: getThePot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theKey of View
	(properties
		noun 23
		x 146
		y 132
		z 10
		view 535
	)

	(method (init)
		(super init:)
		(self setPri: 129)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: getTheKey)
			)
			(7 ; Look
				(if (IsFlag 401)
					(gMessager say: noun theVerb 18 0) ; "There's a key on the small table."
				else
					(SetFlag 401)
					(gMessager say: noun theVerb 17 0) ; "(TO HIMSELF. DISBELIEF)I don't believe it! It's the key from my dream!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theScissors of View
	(properties
		noun 13
		sightAngle 20
		x 263
		y 107
		view 536
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 130)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (Germany cutHair:)
					(gMessager say: noun theVerb 6 0) ; "(ADAMANT)I'm not picking up those scissors again! I've cut my hair enough!"
				else
					(gEgo setScript: getTheScissors)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance firePlace of Feature
	(properties
		noun 8
		nsLeft 106
		nsTop 82
		nsRight 152
		nsBottom 121
		sightAngle 20
		x 127
		y 106
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 403)
					(gMessager say: noun theVerb 0 0) ; "A fire blazes steadily in the stone fireplace."
				else
					(SetFlag 403)
					(if (== gDay 7)
						(gMessager say: noun theVerb 25 0) ; "Either Wolfgang left VERY recently, or Gerde feels quite at home in this room herself."
					else
						(gMessager say: noun theVerb 24 0) ; "(TO HIMSELF. LOOKING AT FIRE)Maybe that's why I dreamed about fire last night."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bed of Feature
	(properties
		noun 2
		sightAngle 20
		x 98
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 112 67 108 87 111 142 112 147 117 134 121 133 130 53 130
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (== gDay 7)
					(gMessager say: noun theVerb 1 0) ; "(TO PLAYER. PUT OUT)I'm tired, but it's daylight here. I can't sleep when it's light outside."
				else
					(gMessager say: noun theVerb 2 0) ; "(TO PLAYER)After the dream I had last night, I'm not sleeping in that bed again!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bedTable of Feature
	(properties
		noun 9
		sightAngle 20
		x 145
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 118 157 118 157 124 151 131 134 131 134 122
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (gCast contains: theKey)
					(gMessager say: noun theVerb 22 0) ; "At the foot of the bed is a small table."
				else
					(gMessager say: noun theVerb 23 0) ; "At the foot of the bed is a small table."
				)
			)
			(12 ; Pickup
				(if (gCast contains: theKey)
					(gMessager say: noun theVerb 22 0) ; "There's nothing to pick up on that part of the table."
				else
					(gMessager say: noun theVerb 23 0) ; "There's nothing on the table at the moment."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance canopy of Feature
	(properties
		noun 4
		sightAngle 20
		x 61
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 109 111 72 95 73 75 108 52 111 52 130 43 130 43 62 128 63 147 70 149 118 139 111 133 89 133 132 123 132
					yourself:
				)
		)
		(super init:)
	)
)

(instance cabinet of Feature
	(properties
		noun 11
		sightAngle 20
		x 266
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 106 280 101 279 126 267 127 251 125
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(= local0 theVerb)
		(switch theVerb
			(104 ; chamPot
				(gEgo setScript: getThePot)
			)
			(107 ; scissors
				(gEgo setScript: getTheScissors)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallDoor of Feature
	(properties
		noun 3
		sightAngle 20
		x 240
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 74 233 57 245 53 254 71 250 123 228 120
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: leaveTheRoom)
			)
			(8 ; Operate
				(gEgo setScript: leaveTheRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance portalWords of Feature
	(properties
		noun 17
		sightAngle 20
		approachX 58
		approachY 138
		x 14
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 65 0 57 12 51 36 60 36 67 29 69 24 63 9 58 6 69
					yourself:
				)
			approachVerbs: 7 ; Look
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 260)
					(gMessager say: noun theVerb 10 0) ; "The portal says:"
				else
					(gMessager say: noun theVerb 11 0) ; "The portal says:"
					(SetFlag 259)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftLintel of Feature
	(properties
		noun 18
		sightAngle 20
		x 14
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 5 135 0 136 0 67 5 70 yourself:)
		)
		(super init:)
	)
)

(instance rightLintel of Feature
	(properties
		noun 18
		sightAngle 20
		x 14
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 67 32 134 26 134 28 70
					yourself:
				)
		)
		(super init:)
	)
)

(instance lionHead of Feature
	(properties
		noun 14
		sightAngle 20
		x 10
		y 39
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 39 11 31 21 31 30 38 30 57 13 51 0 58
					yourself:
				)
		)
		(super init:)
	)
)

(instance mirror of Feature
	(properties
		noun 7
		nsLeft 271
		nsTop 73
		nsRight 280
		nsBottom 98
		sightAngle 20
		approachX 246
		approachY 128
		x 267
		y 83
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7 11) ; Look, Talk
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 2 0) ; "(LOOKING IN MIRROR)Man, I gotta get more sleep."
					)
					((Germany cutHair:)
						(gMessager say: noun theVerb 6 0) ; "(LOOKING IN MIRROR AFTER HAIR CUT)Great! Now I have a bare patch."
					)
					(else
						(gEgo setScript: checkTheHair)
					)
				)
			)
			(8 ; Operate
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 2 0) ; "(LOOKING IN MIRROR)Man, I gotta get more sleep."
					)
					((Germany cutHair:)
						(gMessager say: noun theVerb 6 0) ; "(LOOKING IN MIRROR AFTER HAIR CUT)Great! Now I have a bare patch."
					)
					(else
						(gEgo setScript: checkTheHair)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyHole of Feature
	(properties
		noun 15
		nsLeft 19
		nsTop 94
		nsRight 27
		nsBottom 102
		sightAngle 30
		x 22
		y 98
	)

	(method (doVerb theVerb)
		(switch theVerb
			(108 ; wolfKey
				(SetFlag 444)
				(gEgo setScript: openTheDoor)
			)
			(6 ; Open
				(gEgo setScript: openTheDoor)
			)
			(8 ; Operate
				(gEgo setScript: openTheDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rug of Feature
	(properties
		noun 10
		sightAngle 30
		x 99
		y 138
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 29 136 37 134 121 134 128 139 110 142 35 138
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftDoor of Feature
	(properties
		noun 16
		sightAngle 30
		x 15
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 73 12 58 21 63 25 71 25 132 5 133
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(108 ; wolfKey
				(SetFlag 444)
				(gEgo setScript: openTheDoor)
			)
			(6 ; Open
				(gEgo setScript: openTheDoor)
			)
			(8 ; Operate
				(gEgo setScript: openTheDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance windowSeat of Feature
	(properties
		noun 6
		sightAngle 30
		x 202
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 163 109 179 109 179 120 200 120 199 110 216 110 216 121 164 121
					yourself:
				)
		)
		(super init:)
	)
)

(instance displayCase of Feature
	(properties
		noun 21
		nsLeft 256
		nsTop 78
		nsRight 269
		nsBottom 101
		sightAngle 30
		x 261
		y 92
	)

	(method (doVerb theVerb)
		(= local0 theVerb)
		(switch theVerb
			(12 ; Pickup
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 2 0) ; "Gabriel's already done all he can with the scroll."
					)
					((gEgo has: 63) ; scroll
						(gMessager say: noun theVerb 14 0) ; "The display case is empty."
					)
					(else
						(gEgo setScript: getTheScroll)
					)
				)
			)
			(6 ; Open
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 2 0) ; "Gabriel's already done all he can with the scroll."
					)
					((gEgo has: 63) ; scroll
						(gMessager say: noun theVerb 14 0) ; "There's no reason to open the empty scroll case."
					)
					(else
						(gEgo setScript: getTheScroll)
					)
				)
			)
			(7 ; Look
				(if (gEgo has: 63) ; scroll
					(gMessager say: noun theVerb 14 0) ; "(ARCC)A large display case hangs on the wall."
				else
					(gMessager say: noun theVerb 13 0) ; "(ARCC)A large display case hangs on the wall."
				)
			)
			(105 ; scroll
				(gEgo setScript: getTheScroll)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doTheScissors of Feature
	(properties
		noun 19
	)

	(method (doVerb theVerb)
		(switch theVerb
			(107 ; scissors
				(if (IsFlag 261)
					(gEgo setScript: cutTheHair)
					(return 1)
				else
					(gMessager say: noun theVerb 9 0) ; "(TO PLAYER. ADAMANT)I don't cut my hair without a damn good reason!"
					(return 1)
				)
			)
			(else
				(gEgo doVerb: theVerb)
			)
		)
	)
)

