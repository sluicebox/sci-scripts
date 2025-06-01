;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use rmnScript)
(use eRS)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	[local0 18] = [181 5 187 8 197 14 211 16 225 20 235 31 250 36 263 41 274 45]
	local18
	local19
	local20
	local21
	local22
)

(instance rm390 of SQRoom
	(properties
		picture 390
		style 10
		north 385
		east 395
		south 395
		west 385
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 -12)
					(= temp1 81)
				else
					(= temp0 -9)
					(= temp1 -6)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
				(gLongSong2 stop:)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 256)
					(= temp1 249)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
				(gLongSong2 stop:)
			)
			(410
				(gLongSong2 stop:)
				(gLongSong number: 405 loop: -1 play:)
				(self setScript: fromElsewhereScript 0 0)
			)
			(else
				(gTheIconBar enable:)
				(gLongSong2 stop:)
				(gLongSong number: 405 play:)
				(self setScript: fromElsewhereScript 0 1)
			)
		)
		(gLongSong vol: 127 loop: -1 priority: 7 changeState:)
		(super init:)
		(zap init: setScript: zapScript)
		(gEgo init: setPri: -1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 113 65 145 64 157 44 170 40 179 13 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 23 147 99 110 123 0 65
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 235 189 149 144 189 120 319 187 319 189
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 150 189 95 189 117 171 yourself:)
		)
		(if (and (IsFlag 23) (not (IsFlag 22)))
			(Load rsSOUND 105)
			((ScriptID 700 7) ; sp2
				illegalBits: 0
				ignoreActors:
				init:
				posn: -14 79
				setScript: sp2Squeeze
			)
			((ScriptID 700 6) illegalBits: 0 ignoreActors:) ; sp1
		)
		(self setRegions: 700) ; mall
		(gFeatures
			addToFront: store bush1 bush2 steps
			eachElementDo: #init
			doit:
		)
		(if (IsFlag 12)
			(gAddToPics add: door eachElementDo: #init doit:)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 21 0 319 0 319 150 224 101 235 82 181 53 156 69
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:) type: PBarredAccess init: 316 0 163 73 21 0 yourself:)
					((Polygon new:)
						type: PBarredAccess
						init: 319 152 226 105 319 51
						yourself:
					)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((OneOf (gEgo edgeHit:) 3 2)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((OneOf (gEgo edgeHit:) 1 4)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(self setScript: (ScriptID 700 2) 0 west) ; exS
			)
			((StepOn gEgo 16)
				(HandsOff)
				(self setScript: goToRamaScript)
			)
			((StepOn gEgo 8)
				(gCurRoom newRoom: 391)
			)
			((StepOn gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(proc700_5 0)
				(gLongSong fade: 127 10 5 0)
			)
			((StepOn gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
				(gLongSong fade: 95 10 5 0)
			)
			((or (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2 setPri: -1)
				(proc700_5 1)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 391)
			(gLongSong fade: 40 10 10 0)
		)
		(cond
			((OneOf newRoomNumber 391 410 900)
				(super newRoom: newRoomNumber)
			)
			((!= script (ScriptID 700 2)) ; exS
				(HandsOff)
				(self setScript: (ScriptID 700 2) 0 1) ; exS
			)
			((and script (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromElsewhereScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if register
					(= temp0 224)
					(= temp1 54)
					(= temp2 196)
					(= temp3 82)
				else
					(= temp0 -3)
					(= temp1 244)
					(= temp2 71)
					(= temp3 170)
				)
				(gEgo x: temp0 y: temp1 setMotion: MoveTo temp2 temp3 self)
			)
			(1
				(proc700_5 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToRamaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 225 setMotion: MoveFwd 80 self)
			)
			(1
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance zapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					x: [local0 register]
					y: [local0 (+ register 1)]
					cel: (/ register 2)
				)
				(if (and (< register 3) (> global106 1))
					(signSound priority: 1 changeState: play:)
				)
				(= cycles 1)
			)
			(1
				(if (> (+= register 2) 16)
					(= register 0)
				)
				(self init:)
			)
		)
	)
)

(instance zap of Prop
	(properties
		x 181
		y 5
		view 390
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 390 0) ; "It's the Radio Shock sign. It seems to be designed after some ancient electronic experiments."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 315
		head 119
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 135
		head 301
		xDir -1
		yDir 1
	)
)

(instance door of PicView
	(properties
		x 181
		y 28
		description {security door}
		view 390
		loop 1
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 390 1) ; "This store seems to be closed. A security door blocks its entrance."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sp2Squeeze of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (not state) (or (< (gEgo x:) 219) (StepOn gEgo 8192)))
				(self cue:)
			)
			((gCurRoom script:))
			(
				(and
					(< (gEgo y:) (- ((ScriptID 700 7) y:) 12)) ; sp2
					(not (StepOn gEgo 8192))
				)
				(client setScript: sp2ShootEgo)
			)
			((StepOn gEgo 1)
				(client setScript: sp2ShootDown)
			)
			((StepOn gEgo 8192)
				(gCurRoom setScript: hideEgoInStore)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 700 7) ; sp2
					view: 7
					setLoop: 2
					setCel: 5
					setStep: 2 2
					setMotion: MoveTo 89 133 self
				)
			)
			(2
				((ScriptID 700 6) init: setScript: sp1Squeeze) ; sp1
				((ScriptID 700 7) ; sp2
					setStep: 3 2
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 134 122 self
				)
			)
			(3
				((ScriptID 700 7) view: 13 loop: 3 cel: 0 stopUpd:) ; sp2
				(self dispose:)
			)
		)
	)
)

(instance sp1Squeeze of rmnScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((gCurRoom script:))
			(
				(and
					(< ((ScriptID 700 6) x:) 310) ; sp1
					(not (& (gEgo onControl: 1) $2000))
				)
				(client setScript: sp1ShootEgo)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 6) ; sp1
					setStep: 2 2
					posn: 330 182
					view: 13
					setLoop: 1
					setCel: 0
					init:
					setMotion: MoveTo 199 112 self
				)
			)
			(1
				((ScriptID 700 6) ; sp1
					setStep: 3 2
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 159 116 self
				)
			)
			(2
				((ScriptID 700 6) view: 13 loop: 1 cel: 0 stopUpd:) ; sp1
				(= seconds 3)
			)
			(3
				(self save1: (proc0_12 390 2 67 175 80 70 140))
				(= seconds 5)
			)
			(4
				(self restore:)
				(self save1: (proc0_12 390 3 67 25 127 28 global132))
				(= seconds 4)
			)
			(5
				(self restore:)
				(self save1: (proc0_12 390 4 67 175 70 70 140))
				(= seconds 4)
			)
			(6
				(self restore:)
				(self save1: (proc0_12 390 5 67 20 127 28 global132))
				(= seconds 5)
			)
			(7
				(self restore:)
				(self save1: (proc0_12 390 6 67 145 38 70 170))
				(= seconds 6)
			)
			(8
				(self restore:)
				(self save1: (proc0_12 390 7 67 30 130 28 global132 70 176))
				(= seconds 6)
			)
			(9
				(self restore:)
				(self save1: (proc0_12 390 8 67 145 38 70 170))
				(= seconds 5)
			)
			(10
				(self restore:)
				(self save1: (proc0_12 390 9 67 60 130 28 global132))
				(= seconds 3)
			)
			(11
				(self restore:)
				((ScriptID 700 6) view: 7 setMotion: MoveTo 148 85 self) ; sp1
			)
			(12
				((ScriptID 700 6) ; sp1
					view: 13
					setLoop: 1
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 1 1
				)
				(= cycles 10)
			)
			(13
				((ScriptID 700 7) view: 7 setMotion: MoveTo 143 156 self) ; sp2
			)
			(14
				((ScriptID 700 7) ; sp2
					view: 13
					setLoop: 0
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 267 236 self
				)
			)
			(15
				(hideEgoInStore cue:)
				(self dispose:)
			)
		)
	)
)

(instance sp1ShootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 700 6) setLoop: 3 cel: 0 setCycle: End self) ; sp1
			)
			(1
				(= local18 (- (gEgo y:) 33))
				(= local19 (- ((ScriptID 700 6) y:) 34)) ; sp1
				(= local21 (gEgo x:))
				(= local20 (- ((ScriptID 700 6) x:) 8)) ; sp1
				(= local22
					(Graph
						grSAVE_BOX
						(- local18 1)
						(- local21 1)
						(+ local19 1)
						(+ local20 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local19
					local20
					local18
					local21
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(2
				(Graph grRESTORE_BOX local22)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(blast
					init:
					cel: 0
					posn: local21 local18
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 1
					ignoreActors:
					setCycle: End self
				)
			)
			(3
				(EgoDead 8 3) ; "Next time, don't dilly-dally, dude!"
			)
		)
	)
)

(instance sp2ShootDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 700 7) ; sp2
					view: 13
					setLoop: 4
					setCel: 0
					setPri: (gEgo priority:)
				)
				(= cycles 4)
			)
			(1
				((ScriptID 700 7) setCycle: CT 1 1 self) ; sp2
			)
			(2
				(= local19 (- (gEgo y:) 33))
				(= local18 (- ((ScriptID 700 7) y:) 20)) ; sp2
				(= local20 (gEgo x:))
				(= local21 (+ ((ScriptID 700 7) x:) 11)) ; sp2
				(= local22
					(Graph
						grSAVE_BOX
						(- local18 1)
						(- local21 1)
						(+ local19 1)
						(+ local20 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local18
					local21
					local19
					local20
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				((ScriptID 700 7) setCel: 0) ; sp2
				(Graph grRESTORE_BOX local22)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(blast
					init:
					cel: 0
					posn: local20 local19
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 1
					ignoreActors:
					setCycle: End self
				)
			)
			(4
				(EgoDead 8 3) ; "Next time, don't dilly-dally, dude!"
			)
		)
	)
)

(instance sp2ShootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 700 7) view: 13 setLoop: 0 setCel: 0) ; sp2
				(= cycles 2)
			)
			(1
				((ScriptID 700 7) setCycle: CT 1 1 self) ; sp2
			)
			(2
				(= local18 (- (gEgo y:) 33))
				(= local19 (- ((ScriptID 700 7) y:) 28)) ; sp2
				(= local20 (gEgo x:))
				(= local21 (+ ((ScriptID 700 7) x:) 16)) ; sp2
				(= local22
					(Graph
						grSAVE_BOX
						(- local18 1)
						(- local21 1)
						(+ local19 1)
						(+ local20 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local19
					local21
					local18
					local20
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				((ScriptID 700 7) setCycle: End) ; sp2
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local22)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(blast
					init:
					cel: 0
					posn: local20 local18
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 1
					ignoreActors:
					setCycle: End self
				)
			)
			(4
				(EgoDead 8 3) ; "Next time, don't dilly-dally, dude!"
			)
		)
	)
)

(instance hideEgoInStore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 192 49 self)
			)
			(1
				(gEgo setPri: 1 setMotion: MoveTo 171 47)
			)
			(2
				(gEgo setMotion: MoveTo 192 49 self)
			)
			(3
				(gEgo setPri: -1 setMotion: MoveTo 199 86 self)
			)
			(4
				(= cycles 4)
			)
			(5
				(Print 390 10) ; "These guys mean business, alright. But they sure aren't Harvard graduates."
				(HandsOn)
				(gEgo illegalBits: $8000)
				(self dispose:)
			)
		)
	)
)

(instance blast of Prop
	(properties
		view 28
		signal 16384
	)
)

(instance signSound of Sound
	(properties
		number 391
		priority 1
	)
)

(instance store of Feature
	(properties
		x 280
		y 30
		description {Radio Shock}
	)

	(method (onMe param1)
		(return (>= -51 (/ (* 100 (- 151 (param1 y:))) (- (param1 x:) 320))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 390 11) ; "Radio Shock - a Dandy store."
			)
			(3 ; Do
				(Print 390 12) ; "It feels just like a store with hot dogs and pickles stuck to it."
			)
			(11 ; Smell
				(Print 390 13) ; "It smells like all the other 15,000,000,000 Radio Shocks all throughout the Greater Crab Nebula Metro Area."
			)
			(10 ; Taste
				(Print 390 14) ; "It's like licking a battery."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steps of Feature
	(properties
		y 185
		description {steps}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 2048))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 390 15) ; "These steps lead down to the Skate-O-Rama."
			)
			(11 ; Smell
				(Print 390 16) ; "They smell like used foot powder, ground sole dust, and an interesting potpourri of granules from the various items that hitched free rides on said shoes."
			)
			(10 ; Taste
				(Print 390 17) ; "Oh, this doesn't taste good! YUCK!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Feature
	(properties
		x 60
		y 45
		nsTop 32
		nsLeft 49
		nsBottom 62
		nsRight 70
		description {fabricated flora}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 390 18) ; "Why, they're those incredibly decorative PermaShrubs from Polyflora Permutations, Inc! (As seen on TV!)"
			)
			(11 ; Smell
				(Print 390 19) ; "There's a powerful eucalyptus odor coming from the plant."
			)
			(10 ; Taste
				(Print 390 20) ; "You lick the plant. You don't learn anything, but your sinuses are clearer."
			)
			(3 ; Do
				(Print 390 21) ; "They're bolted down. Maybe you're not the first one to try stealing these decorative PermaShrubs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Feature
	(properties
		x 245
		y 140
		nsTop 129
		nsLeft 239
		nsBottom 157
		nsRight 261
		description {fabricated flora}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 390 22) ; "Why, they're those incredibly decorative and disturbingly durable Polyflora PermaShrubs from the wonderful beings at Permutronics Synthefacturing. (As seen on TV!)"
			)
			(11 ; Smell
				(Print 390 23) ; "There's a powerful eucalyptus odor coming from the plant."
			)
			(10 ; Taste
				(Print 390 24) ; "You lick the plant. You don't learn anything, but your sinuses are clearer."
			)
			(3 ; Do
				(Print 390 25) ; "They're bolted down. Maybe you're not the first one to try stealing these decorative PermaShrubs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

