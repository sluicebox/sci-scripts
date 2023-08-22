;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use eRS)
(use Sq4Feature)
(use Polygon)
(use Sound)
(use Motion)
(use System)

(public
	rm380 0
)

(local
	local0
	[local1 24] = [0 0 0 0 138 40 1 151 43 2 155 51 3 157 57 4 158 59 5 159 63 -1 -1 -1]
	local25 = 151
	local26 = 1
)

(instance rm380 of SQRoom
	(properties
		picture 380
		style 10
		east 385
		west 375
	)

	(method (init &tmp temp0 temp1)
		(Load rsVIEW 380)
		(Load rsSOUND 145)
		(HandsOff)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 -40)
					(= temp1 135)
				else
					(= temp0 -12)
					(= temp1 105)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(if (or (IsFlag 6) (IsFlag 10))
					(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
				else
					(tallGuy
						x: -1000
						y: -1000
						setSpeed: gGameSpeed
						init:
						setScript: tallGuyScript 0 egoBwGreen
					)
				)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 340)
					(= temp1 123)
				else
					(= temp0 339)
					(= temp1 84)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(if (or (IsFlag 6) (IsFlag 10))
					(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
				else
					(tallGuy
						x: -1000
						y: -1000
						setSpeed: gGameSpeed
						init:
						setScript: tallGuyScript 0 egoBwBlue
					)
				)
			)
			(else
				(gLongSong number: 405 loop: -1 play: 95)
				(gEgo posn: -10 -10)
				(self
					setScript:
						(if (TestMallFlag (ScriptID 700 0) #rFlag1 128) ; mall
							tossScript
						else
							fromStoreScript
						)
				)
			)
		)
		(tallSign cel: (if (IsFlag 6) 4 else 0) init: stopUpd:)
		(gEgo setPri: -1 code: beltwayCode init: setCycle: SyncWalk)
		(super init:)
		(if (IsFlag 10)
			(gAddToPics add: door eachElementDo: #init doit:)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 78 209 83 193 64 114 69 105 88 0 92 0 0 319 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 151 0 110 89 0 94 0 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 78 203 84 178 41 175 0
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 138 319 189 0 189 0 152
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 111 133 103 131 123 120 127 0 133
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 95 319 116 187 123 179 101
					yourself:
				)
		)
		(self setRegions: 700) ; mall
		(bush init:)
		(bush1 init:)
		(BigTallSign init:)
		(store init:)
		(OutsideTheShop init:)
		(cond
			((and (!= gPrevRoomNum 381) (not (IsFlag 10)))
				(gLongSong2 number: 381 loop: -1 play: 65)
			)
			((IsFlag 10)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (not (-- local26))
			(cond
				(
					(<
						(= temp0
							(GetDistance (gEgo x:) (gEgo y:) local25 0)
						)
						0
					)
					(= temp0 0)
				)
				((> temp0 300)
					(= temp0 300)
				)
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local26 60)
		)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(gLongSong2 stop:)
				(self setScript: (ScriptID 700 2) 0 west) ; exS
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromStoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo
					x: 151
					y: 56
					illegalBits: 0
					heading: 180
					setMotion: MoveTo 151 80 self
				)
			)
			(2
				(proc700_5 1)
				(HandsOn)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance tossScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(= seconds 5)
			)
			(1
				(if (!= [local1 (+= local0 3)] -1)
					(-- state)
					(gEgo
						view: 392
						illegalBits: 0
						setLoop: 1
						cel: [local1 local0]
						posn: [local1 (+ local0 1)] [local1 (+ local0 2)]
					)
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(2
				(HandsOn)
				(NormalEgo 2 402 14)
				(proc700_5 1)
				((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ff7f)) ; mall, mall
				(self dispose:)
			)
		)
	)
)

(instance beltwayCode of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((StepOn gEgo 16)
				(gEgo setPri: 1)
			)
			((StepOn gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(gEgo setPri: -1)
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
				(gEgo xStep: 3 yStep: 2)
				(proc700_5 1)
			)
			((StepOn gEgo 8)
				(gCurRoom newRoom: 381)
			)
		)
	)
)

(instance sDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(if (< 130 ((ScriptID 700 9) x:) 240) ; shopper3
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance tallGuyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< 130 ((ScriptID 700 9) x:) 240) ; shopper3
					(self setScript: sDS self)
				else
					(= cycles 1)
				)
			)
			(1
				(tallGuy
					setCycle: Walk
					setPri: 1
					setSpeed: gGameSpeed
					setStep: 3 2
					posn: 148 -58
					setMotion: MoveTo 148 -6 self
				)
			)
			(2
				(soundFX number: 145 loop: 1 play:)
				(tallSign setCycle: CT 2 1 self)
			)
			(3
				(tallSign setCycle: End)
				(tallGuy setMotion: MoveTo 148 14 self)
			)
			(4
				(SetFlag 6)
				(gCurRoom setScript: (ScriptID 700 1) 0 register) ; enS
				(tallGuy
					setLoop: 1
					setPri: 6
					setMotion: MoveTo (- (tallGuy x:) 40) 20 self
				)
			)
			(5
				(tallGuy setSpeed: gGameSpeed setMotion: MoveTo -18 20 self)
			)
			(6
				(proc700_5 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff 1
		xTweak 2
		key 270
		head 86
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff 1
		xTweak 2
		key 90
		head 265
		xDir -1
		yDir 1
	)
)

(instance door of Sq4View
	(properties
		x 110
		y 27
		view 380
		loop 3
		priority 1
		signal 16400
		lookStr 13 ; "This place sells body covers for the big, tall, and otherwise hard to fit alien."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tallGuy of Sq4Actor
	(properties
		x 148
		y -58
		view 380
		priority 3
		signal 26640
		illegalBits 0
		lookStr 4 ; "Geez! This guy could be a whole basketball team!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 5) ; "He smells a little like vermicelli."
			)
			(7 ; Taste
				(gNarrator say: 6) ; "What, and moisten his new Size 15 Extra Tall Jumpsuit??"
			)
			(2 ; Talk
				(gNarrator say: 7) ; "You suddenly remember an off-color tall joke. But as you begin to open your mouth, your will to live overcomes your juvenile impulse (in other words, you wisely keep your trap shut)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tallSign of Sq4Prop
	(properties
		x 149
		y 27
		view 380
		loop 2
		priority 5
		signal 16
		cycleSpeed 12
	)
)

(instance bush of Sq4Feature
	(properties
		x 51
		y 121
		z 32
		nsTop 81
		nsLeft 40
		nsBottom 106
		nsRight 63
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 370 say: 12) ; "This is a fine example of the wonders of fabricated flora."
			)
			(4 ; Do
				(gNarrator say: 1) ; "Don't bother. The fake plants are bolted down because of people like you."
			)
			(6 ; Smell
				(gNarrator say: 8) ; "The sign reads "BIG and Tall"."
			)
			(7 ; Taste
				(gNarrator say: 7) ; "You suddenly remember an off-color tall joke. But as you begin to open your mouth, your will to live overcomes your juvenile impulse (in other words, you wisely keep your trap shut)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 264
		y 109
		z 31
		nsTop 71
		nsLeft 251
		nsBottom 95
		nsRight 275
		sightAngle 90
		lookStr 13 ; "This place sells body covers for the big, tall, and otherwise hard to fit alien."
	)

	(method (doVerb theVerb)
		(bush doVerb: theVerb)
	)
)

(instance BigTallSign of Sq4Feature
	(properties
		x 152
		y 87
		z 73
		nsTop 1
		nsLeft 60
		nsBottom 27
		nsRight 245
		sightAngle 90
		lookStr 8 ; "The sign reads "BIG and Tall"."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 9) ; "Forget it. You'll only get hurt."
			)
			(6 ; Smell
				(gNarrator say: 2) ; "It smells like expensive cologne, leather and tobacco."
			)
			(7 ; Taste
				(gNarrator say: 3) ; "It tastes like sewage, vinyl and tobacco."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance OutsideTheShop of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 500
		lookStr 10 ; "You are outside the Big and Tall Alien store."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 11) ; "The mall has that high-rent, low-occupancy smell...like any office building in downtown Los Angeles."
			)
			(7 ; Taste
				(gNarrator say: 12) ; "It's against the Third Law of Mall Security to be caught licking mall components."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance store of Sq4Feature
	(properties
		x 145
		lookStr 13 ; "This place sells body covers for the big, tall, and otherwise hard to fit alien."
	)

	(method (onMe param1)
		(return (<= 5 (/ (* 100 (- 90 (param1 y:))) (Max 1 (param1 x:)))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 2) ; "It smells like expensive cologne, leather and tobacco."
			)
			(7 ; Taste
				(gNarrator say: 3) ; "It tastes like sewage, vinyl and tobacco."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

