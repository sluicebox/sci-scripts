;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 395)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
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
	local7
	local8 = 245
	local9 = 27
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
		(cond
			((not (IsFlag 24))
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 setScript: freaksComeOut)
				(crowd init:)
				(SetFlag 24)
				(SetFlag 25)
			)
			((IsFlag 25)
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
		(gFeatures
			addToFront: atm letters bush1 bush2
			eachElementDo: #init
			doit:
		)
		(zapper init:)
		(zapper2 init:)
		(b1 init: setStep: 1 1 setMotion: Wander)
		(b2 init: setStep: 1 1 setMotion: Wander)
		(b7 init: setStep: 1 1 setMotion: Wander)
		(if (== (gGame detailLevel:) 0)
			(b1 setMotion: 0 stopUpd:)
			(b2 setMotion: 0 stopUpd:)
			(b7 setMotion: 0 stopUpd:)
		)
		(cond
			((and (!= gPrevRoomNum 397) (not (IsFlag 13)))
				(gLongSong2 number: 59 loop: -1 flags: 1 playBed:)
			)
			((IsFlag 13)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
		)
		(if (and (!= gPrevRoomNum 397) (!= global160 0))
			(SetFlag 13)
		)
		(= local6 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
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
					illegalBits: -32768
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
					illegalBits: -32768
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(397
				(gLongSong number: 405 loop: -1 vol: 95 flags: 1 play:)
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
					illegalBits: -32768
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
		)
		(gEgo init: illegalBits: 0 setPri: -1)
		(super init:)
		(if (IsFlag 13)
			(gAddToPics add: door eachElementDo: #init doit:)
			(gCurRoom
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
					((Polygon new:)
						type: PBarredAccess
						init: 14 0 231 0 319 43 319 164 203 106 213 94 183 78 175 88 173 82 111 55 100 54 112 45 91 33 76 34
						yourself:
					)
			)
		else
			(gCurRoom
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
					((Polygon new:)
						type: PBarredAccess
						init: 14 0 247 0 235 54 170 89 99 52 108 45 89 35 76 34
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 171 199 101 319 7
						yourself:
					)
			)
		)
		(store init:)
		(self setRegions: 700) ; mall
	)

	(method (doit &tmp temp0)
		(cond
			(
				(<
					(= temp0
						(GetDistance (gEgo x:) (gEgo y:) local8 local9)
					)
					0
				)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(gLongSong2 vol: (- 127 (/ temp0 3)) changeState:)
		(cond
			(script 0)
			((& (gEgo onControl:) $4000)
				(if (not local4)
					(= local4 1)
					(proc700_5 1)
					(gEgo setMotion: MoveTo 105 45)
				)
			)
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
					(if (!= (gEgo illegalBits:) -32768)
						(gEgo illegalBits: -32768)
					)
				else
					(gCurRoom newRoom: 397)
				)
			)
			((StepOn gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(proc700_5 0)
				(gLongSong fade: 127 10 5 0)
			)
			((StepOn gEgo 2)
				(= local4 0)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
				(gLongSong fade: 95 10 5 0)
			)
			((or (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2 setPri: -1 illegalBits: -32704)
				(proc700_5 1)
			)
		)
		(super doit:)
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
				(HandsOff)
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
				(gEgo setHeading: 45)
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
							(else
								(Print 395 0) ; "error on ATM- report"
							)
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
					(SetScore 83 10)
					(Print 395 1) ; "Identification test positive."
				else
					(Print 395 2) ; "Identification test negative. You obviously don't resemble a blonde woman. What a surprise."
					(SetFlag 33)
					(= state 8)
				)
				(= cycles 1)
			)
			(8
				(switch
					(Print ; "What operation would you like?"
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
						(Printf 395 4 gATMBuckazoidCount) ; "The current balance is: $%d"
						(-= state 1)
						(= cycles 1)
					)
					(1
						(if (== gATMBuckazoidCount 0)
							(Print 395 5) ; "Fat chance, your account has been exhausted."
						else
							(Printf 395 6 gATMBuckazoidCount) ; "You are now $%d richer."
							(SetFlag 29)
							(gEgo get: 0) ; buckazoid
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
						(gEgo view: 402 setCycle: StopWalk 14)
						(AnimateEgoHead 14)
					)
				)
				(= cycles 1)
			)
			(11
				(HandsOn)
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
							{"What's going on in there?"}
							67
							2
							5
							28
							global135
							29
							global129
							30
							1
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
									{ALIEN: "The Two Geeks from Andromeda are in there signing copies of their latest release!!"}
									67
									2
									120
									30
									1
									28
									global135
									29
									global129
								)
						)
					)
					(1
						(= local2 2)
						(self
							save1:
								(proc0_12
									{ALIEN: "I just told you! The Two Geeks from Andromeda are in there signing copies of their latest release!!"}
									67
									2
									120
									30
									1
									28
									global135
									29
									global129
								)
						)
					)
					(2
						(= local2 3)
						(self
							save1:
								(proc0_12
									{ALIEN: "Beat it, jerk!!"}
									67
									2
									120
									30
									1
									28
									global135
									29
									global129
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
									120
									30
									1
									28
									global135
									29
									global129
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

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 993 992 26)
				(HandsOff)
				(gEgo
					x: 233
					y: 61
					illegalBits: 0
					setMotion: PolyPath 209 85 self
				)
			)
			(1
				(if (or (not global160) (IsFlag 31))
					(HandsOn)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(zap init: posn: 208 100 setCycle: Fwd)
				(= cycles 5)
			)
			(3
				(cond
					((OneOf (gEgo view:) 373 374)
						(= register 993)
						(= temp0 0)
					)
					((OneOf (gEgo view:) 402 14)
						(= register 992)
						(= temp0 0)
					)
					((OneOf (gEgo view:) 0 4)
						(= register 26)
						(= temp0 1)
					)
				)
				(gEgo view: register cel: 0 setLoop: temp0)
				(= cycles 2)
			)
			(4
				(switch register
					(993
						(= temp2 register)
						(= temp1 1)
					)
					(992
						(= temp2 register)
						(= temp1 1)
					)
					(26
						(= temp2 395)
						(= temp1 5)
					)
				)
				(gEgo view: temp2 setLoop: temp1 setCycle: Fwd)
				(= seconds 5)
			)
			(5
				(zap dispose:)
				(gEgo view: register cel: 0 setLoop: temp0) ; UNINIT
				(= cycles 1)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(EgoDead 0 2)
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

(instance door of PicView
	(properties
		x 217
		y 90
		description {security door}
		lookStr {This store seems to be closed. A security door blocks the entrance.}
		view 395
		loop 1
		priority 3
		signal 16400
	)
)

(instance b1 of Actor
	(properties
		x 295
		y 104
		description {box}
		lookStr {A few items are on display in the window.}
		view 395
		priority 1
		signal 6160
	)

	(method (doVerb theVerb)
		(if (== theVerb 10) ; Taste
			(if (== (++ local7) 18)
				(Print 395 8) ; "Go Beavers!"
			)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance b2 of Actor
	(properties
		x 272
		y 91
		description {box}
		lookStr {A few items are on display in the window.}
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
		description {box}
		lookStr {A few items are on display in the window.}
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
		description {box}
		lookStr {A few items are on display in the window.}
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
		description {box}
		lookStr {A few items are on display in the window.}
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

(instance letters of Feature
	(properties
		x 198
		y 16
		z 8
		nsLeft 193
		nsBottom 17
		nsRight 204
		description {}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 395 9) ; "QA people were here."
			)
		)
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
		lookStr {Wow, an AutoBucks Teller Machine!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(if (not (& (gEgo onControl: 1) $4000))
					(Print 395 10) ; "Your arms won't reach that far."
				else
					(Print 395 11) ; "You play with the buttons, but the machine does not respond."
				)
			)
			(3 ; Inventory
				(switch invItem
					(10 ; atmCard
						(if (not (& (gEgo onControl: 1) $4000))
							(Print 395 10) ; "Your arms won't reach that far."
						else
							(gCurRoom setScript: useCard)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(11 ; Smell
				(Print 395 12) ; "It smells more like fresh Buckazoids than the other leading brand of ATMs."
			)
			(10 ; Taste
				(Print 395 13) ; "It tastes more like fresh Buckazoids than the other leading brand of ATMs."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance freak1 of Actor
	(properties
		x 156
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
		x 125
		y 133
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
		lookStr {For some reason, there is a gathering here.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(if (not (gCurRoom script:))
					(if (gEgo inRect: 198 64 239 86)
						(gCurRoom setScript: talkCrowd)
					else
						(Print 395 14) ; "No one can hear you from over here."
					)
				)
			)
			(11 ; Smell
				(Print 395 15) ; "You never noticed how much adventure game players tend to smell like potato chips, beer and money."
			)
			(10 ; Taste
				(Print 395 16) ; "With the way this crowd smells, you'd want to lick them?"
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

(instance store of Feature
	(properties
		x 280
		y 30
		description {Software Excess store}
		lookStr {It's the Software Excess store - "If it's soft, we're aware."}
	)

	(method (onMe param1)
		(return (>= -51 (/ (* 100 (- 154 (param1 y:))) (- (param1 x:) 320))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 395 17) ; "The software store smells of turnovers...high employee turnovers and low product turnovers."
			)
			(10 ; Taste
				(Print 395 18) ; "If you think the store leaves a bad taste in your mouth NOW, wait 'till you see the prices."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Feature
	(properties
		x 52
		y 60
		nsTop 41
		nsLeft 46
		nsBottom 69
		nsRight 66
		description {fabricated flora}
		lookStr {This is a fine example of the wonders of fabricated flora.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 395 19) ; "This plant was provided courtesy of Shapeir Florists."
			)
			(10 ; Taste
				(Print 395 20) ; "This plant tastes like another cheap plug for other Sierra products."
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
		y 150
		nsTop 140
		nsLeft 238
		nsBottom 167
		nsRight 261
		description {fabricated flora}
		lookStr {This is a fine example of the wonders of fabricated flora.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 395 19) ; "This plant was provided courtesy of Shapeir Florists."
			)
			(10 ; Taste
				(Print 395 20) ; "This plant tastes like another cheap plug for other Sierra products."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance zapper of Feature
	(properties
		x 179
		y 58
		nsTop 57
		nsLeft 177
		nsBottom 60
		nsRight 181
		description {zapper}
		sightAngle 90
		lookStr {Probably some kind of customer detection system.}
	)
)

(instance zapper2 of Feature
	(properties
		x 239
		y 89
		nsTop 88
		nsLeft 238
		nsBottom 91
		nsRight 240
		description {zapper2}
		sightAngle 90
		lookStr {Probably some kind of customer detection system.}
	)
)

