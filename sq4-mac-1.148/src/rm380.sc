;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use eRS)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
)

(local
	local0
	[local1 24] = [0 0 0 0 138 40 1 151 43 2 155 51 3 157 57 4 158 59 5 159 63 -1 -1 -1]
	local25 = 151
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
		(cond
			((and (!= gPrevRoomNum 381) (not (IsFlag 10)))
				(gLongSong2 number: 381 loop: -1 playBed:)
			)
			((IsFlag 10)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
		)
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
						init:
						x: -1000
						y: -1000
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
						init:
						x: -1000
						y: -1000
						setScript: tallGuyScript 0 egoBwBlue
					)
				)
			)
			(else
				(gLongSong number: 405 loop: -1 vol: 95 play:)
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
		(tallSign init: cel: (if (IsFlag 6) 4 else 0) stopUpd:)
		(gEgo init: setPri: -1)
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
		(gFeatures
			addToFront: bush bush1 BigTallSign store OutsideTheShop
			eachElementDo: #init
			doit:
		)
	)

	(method (doit &tmp temp0)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) local25 0)) 0)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(gLongSong2 vol: (- 127 (/ temp0 3)) changeState:)
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
				(proc700_5 1)
			)
			((StepOn gEgo 8)
				(gCurRoom newRoom: 381)
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
				(gEgo illegalBits: $8000)
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
					setStep: 3 2
					posn: 148 -58
					setMotion: MoveTo 148 -6 self
				)
			)
			(2
				(soundFX number: 145 vol: 127 loop: 1 play:)
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
				(tallGuy setMotion: MoveTo -18 20 self)
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

(instance door of PicView
	(properties
		x 110
		y 27
		description {security door}
		lookStr {This store seems to be closed.__A security door blocks the entrance.}
		view 380
		loop 3
		priority 1
		signal 16400
	)
)

(instance tallGuy of Actor
	(properties
		x 148
		y -58
		description {tall alien}
		lookStr {Geez! This guy could be a whole basketball team!}
		view 380
		priority 3
		signal 26640
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 380 0) ; "He smells a little like vermicelli."
			)
			(10 ; Taste
				(Print 380 1) ; "What, and moisten his new Size 15 Extra Tall Jumpsuit??"
			)
			(5 ; Talk
				(Print 380 2) ; "After thinking hard, you remember an off-color tall joke. But just as you begin to open your mouth, your strong will to live overcomes your juvenile impulse (i.e. you keep your trap shut)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tallSign of Prop
	(properties
		x 149
		y 27
		view 380
		loop 2
		priority 5
		signal 16
		cycleSpeed 1
	)
)

(instance bush of Feature
	(properties
		x 51
		y 121
		z 32
		nsTop 81
		nsLeft 40
		nsBottom 106
		nsRight 63
		description {fabricated flora}
		sightAngle 90
		lookStr {This is a fine example of the wonders of fabricated flora.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print
					{Don't bother. The fake plants are bolted down because of people like you.}
				)
			)
			(11 ; Smell
				(Print
					{There's a powerful eucalyptus odor coming from the plant.}
				)
			)
			(10 ; Taste
				(Print
					{You lick the plant. You don't learn anything, but your sinuses are clearer.}
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Feature
	(properties
		x 264
		y 109
		z 31
		nsTop 71
		nsLeft 251
		nsBottom 95
		nsRight 275
		description {fabricated flora}
		sightAngle 90
		lookStr {This is a fine example of the wonders of fabricated flora.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print
					{Don't bother. The fake plants are bolted down because of people like you.}
				)
			)
			(11 ; Smell
				(Print
					{There's a powerful eucalyptus odor coming from the plant.}
				)
			)
			(10 ; Taste
				(Print
					{You lick the plant. You don't learn anything, but your sinuses are clearer.}
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance BigTallSign of Feature
	(properties
		x 152
		y 87
		z 73
		nsTop 1
		nsLeft 60
		nsBottom 27
		nsRight 245
		description {Big and Tall Sign}
		sightAngle 90
		lookStr {The sign reads "BIG and Tall".}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 380 3) ; "Forget it. You'll only get hurt."
			)
			(11 ; Smell
				(Print
					{It smells like expensive cologne, leather and tobacco.}
				)
			)
			(10 ; Taste
				(Print {It tastes like sewage, vinyl and tobacco.})
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance OutsideTheShop of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {Big and Tall Alien Store}
		sightAngle 500
		lookStr {You are outside the Big and Tall Alien store.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 380 4) ; "The mall has that high-rent, low-occupancy smell...like any office building in downtown Los Angeles."
			)
			(10 ; Taste
				(Print 380 5) ; "It's against the Third Law of Mall Security to be caught licking mall components."
			)
			(2 ; Look
				(super doVerb: theVerb)
			)
			(else 0)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance store of Feature
	(properties
		x 145
		description {Big and Tall}
		lookStr {This place sells body covers for the big, tall, and otherwise bizarre alien.}
	)

	(method (onMe param1)
		(return (<= 5 (/ (* 100 (- 90 (param1 y:))) (Max 1 (param1 x:)))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print
					{It smells like expensive cologne, leather and tobacco.}
				)
			)
			(10 ; Taste
				(Print {It tastes like sewage, vinyl and tobacco.})
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

