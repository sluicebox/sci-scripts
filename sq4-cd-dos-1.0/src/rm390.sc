;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use Polygon)
(use MoveFwd)
(use Sound)
(use Motion)
(use System)

(public
	rm390 0
)

(local
	[local0 18] = [181 5 187 8 197 14 211 16 225 20 235 31 250 36 263 41 274 45]
	[local18 37] = [0 0 181 5 0 1 187 8 0 2 197 14 0 3 211 16 0 4 225 20 0 5 235 31 0 6 250 36 0 7 263 41 0 8 274 45 -32768]
	local55
	local56
	local57
	local58
	local59
	local60
	local61
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
		(gLongSong2 number: 999 loop: -1 play: 127)
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
			)
			(410
				(gLongSong number: 405 loop: -1 play:)
				(self setScript: fromElsewhereScript 0 0)
			)
			(else
				(gTheIconBar enable:)
				(gLongSong number: 405 play:)
				(self setScript: fromElsewhereScript 0 1)
			)
		)
		(gLongSong setVol: 127 setPri: 7)
		(super init:)
		(gEgo setPri: -1 code: beltwayCode init: setCycle: SyncWalk)
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
		(store init:)
		(bush1 init:)
		(bush2 init:)
		(steps init:)
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
		(= local60 30)
	)

	(method (doit &tmp [temp0 2])
		(cond
			(script 0)
			((gEgo edgeHit:)
				(HandsOff)
				(if (OneOf (gEgo edgeHit:) 3 2)
					((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
					(self setScript: (ScriptID 700 2) 0 east) ; exS
				else
					((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
					(self setScript: (ScriptID 700 2) 0 west) ; exS
				)
			)
		)
		(Palette palANIMATE 225 236 6)
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

(instance beltwayCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(cond
			((gCurRoom script:) 0)
			((& (= temp1 (gEgo onControl: 1)) local60)
				(cond
					((& temp1 $0010)
						(HandsOff)
						(gCurRoom setScript: goToRamaScript)
					)
					((& temp1 $0008)
						(gCurRoom newRoom: 391)
					)
					((& temp1 $0004)
						(egoBwGreen who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 1) ; mall
						(proc700_5 0)
						(gLongSong fade: 127 10 5 0)
					)
					((& temp1 $0002)
						(egoBwBlue who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 2) ; mall
						(proc700_5 0)
						(gLongSong fade: 95 10 5 0)
					)
				)
			)
			((| (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2 setPri: -1)
				(proc700_5 1)
			)
		)
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

(instance zapScript of Script ; UNUSED
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
					(signSound play:)
				)
				(= cycles 1)
			)
			(1
				(if (> (+= register 2) 16)
					(= register 0)
				)
				(= cycles 3)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sZap of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(client setCycle: MCyc @local18 self)
			)
			(1
				1
				(signSound play: self)
			)
			(2
				2
				(self changeState: 0)
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
		tixCnt 6
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
		tixCnt 6
	)
)

(instance door of Sq4View
	(properties
		x 181
		y 28
		view 390
		loop 1
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 375 say: 1) ; "This store seems to be closed. A security door blocks the entrance."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sp2Squeeze of Script
	(properties)

	(method (doit &tmp temp0)
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
			((& (= temp0 (gEgo onControl: 1)) $0001)
				(client setScript: sp2ShootDown)
			)
			((& temp0 $2000)
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

(instance sp1Squeeze of Script
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
				(tSP1 say: 1) ; "I am in pursuit of Wilco."
			)
			(4
				(tSP2 say: 1 self 2 64 175 70 67 140) ; "How did he get past me?"
			)
			(5
				(tSP1 say: 2 self 2 64 175 80 67 140) ; "He must be hiding in a store."
			)
			(6
				(tSP2 say: 2 self 2 64 175 70 67 140) ; "We must search each one carefully."
			)
			(7
				(tSP1 say: 3 self 2 64 175 80 67 140) ; "I will first search Monolith Burger."
			)
			(8
				(tSP2 say: 3 self 2 64 175 70 67 140) ; "Good. I will cover the the opposite direction."
			)
			(9
				(tSP2 say: 4 self 2 64 175 70 67 140) ; "Long May Vohaul Rule Supreme!"
			)
			(10
				(tSP1 say: 4 self 2 64 175 80 67 140) ; "Yeah... yeah... right."
			)
			(11
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
				(= local55 (- (gEgo y:) 33))
				(= local56 (- ((ScriptID 700 6) y:) 34)) ; sp1
				(= local58 (gEgo x:))
				(= local57 (- ((ScriptID 700 6) x:) 8)) ; sp1
				(= local59
					(Graph
						grSAVE_BOX
						(- local55 1)
						(- local58 1)
						(+ local56 1)
						(+ local57 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local56
					local57
					local55
					local58
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- local58 1)
					(+ local56 1)
					(+ local57 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(2
				(Graph grRESTORE_BOX local59)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- local58 1)
					(+ local56 1)
					(+ local57 1)
				)
				(blast
					init:
					cel: 0
					posn: local58 local55
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 12
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
				(= local56 (- (gEgo y:) 33))
				(= local55 (- ((ScriptID 700 7) y:) 20)) ; sp2
				(= local57 (gEgo x:))
				(= local58 (+ ((ScriptID 700 7) x:) 11)) ; sp2
				(= local59
					(Graph
						grSAVE_BOX
						(- local55 1)
						(- local58 1)
						(+ local56 1)
						(+ local57 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local55
					local58
					local56
					local57
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- local58 1)
					(+ local56 1)
					(+ local57 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				((ScriptID 700 7) setCel: 0) ; sp2
				(Graph grRESTORE_BOX local59)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- local58 1)
					(+ local56 1)
					(+ local57 1)
				)
				(blast
					init:
					cel: 0
					posn: local57 local56
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 12
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
				(= local55 (- (gEgo y:) 33))
				(= local56 (- ((ScriptID 700 7) y:) 28)) ; sp2
				(= local57 (gEgo x:))
				(= local58 (+ ((ScriptID 700 7) x:) 16)) ; sp2
				(= local59
					(Graph
						grSAVE_BOX
						(- local55 1)
						(- local58 1)
						(+ local56 1)
						(+ local57 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local56
					local58
					local55
					local57
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- local58 1)
					(+ local56 1)
					(+ local57 1)
				)
				((ScriptID 700 7) setCycle: End) ; sp2
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local59)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- local58 1)
					(+ local56 1)
					(+ local57 1)
				)
				(blast
					init:
					cel: 0
					posn: local57 local55
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 12
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
				(gNarrator say: 1) ; "These guys mean business, alright. But they sure aren't Harvard graduates."
				(HandsOn)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance blast of Sq4Prop
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

(instance store of Sq4Feature
	(properties
		x 280
		y 30
	)

	(method (onMe param1)
		(return (>= -51 (/ (* 100 (- 151 (param1 y:))) (- (param1 x:) 320))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 3) ; "It feels just like a store with hot dogs and pickles stuck to it."
			)
			(7 ; Taste
				(gNarrator say: 5) ; "It's like licking a battery."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steps of Sq4Feature
	(properties
		y 185
		lookStr 1 ; "These guys mean business, alright. But they sure aren't Harvard graduates."
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 2048))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 1) ; "These guys mean business, alright. But they sure aren't Harvard graduates."
			)
			(6 ; Smell
				(gNarrator say: 6) ; "The smell is an unidentifiable potpourri of the various items that \b3hitched free rides on those shoes."
			)
			(7 ; Taste
				(if (or (== (gEgo view:) 374) (== (gEgo view:) 373))
					(tRogette say: 1) ; "Oh, this doesn't taste good! YUCK!"
				else
					(tRog say: 1) ; "Oh, this doesn't taste good! YUCK!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 60
		y 45
		nsTop 32
		nsLeft 49
		nsBottom 62
		nsRight 70
		lookStr 7 ; "Why, they're those incredibly decorative PermaShrubs from Polyflora Permutations, Incorporated!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 8) ; "There's a powerful eucalyptus odor coming from the plant."
			)
			(7 ; Taste
				(gNarrator say: 9) ; "You lick the plant. Suddenly your sinuses clear up."
			)
			(4 ; Do
				(gNarrator say: 10) ; "They're bolted down. Maybe you're not the first one to try stealing these decorative PermaShrubs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 245
		y 140
		nsTop 129
		nsLeft 239
		nsBottom 157
		nsRight 261
		lookStr 7 ; "Why, they're those incredibly decorative PermaShrubs from Polyflora Permutations, Incorporated!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 8) ; "There's a powerful eucalyptus odor coming from the plant."
			)
			(7 ; Taste
				(gNarrator say: 9) ; "You lick the plant. Suddenly your sinuses clear up."
			)
			(4 ; Do
				(gNarrator say: 10) ; "They're bolted down. Maybe you're not the first one to try stealing these decorative PermaShrubs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tRogette of Sq4Talker
	(properties
		z 400
		noun 7
		view 1009
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 26
		eyeOffsetY 21
	)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tSP1 of Sq4Talker
	(properties
		z 400
		noun 22
		view 1015
		talkerNum 22
		mouthOffsetX 22
		mouthOffsetY 35
	)
)

(instance tSP2 of Sq4Talker
	(properties
		z 400
		noun 14
		view 1016
		talkerNum 14
		mouthOffsetX 21
		mouthOffsetY 34
		eyeOffsetX 1
		eyeOffsetY 1
	)
)

(instance aSound of Sound
	(properties)
)

