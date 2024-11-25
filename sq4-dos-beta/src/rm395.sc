;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 395)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use rmnScript)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Wander)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm395 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
)

(instance rm395 of SQRoom
	(properties
		picture 395
		style 30
		north 390
		east 400
		south 400
		west 390
	)

	(method (init &tmp temp0 temp1)
		(if (and (!= gPrevRoomNum 397) (!= global160 0))
			(SetFlag 13)
		)
		(= local6 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(= gATMBuckazoidCount 2001)
		(cond
			((not (IsFlag 26))
				(crowd init:)
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 setScript: freaksComeOut)
				(SetFlag 26)
				(SetFlag 27)
			)
			((IsFlag 27)
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 x: 225 y: 64 stopUpd:)
				(freak5 x: 239 y: 72 stopUpd:)
				(crowd init:)
			)
		)
		(HandsOff)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 -12)
					(= temp1 81)
				else
					(= temp0 -18)
					(= temp1 -2)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: $8000
				)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 232)
					(= temp1 245)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: $8000
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(397
				(gLongSong number: 405 loop: -1 vol: 127 play:)
				(self setScript: fromStoreScript)
			)
			(else
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 232)
					(= temp1 245)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: $8000
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
		)
		(if (IsFlag 13)
			(door init: priority: 1 setCel: 0)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 14 0 247 0 235 54 174 84 104 47 118 46 93 34 76 34
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 159 212 102 319 7
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 0 129 120 189 0 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 0 35 142 110 105 132 0 78
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 294 189 221 189 154 154 188 132
					yourself:
				)
		)
		(self setRegions: 700) ; mall
		(gEgo init: illegalBits: 0 setPri: -1)
		(atm init:)
		(super init:)
		(b1 init: setStep: 1 1 setMotion: Wander)
		(b2 init: setStep: 1 1 setMotion: Wander)
		(b7 init: setStep: 1 1 setMotion: Wander)
		(if (> (gGame detailLevel:) 0)
			(b1 setMotion: 0 stopUpd:)
			(b2 setMotion: 0 stopUpd:)
			(b7 setMotion: 0 stopUpd:)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((OneOf (gEgo edgeHit:) 2 3)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(self setScript: (ScriptID 700 2) 0 west) ; exS
			)
			((StepOn gEgo 8)
				(if (gCast contains: freak1)
					(if (!= (gEgo illegalBits:) $8000)
						(gEgo illegalBits: $8000)
					)
				else
					(gCurRoom newRoom: 397)
				)
			)
			((StepOn gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(proc700_5 0)
			)
			((StepOn gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
			)
			((or (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo setStep: 3 2 setPri: -1)
				(proc700_5 1)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 395 0) ; "*** software store."
			)
		)
	)

	(method (dispose)
		(DisposeScript 804)
		(DisposeScript 970)
		(= gUseSortedFeatures local6)
		(super dispose:)
	)
)

(instance useCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 110 47 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(cond
					((== (gEgo view:) 374)
						(= local5 1)
					)
					((== (gEgo view:) 4)
						(= local5 0)
					)
					(else
						(= local5 2)
					)
				)
				(gEgo loop: 6)
				(= cycles 2)
			)
			(3
				(gEgo
					view: 396
					loop:
						(switch local5
							(0 0)
							(1 2)
							(2 1)
						)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(4
				(flash
					init:
					posn: 116 22
					loop: 9
					cycleSpeed: 7
					cel: 0
					setCycle: End self
				)
			)
			(5
				(flash loop: 7 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(if (!= local5 1)
					(flash loop: 8)
				)
				(= seconds 3)
			)
			(7
				(flash dispose:)
				(if (== local5 1)
					(Print 395 1) ; "Identification test positive."
				else
					(Print 395 2) ; "Identification test negative."
					(= state 8)
				)
				(= cycles 1)
			)
			(8
				(switch
					(Print ; "*** What operaration would you like?"
						395
						3
						#mode
						0
						#button
						{ Balance }
						0
						#button
						{ Clean House }
						1
						#button
						{ Done }
						2
					)
					(0
						(Printf 395 4 gATMBuckazoidCount) ; "*** The current balance is: $%d"
						(-= state 1)
						(= cycles 1)
					)
					(1
						(if (== gATMBuckazoidCount 0)
							(Print 395 5) ; "*** Fat chance, your account has been exhausted."
						else
							(Printf 395 6 gATMBuckazoidCount) ; "*** You are now $%d richer."
							(SetFlag 31)
							(+= gBuckazoidCount gATMBuckazoidCount)
							(= gATMBuckazoidCount 0)
						)
					)
					(2 0)
				)
				(= cycles 1)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo cycleSpeed: 0 loop: 6)
				(switch local5
					(0
						(NormalEgo 6 0)
					)
					(1
						(gEgo view: 373 setCycle: StopWalk 374)
						(AnimateEgoHead 374)
					)
					(2
						(NormalEgo 6 13)
					)
				)
				(= cycles 1)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(class rssScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local3
			(if (= temp0 ((User curEvent:) type:))
				(Display 395 7 dsRESTOREPIXELS local3)
				(Event dispose:)
				(= local3 0)
				(= seconds 0)
				(= cycles 1)
			)
			(= temp0 evNULL)
		)
	)
)

(instance talkCrowd of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self
					save1:
						(proc0_12
							{"Whats going on in there?"}
							67
							2
							5
							28
							0
							29
							28
							30
							1
							33
							310
						)
				)
				(= seconds 5)
			)
			(2
				(switch local2
					(0
						(= local2 1)
						(self
							save1:
								(proc0_12
									{ALIEN: "The Two Guys from Andromeda are in there signing copies of their latest release!!"}
									67
									2
									100
									28
									0
									29
									28
									30
									1
									33
									310
								)
						)
					)
					(1
						(= local2 2)
						(self
							save1:
								(proc0_12
									{ALIEN: "I just told you! The Two Guys from Andromeda are in there signing copies of their latest release!!"}
									67
									2
									100
									28
									0
									29
									28
									30
									1
									33
									310
								)
						)
					)
					(2
						(= local2 3)
						(self
							save1:
								(proc0_12
									{ALIEN: "Beat it jerk!!"}
									67
									2
									100
									28
									0
									29
									28
									30
									1
									33
									310
								)
						)
					)
					(3
						(self
							save1:
								(proc0_12
									{There is no reply.}
									67
									2
									100
									28
									0
									29
									28
									30
									1
									33
									310
								)
						)
					)
				)
				(= seconds 8)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance freaksComeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(freak1 setCycle: Walk setStep: 4 3 setMotion: PolyPath 225 64)
				(freak5
					setCycle: Walk
					setStep: 4 3
					setMotion: PolyPath 239 72 self
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(freak1 stopUpd:)
				(freak5 stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fromStoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					x: 233
					y: 61
					illegalBits: 0
					setMotion: PolyPath 209 85 self
				)
			)
			(1
				(if (IsFlag 33)
					(HandsOn)
					(client setScript: 0)
				else
					(= cycles 1)
				)
				(= cycles 1)
			)
			(2
				(zap init: posn: 208 100 setCycle: Fwd)
				(= cycles 5)
			)
			(3
				(gEgo view: 26 cel: 0 loop: 1)
				(= cycles 3)
			)
			(4
				(gEgo view: 395 loop: 5 setCycle: Fwd)
				(= seconds 5)
			)
			(5
				(zap dispose:)
				(gEgo view: 26 cel: 0 loop: 1)
				(= cycles 1)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(EgoDead 395 8)
				(= cycles 1)
			)
			(8
				(HandsOn)
				(self dispose:)
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

(instance door of Actor
	(properties
		x 224
		y 84
		view 395
		loop 1
	)
)

(instance b1 of Actor
	(properties
		x 295
		y 104
		view 395
		priority 1
		signal 6160
	)
)

(instance b2 of Actor
	(properties
		x 272
		y 91
		view 395
		cel 1
		priority 1
		signal 6160
	)
)

(instance b3 of Actor ; UNUSED
	(properties
		x 156
		y 27
		view 395
		cel 2
		priority 1
		signal 6160
	)
)

(instance b4 of Actor ; UNUSED
	(properties
		x 165
		y 40
		view 395
		cel 3
		priority 1
		signal 6160
	)
)

(instance b5 of Actor ; UNUSED
	(properties
		x 272
		y 91
		view 395
		cel 3
		priority 1
		signal 6160
	)
)

(instance b6 of Actor ; UNUSED
	(properties
		x 160
		y 34
		view 395
		cel 1
		priority 1
		signal 6160
	)
)

(instance b7 of Actor
	(properties
		x 165
		y 34
		view 395
		priority 1
		signal 6160
	)
)

(instance zap of Prop
	(properties
		view 395
		loop 4
	)
)

(instance atm of Feature
	(properties
		x 110
		y 19
		nsLeft 102
		nsBottom 39
		nsRight 119
		description {ABM machine}
		sightAngle 90
		lookStr {*** Wow, an Auto Bucks Machine!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not (& (gEgo onControl: 1) $4000))
					(Print 395 9) ; "*** Your arms won't reach that far."
				else
					(Print 395 10) ; "*** You play with the buttons, but the machine does not respond."
				)
			)
			(6 ; Inventory
				(switch invItem
					(11 ; atmCard
						(if (not (& (gEgo onControl: 1) $4000))
							(Print 395 9) ; "*** Your arms won't reach that far."
						else
							(gCurRoom setScript: useCard)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance freak1 of Actor
	(properties
		x 140
		y 117
		view 382
		illegalBits 0
	)
)

(instance freak2 of View
	(properties
		x 219
		y 54
		view 388
	)
)

(instance freak3 of View
	(properties
		x 254
		y 69
		view 384
	)
)

(instance freak4 of View
	(properties
		x 263
		y 76
		view 401
		loop 3
	)
)

(instance freak5 of Actor
	(properties
		x 130
		y 117
		view 384
		illegalBits 0
	)
)

(instance freak6 of View
	(properties
		x 202
		y 57
		view 7
		cel 1
	)
)

(instance freak7 of View
	(properties
		x 244
		y 77
		view 395
		loop 6
	)
)

(instance freak8 of View
	(properties
		x 200
		y 60
		view 395
		loop 6
		cel 1
	)
)

(instance crowd of Feature
	(properties
		x 222
		y 46
		nsTop 25
		nsLeft 185
		nsBottom 67
		nsRight 259
		description {crowd}
		sightAngle 90
		lookStr {**** For some reason, there is a gathering here.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (not (gCurRoom script:))
					(if (gEgo inRect: 198 64 239 86)
						(gCurRoom setScript: talkCrowd)
					else
						(Print 395 11) ; "*** No one can here you from over there."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flash of Prop
	(properties
		view 395
		loop 7
	)
)

