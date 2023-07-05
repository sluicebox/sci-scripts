;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use AnimDialog)
(use eureka)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm240 0
	proc240_1 1
	bea 2
	getOffPad 3
	getOnPad 4
	chamber 5
	proc240_6 6
	proc240_7 7
	spike 8
	openTank 9
	beaTalker 10
	tkrCliffy 11
	tkrRoger 15
	bubbles 20
	cliffy 21
	northDoor 22
	bang 23
	tankTop 24
	proc240_25 25
	proc240_26 26
	tank 27
	proc240_28 28
	proc240_29 29
	proc240_30 30
)

(local
	[local0 20] = [20 123 148 85 154 30 135 140 164 144 189 123 123 123 123 13 120 141 73 145]
	[local20 24] = [111 134 180 4 110 135 115 133 79 138 90 0 104 136 109 135 155 139 270 1 131 137 126 136]
	[local44 24] = [5 113 135 3 116 133 111 125 2 94 139 1 70 141 38 142 3 139 139 0 164 141 180 141]
	[local68 6] = [112 133 106 135 123 136]
	local74
	local75
	local76
	local77
	local78
	local79
	local80
	local81
	[local82 4]
)

(procedure (localproc_0)
	(cond
		((== gPrevRoomNum 246)
			(= global130 8)
		)
		((!= (eureka puke:) 0)
			(= global130 0)
		)
		((and (== global113 4) (not (& global169 $0004)) (>= global127 3))
			(|= global169 $0004)
			(= global130 9)
		)
		((and (== global113 8) (<= 700 gPrevRoomNum 799))
			(SetFlag 103)
			(= global130 11)
		)
		(
			(and
				(== global113 6)
				(!= gPrevRoomNum 225)
				(== global142 1)
				(not (IsFlag 45))
			)
			(= global130 2)
		)
		((and (== global113 3) (== gPrevRoomNum 325))
			(cond
				((gEgo has: 12) ; Cloaking_Device
					(SetFlag 80)
					(if (& global169 $0020)
						(if (== global170 1)
							(= global130 4)
						else
							(= global130 2)
						)
					else
						(= global130 10)
					)
				)
				((not (& global169 $0020))
					(= global130 13)
				)
				((== global170 1)
					(= global130 4)
				)
				(else
					(= global130 2)
				)
			)
		)
		(
			(or
				(== global130 7)
				(and (== global170 1) (!= global130 0))
				(and (== global130 6) (== gPrevRoomNum 225))
			)
			(= global170 1)
			(= global130 4)
		)
		((and (== global113 14) (== (eureka puke:) 0))
			(= global130 8)
		)
	)
)

(procedure (proc240_28 param1)
	(cliffy
		view: 20
		setLoop: -1
		loop:
			(if argc
				param1
			else
				(cliffy loop:)
			)
		setScript: 0
		setCycle: StopWalk -1
		setLoop: Grooper
		setScale: Scaler 116 71 149 123
		setStep: 2 2
		setPri: -1
		cycleSpeed: 6
		moveSpeed: 6
		detailLevel: 0
	)
)

(procedure (proc240_30)
	(cond
		((IsFlag 61)
			(if (!= (gSq5Music1 number:) 20)
				(gSq5Music1 number: 20 loop: -1 play:)
			)
		)
		((IsFlag 84)
			(if (!= (gSq5Music1 number:) 42)
				(gSq5Music1 number: 42 loop: -1 play:)
			)
		)
		(else
			(gSq5Music1 number: 101 loop: -1 play:)
		)
	)
)

(procedure (proc240_29 param1)
	(spike
		view: 242
		setLoop: -1
		loop:
			(if argc
				param1
			else
				(spike loop:)
			)
		setScript: 0
		setCycle: Walk
		setScale: Scaler 85 50 144 122
		setPri: -1
		detailLevel: 0
	)
)

(procedure (proc240_25 param1)
	(if argc
		(= local79 param1)
	)
	(return local79)
)

(procedure (proc240_26 param1)
	(if argc
		(= local80 param1)
	)
	(return local80)
)

(procedure (proc240_7 param1)
	(if argc
		(= local81 param1)
	)
	(return local81)
)

(procedure (proc240_1 param1)
	(if argc
		(= local74 param1)
	)
	(return local74)
)

(procedure (proc240_6 param1 param2)
	(= local76 param1)
	(= local77 param2)
)

(instance rm240 of Rm
	(properties
		noun 19
		picture 43
		style 10
		vanishingX 81
		vanishingY 87
	)

	(method (init &tmp temp0)
		(if (== (gSq5Music2 number:) 105)
			(theMusic3 number: 105 loop: -1 play:)
			(gSq5Music2 stop:)
		)
		(if (== gPrevRoomNum 1040)
			(eureka puke: 1)
		)
		(LoadMany rsVIEW 0 259 250)
		(gEgo view: 0 actions: 0)
		(gCurRoom setRegions: 210) ; eureka
		(if (== gPrevRoomNum 246)
			(= style 100)
		)
		(super init:)
		(if (IsFlag 57)
			(stain addToPic:)
		)
		(tkrRoger normal: 1)
		(tkrCliffy normal: 1)
		((ScriptID 244 0) doit:) ; initCyclers
		(tank init: setOnMeCheck: 1 8)
		(cryoDoor init:)
		(chamber init:)
		(cryoButton init: setOnMeCheck: 1 4)
		(thePad init: setOnMeCheck: 1 2)
		(tankTop init:)
		(gWalkHandler addToFront: self)
		(gWalkHandler addToFront: thePad)
		(gWalkHandler addToFront: northDoor)
		(gDirectionHandler addToFront: self)
		(northDoor init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 19 157 82 157 84 131 144 131 176 153 233 153 233 148 202 134 161 134 150 127 181 127 175 125 154 125 150 122 128 122 132 125 113 125 112 122 94 122 94 125 19 125
					yourself:
				)
		)
		(cliffy init:)
		(droole init:)
		(flo init:)
		(wd40 init:)
		(spike init:)
		(proc240_30)
		(if (== global164 9)
			(bea init:)
		)
		(cond
			((== gPrevRoomNum 246)
				(NormalEgo 0 2)
				(gEgo init: x: 225 y: 146 setScale: Scaler 116 71 149 123)
				(gGame handsOn:)
			)
			((== (eureka puke:) 7)
				(gEgo
					init:
					view: 239
					loop: 3
					cel: 0
					setPri: 1
					posn: 42 138
					setScale: 0
				)
				(self setScript: (ScriptID 245 0)) ; specialEntry
			)
			((== gPrevRoomNum 241)
				(NormalEgo 0 2)
				(gEgo
					init:
					loop: 2
					posn: 170 126
					setScale: Scaler 116 71 149 123
				)
				(gGame handsOn:)
			)
			((<= 300 gPrevRoomNum 399)
				(switch gPrevRoomNum
					(300
						(SetScore 175 175)
						(if (and (gEgo has: 20) (== global130 4)) ; WD40_Head
							(gCurRoom setScript: (ScriptID 243 14)) ; specialBeam
						else
							(= local75 2)
							(gCurRoom setScript: beamRoger 0 1)
						)
					)
					(325
						(cond
							((gEgo has: 12) ; Cloaking_Device
								(gCurRoom setScript: (ScriptID 243 21)) ; upFromKU
							)
							((& global169 $0020)
								(= local75 2)
								(gCurRoom setScript: beamRoger 0 1)
							)
							(else
								(gCurRoom setScript: (ScriptID 243 31)) ; upFromKU2
							)
						)
					)
				)
			)
			((and (== global113 6) (!= gPrevRoomNum 225))
				(if (and (== global142 1) (not (IsFlag 45)))
					(= local74 0)
					(LoadMany rsVIEW 256 255 257 258 259)
					(gCurRoom setScript: (ScriptID 243 1)) ; upFromThrakus
				else
					(gCurRoom setScript: (ScriptID 243 29)) ; upFromThrakus2
				)
			)
			((and (== global113 8) (!= gPrevRoomNum 225) (not (& global169 $0002)))
				(LoadMany rsVIEW 6 20 0)
				(self setScript: (ScriptID 243 23)) ; talkAboutBea
			)
			((and (== global113 8) (<= 700 gPrevRoomNum 799))
				(self setScript: (ScriptID 243 31)) ; upFromKU2
			)
			((OneOf gPrevRoomNum 300 325 500 400 410 420 730 760 1040)
				(= local75 2)
				(gCurRoom setScript: beamRoger 0 1)
			)
			(else
				(NormalEgo 0 2)
				(gEgo
					init:
					setLoop: 2
					posn: 41 119
					setPri: 1
					setScale: Scaler 116 71 149 123
				)
				(gCurRoom setScript: enterRoom)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser canControl:)
				(not script)
				local74
				(& (event type:) $0040) ; direction
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
			)
			(switch (event message:)
				(JOY_UP
					(= local76 111)
					(= local77 125)
					(gCurRoom setScript: getOffPad 0 0)
				)
				(JOY_RIGHT
					(= local76 180)
					(= local77 141)
					(gCurRoom setScript: getOffPad 0 2)
				)
				(JOY_LEFT
					(= local76 38)
					(= local77 142)
					(gCurRoom setScript: getOffPad 0 1)
				)
			)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(= local76 gMouseX)
		(= local77 gMouseY)
		(switch theVerb
			(3 ; Walk
				(cond
					(local81
						(gMessager say: noun 3 13 0) ; "You had better put her in the cryo-chamber. She's starting to get a little ripe."
					)
					(local74
						(cond
							((InRect 66 120 159 131 gMouseX gMouseY)
								(gCurRoom setScript: getOffPad 0 0)
								(return 1)
							)
							((< gMouseX 113)
								(gCurRoom setScript: getOffPad 0 1)
								(return 1)
							)
							(else
								(gCurRoom setScript: getOffPad 0 2)
								(return 1)
							)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(2 ; Talk
				(if local74
					(gCurRoom setScript: beamRoger 0 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((and (StepOn gEgo 16) (== global126 3))
				(self setScript: (ScriptID 243 8)) ; spikeNailsEgo
			)
			(
				(and
					(InRect 88 129 139 132 gEgo)
					(== (gEgo heading:) 180)
				)
				(gCurRoom setScript: getOnPad 0 0)
			)
			((and (StepOn gEgo 32) (not local74))
				(cond
					(
						(and
							(InRect 66 120 159 131 gEgo)
							(== (gEgo heading:) 180)
						)
						(gCurRoom setScript: getOnPad 0 0)
					)
					(
						(and
							(< 132 (gEgo y:) 146)
							(< (gEgo x:) 113)
							(== (gEgo heading:) 90)
						)
						(gCurRoom setScript: getOnPad 0 1)
					)
					(
						(and
							(> (gEgo x:) 155)
							(== (gEgo heading:) 270)
							(< 132 (gEgo y:) 146)
						)
						(gCurRoom setScript: getOnPad 0 2)
					)
				)
			)
		)
	)

	(method (dispose)
		(gEgo setScript: 0)
		(gWalkHandler delete: northDoor)
		(gWalkHandler delete: self)
		(gWalkHandler delete: thePad)
		(gDirectionHandler delete: self)
		(DisposeScript 956)
		(DisposeScript 969)
		(DisposeScript 991)
		(DisposeScript 243)
		(DisposeScript 244)
		(DisposeScript 245)
		(if (== (theMusic3 number:) 105)
			(gSq5Music2 number: 105 loop: -1 play:)
			(theMusic3 stop:)
		)
		(super dispose: &rest)
	)
)

(instance droole of Actor
	(properties
		x 133
		y 140
		noun 13
		view 31
		signal 24576
	)

	(method (cue)
		(cond
			((<= 400 gPrevRoomNum 499)
				(self setScript: extraLeaves 0 self)
			)
			((OneOf global113 4)
				(self dispose:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: noun 2 14 0) ; "I'm ready when you are, sir. Let's get going."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(cond
			(
				(and
					(not (IsFlag 76))
					(== global113 5)
					(== gPrevRoomNum 225)
					(IsFlag 30)
				)
				(super init: &rest)
				(self cel: (self lastCel:))
			)
			((and (not (IsFlag 74)) (== global113 4) (>= global127 3))
				(super init: &rest)
				(self cel: (self lastCel:))
			)
		)
	)
)

(instance flo of Actor
	(properties
		x 126
		y 140
		view 32
		signal 24576
	)

	(method (cue)
		(if (== global113 4)
			(self dispose:)
		)
	)

	(method (init)
		(if (and (not (IsFlag 74)) (== global113 4) (>= global127 3))
			(super init: &rest)
			(self cel: (self lastCel:))
		)
	)
)

(instance cliffy of Actor
	(properties
		x 122
		y 145
		noun 5
		yStep 1
		view 33
		signal 24576
		xStep 2
	)

	(method (cue)
		(if (== global130 9)
			(= global130 0)
			(self dispose:)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(switch global130
					(5
						(gCurRoom setScript: (ScriptID 243 27)) ; askAboutBea
					)
					(8
						(gCurRoom setScript: (ScriptID 243 28)) ; goliathConv
					)
					(else
						(if (Message msgSIZE 240 noun theVerb local78 1)
							(gMessager say: noun theVerb local78 0)
						else
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
			((Message msgSIZE 240 noun theVerb local78 1)
				(gMessager say: noun theVerb local78 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(= local78 53)
		(localproc_0)
		(cond
			((== global130 9)
				(self
					view: 33
					loop: 0
					posn: 122 145
					cel: (self lastCel:)
					detailLevel: 0
				)
				(super init: &rest)
			)
			((== global130 11)
				(self view: 33 loop: 0 detailLevel: 0 posn: 122 145 cel: 0)
				(if (< global164 8)
					(= local78 5)
				else
					(= local78 53)
				)
				(super init: &rest)
			)
			((== global130 13)
				(self view: 33 loop: 0 detailLevel: 0 posn: 122 145 cel: 0)
				(super init: &rest)
			)
			((== global130 2)
				(super init: &rest)
				(self
					view: 191
					loop: 0
					x: 239
					y: 164
					detailLevel: 2
					setPri: 13
					setScale: Scaler 116 71 149 123
					setScript: bang
				)
			)
			((== global130 4)
				(super init: &rest)
				(self
					view: 248
					loop: 0
					cel: 0
					x: 226
					y: 170
					detailLevel: 2
					setPri: 13
					setScale: Scaler 116 71 149 123
					setCycle: Fwd
					setScript: bang
				)
				(= local78 6)
			)
			((OneOf global130 5 12 8)
				(self
					view: 26
					loop: 0
					cel: 0
					posn: 238 162
					setScale: Scaler 116 71 149 123
					setScript: bang
				)
				(if (== global130 5)
					(= local78 5)
				else
					(= local78 8)
				)
				(super init: &rest)
			)
			((== global130 10)
				(SetFlag 80)
				(self
					view: 21
					loop: 11
					cel: 0
					detailLevel: 0
					scaleSignal: 1
					scaleX: 120
					scaleY: 120
					posn: 92 77
				)
				(super init: &rest)
			)
		)
	)
)

(instance extraView of View
	(properties
		x 256
		y 143
		view 248
		loop 2
		cel 1
		priority 1
		signal 16400
	)
)

(instance stain of View
	(properties
		x 249
		y 87
		noun 23
		view 247
		loop 1
		priority 11
		signal 16400
	)

	(method (doVerb)
		(tank doVerb: &rest)
	)
)

(instance spike of Actor
	(properties
		noun 22
		view 244
		signal 16384
	)

	(method (init param1)
		(switch global126
			(7
				(self
					view: 245
					loop: 0
					cel: 0
					posn: 197 139
					setPri: 10
					x: 185
					y: 115
					setScale: Scaler 116 71 149 123
				)
				(super init: &rest)
			)
			(2
				(self
					view: 244
					loop: 2
					cel: 0
					x: 253
					y: 101
					setPri: 11
					setScale: 0
					detailLevel: 3
					setCycle: Fwd
				)
				(super init:)
				(bubbles setCycle: Fwd init:)
			)
			(3
				(spike view: 242 x: 146 y: 181)
			)
		)
		(if (and argc param1)
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== global126 2)
				(tank doVerb: theVerb &rest)
			)
			((and (== global126 7) (== theVerb 2)) ; Talk
				(gCurRoom setScript: (ScriptID 243 27)) ; askAboutBea
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wd40 of Actor
	(properties
		x 113
		y 139
		noun 28
		view 248
		signal 24576
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((== global113 5)
						(gMessager say: noun 2 50 0) ; "What do you make of this situation, WD40?"
					)
					((and (== global113 6) (IsFlag 63) (< global164 8))
						(gMessager say: noun 2 47 0) ; "Any ideas what i should do with the ambassador, WD40?"
					)
					((and (== global113 8) (not (IsFlag 75)))
						(gMessager say: noun 2 45 0) ; "I recommend a thorough investigation of the installation, Captain."
					)
					((and (IsFlag 80) (== global164 8))
						(gMessager say: noun 2 49 0) ; "Can you give me an analysis on our best course of action now that we have the cloaking device, WD40?"
					)
					((and (not (IsFlag 80)) (== global164 8))
						(gMessager say: noun 2 48 0) ; "Do you have any idea what we can do to stop the Goliath, WD40?"
					)
					(else
						(gMessager say: noun 2 41 0) ; "Yes, Captain?"
					)
				)
			)
			(else
				(if (Message msgSIZE 240 noun theVerb 41 1)
					(gMessager say: noun theVerb 41 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (init)
		(cond
			((== global170 1)
				(self
					view: 248
					loop: 2
					cel: 0
					x: 255
					y: 144
					setPri: 13
					noun: 27
				)
				(extraView noun: 19 addToPic:)
				(super init: &rest)
			)
			((and (== global170 2) (== (eureka puke:) 0))
				(self
					view: 265
					loop: 0
					x: 124
					y: 107
					setScale: 0
					cycleSpeed: 15
					noun: 28
					setCycle: Fwd
				)
				(super init: &rest)
				(extraView
					view: 265
					loop: 1
					cel: 0
					x: 124
					y: 107
					noun: 28
					addToPic:
				)
			)
		)
	)
)

(instance lookInChamber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 170 126 self)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 241)
			)
		)
	)
)

(instance chamber of Actor
	(properties
		x 241
		y 132
		view 259
		loop 2
		cel 1
		priority 9
		signal 22544
	)

	(method (setMotion param1)
		(if param1
			(gSq5Music2 number: 160 loop: 1 play:)
		)
		(super setMotion: param1 &rest)
	)

	(method (setCycle param1)
		(if param1
			(gSq5Music2 number: 103 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (init)
		(cond
			(
				(and
					(== global113 14)
					(> (eureka puke:) 2)
					(OneOf global164 8 10)
				)
				(self view: 24 loop: 1 posn: 203 132 setCycle: Fwd)
				(= global164 10)
				(super init: &rest)
			)
			((IsFlag 44)
				(self
					view: 259
					loop: 2
					x: 202
					y: 132
					setPri: 10
					cel: (if (IsFlag 45) 0 else 1)
				)
				(super init: &rest)
				(self stopUpd:)
			)
			((== (gCurRoom script:) openBox)
				(super init: &rest)
			)
		)
		(= noun
			(switch global164
				(1 7)
				(8 8)
				(10 6)
				(else 11)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((== global164 8)
						(gMessager say: 8 1 0 0) ; "Bea is currently spending some quality time recuperating in the cryo."
					)
					(local81
						(gMessager say: 11 1 13 0) ; "You have your hands full right now. Try putting Bea down first."
					)
					((== global164 9)
						(gMessager say: 11 1 0 0) ; "The cryo chamber is currently unoccupied."
					)
					((== global164 10)
						(gMessager say: 6 1 0 0) ; "It would seem Bea is anxious to exit the chamber."
					)
					((and (IsFlag 45) (== view 259))
						(gCurRoom setScript: lookInChamber)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(4 ; Do
				(cond
					((== global164 8)
						(gMessager say: 8 4 0 0) ; "Bea still needs some time to rest and recuperate from her ordeal."
					)
					((== global164 10)
						(gCurRoom setScript: (ScriptID 245 1)) ; beaClimbsOut
					)
					((== global164 9)
						(gMessager say: 7 4 11 0) ; "Opening the chamber would not be prudent at this juncture."
					)
					((IsFlag 45)
						(if (== view 259)
							(cond
								((== global130 5)
									(gMessager say: 7 4 8 0) ; "Not now. You better figure out what your 'lil buddy spike is trying to tell you, first."
								)
								((OneOf global164 2 1)
									(gCurRoom setScript: (ScriptID 243 4)) ; openChamber
								)
								(else
									(gMessager say: 7 4 11 0) ; "Opening the chamber would not be prudent at this juncture."
								)
							)
						else
							(gCurRoom setScript: (ScriptID 243 6)) ; getBeaFromChamber
						)
					)
					((or (gCast contains: bea) local81)
						(cond
							((and (== view 259) (== cel 1))
								(if local81
									(gMessager say: 11 4 13 0) ; "Try opening the chamber without Bea in your hands. Your efforts will meet with greater success."
								else
									(gCurRoom setScript: (ScriptID 243 4)) ; openChamber
								)
							)
							(local81
								(gCurRoom setScript: (ScriptID 243 2)) ; putBeaInBox
							)
							(else
								(gMessager say: 11 4 12 0) ; "You don't want to close the chamber yet. Trust us."
							)
						)
					)
					(else
						(gMessager say: 7 4 11 0) ; "Opening the chamber would not be prudent at this juncture."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tankTop of Prop
	(properties
		x 233
		y 87
		view 244
		loop 4
		signal 16384
	)

	(method (init param1)
		(if (IsFlag 43)
			(= cel (self lastCel:))
			(super init: &rest)
			(self stopUpd:)
		else
			(= cel 0)
		)
		(if (and argc param1)
			(super init: &rest)
			(self startUpd:)
		)
	)

	(method (setCycle param1)
		(if param1
			(gSq5Music2 number: 108 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (doVerb theVerb)
		(tank doVerb: theVerb &rest)
	)
)

(instance bubbles of Prop
	(properties
		x 254
		y 101
		view 244
		loop 3
		priority 12
		signal 16400
		detailLevel 3
	)
)

(instance cryoDoor of Prop
	(properties
		x 224
		y 99
		noun 10
		view 259
		loop 1
		priority 10
		signal 22544
	)

	(method (setCycle param1)
		(if param1
			(gSq5Music2 number: 103 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (init)
		(if (not (IsFlag 44))
			(if (== (gCurRoom script:) closeBox)
				(self cel: (self lastCel:))
			)
			(super init: &rest)
		)
		(self stopUpd:)
	)
)

(instance bea of Actor
	(properties
		x 97
		y 186
		z 50
		view 256
		loop 1
		priority 15
		signal 16400
	)

	(method (init)
		(if (== global164 9)
			(self
				view: 25
				loop: 0
				cel: 15
				posn: 128 143 0
				noun: 4
				setScale: Scaler 116 71 149 123
			)
		else
			(self stopUpd:)
			(= noun 3)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== global164 9)
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: (ScriptID 243 5)) ; pickBeaUp
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance extraLeaves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0
					(switch register
						(cliffy 0)
						(droole 5)
						(wd40 15)
					)
				)
				(register
					view: [local0 (+ temp0 0)]
					loop: 2
					setCycle: StopWalk -1
					setLoop: Grooper
					setScale: Scaler 116 71 149 123
					posn: [local0 (+ temp0 1)] [local0 (+ temp0 2)]
					setMotion:
						MoveTo
						[local0 (+ temp0 3)]
						[local0 (+ temp0 4)]
						self
				)
			)
			(1
				(register setMotion: PolyPath 44 127 self)
			)
			(2
				(northDoor setCycle: End self)
			)
			(3
				(register setPri: 0 setMotion: MoveTo 45 120 self)
			)
			(4
				(northDoor setCycle: Beg self)
			)
			(5
				(northDoor stopUpd:)
				(gGame handsOn:)
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 41 130 self)
			)
			(1
				(gEgo setPri: -1 setLoop: -1)
				(northDoor setCycle: Beg self)
			)
			(2
				(if (== global130 9)
					(gSq5Music2 number: 260 loop: 1 play:)
					(cliffy setCycle: Beg cliffy)
					(flo setCycle: Beg flo)
					(droole setCycle: Beg droole)
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(3
				(switch global130
					(5
						(gMessager say: 5 2 9 0 self) ; "Where'd ya run off to, chief? The ambassador's gettin' kinda ripe--we need to come up with something pronto."
					)
					(12
						(gMessager say: 5 2 10 0 self) ; "The transporter is ready to go sir. Put the ambassador on it and I'll make a few delicate adjustments."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(northDoor stopUpd:)
				(cond
					((and (gEgo has: 20) (== global130 4)) ; WD40_Head
						(= next (ScriptID 243 14)) ; specialBeam
					)
					((and (== global130 8) (not (& global169 $0008)))
						(= next (ScriptID 243 28)) ; goliathConv
					)
					(else
						(gGame handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance bang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gGame detailLevel:) (cliffy detailLevel:))
					(cliffy stopUpd:)
					(-- state)
				else
					(cliffy startUpd:)
					(switch (cliffy view:)
						(191
							(cliffy setLoop: (Random 0 3))
							(if (== (cliffy loop:) 2)
								(cliffy setLoop: 4)
							)
							(= register (Random 3 7))
						)
						(26
							(cliffy setLoop: (Random 0 2))
							(= register 1)
						)
						(else
							(cliffy setLoop: (Random 0 1))
							(= register (Random 3 7))
						)
					)
				)
				(= cycles 1)
			)
			(1
				(cliffy cel: 0 setCycle: End self)
			)
			(2
				(if (-- register)
					(-= state 2)
				else
					(-= state 3)
				)
				(switch (cliffy view:)
					(191
						(theMusic3
							number:
								(switch (cliffy loop:)
									(3 2422)
									(4 233)
									(else 230)
								)
							loop: 1
							play: self
						)
					)
					(26
						(= seconds 5)
					)
					(else
						(theMusic3
							number: (if (cliffy loop:) 230 else 232)
							loop: 1
							play: self
						)
					)
				)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local74
					(self setScript: getOffPad self 1)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 41 130 self)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(cond
					((gEgo has: 8) ; Spike
						(= state 0)
						(if (not (IsFlag 30))
							(self setScript: (ScriptID 243 26) self) ; spikeEscapes2
						else
							(self setScript: putSpikeBack self)
						)
					)
					((and (== global126 2) (not (IsFlag 56)))
						(self setScript: (ScriptID 243 10) self) ; spikeEscapes
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(northDoor setCycle: End self)
			)
			(5
				(gEgo setPri: 1 setLoop: 3 setMotion: MoveTo 41 119 self)
			)
			(6
				(if (gAddToPics contains: stain)
					(ClearFlag 57)
				)
				(switch global126
					(5
						(= global126 4)
					)
					(2
						(if (not (IsFlag 56))
							(SetFlag 57)
							(= global126 4)
						)
					)
				)
				(gCurRoom newRoom: 225)
			)
		)
	)
)

(instance getOnPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(gGame handsOff:)
				)
				(= local75 register)
				(*= register 8)
				(gEgo
					setMotion:
						PolyPath
						[local20 register]
						[local20 (+ register 1)]
						self
				)
			)
			(1
				(gEgo setHeading: [local20 (+ register 2)] self)
			)
			(2
				(gEgo
					view: 250
					cel: 0
					loop: [local20 (+ register 3)]
					posn: [local20 (+ register 4)] [local20 (+ register 5)]
					setCycle: End self
				)
			)
			(3
				(NormalEgo 0 2)
				(gEgo
					setScale: 0
					heading: 180
					posn: [local20 (+ register 6)] [local20 (+ register 7)]
				)
				(= local74 1)
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance getOffPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(*= register 8)
				(gEgo
					heading: 180
					setMotion:
						MoveTo
						[local20 (+ register 6)]
						[local20 (+ register 7)]
						self
				)
			)
			(1
				(gEgo
					view: 250
					cel: 0
					loop: [local44 register]
					posn: [local44 (+ register 1)] [local44 (+ register 2)]
					setCycle: End self
				)
			)
			(2
				(NormalEgo 0 [local44 (+ register 3)])
				(gEgo
					setScale: Scaler 116 71 149 123
					setPri: 10
					posn: [local44 (+ register 4)] [local44 (+ register 5)]
					setMotion:
						MoveTo
						[local44 (+ register 6)]
						[local44 (+ register 7)]
						self
				)
			)
			(3
				(gEgo setPri: -1)
				(= local74 0)
				(if (== client gCurRoom)
					(gEgo setMotion: PolyPath local76 local77)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance putSpikeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 22 0 32 0 self) ; "I'd better put old Spikey back."
			)
			(1
				(self setScript: (ScriptID 243 9) self) ; putSpikeInTank
			)
			(2
				(self setScript: openTank self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance beamRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (gEgo has: 8) (not (OneOf global113 4 14))) ; Spike
					(self setScript: putSpikeBack self)
				else
					(+= state 1)
					(= cycles 2)
				)
			)
			(1
				(self setScript: getOnPad self 2)
			)
			(2
				(if (not register)
					(gMessager say: 18 2 26 0 self) ; "Energize!"
				else
					(= cycles 1)
				)
			)
			(3
				(cond
					((and (== (eureka puke:) 7) (== global126 2) (not register))
						(self setScript: (ScriptID 245 2) self) ; spikeComesWith
					)
					((and (== global113 8) (IsFlag 75) (not register))
						(self setScript: (ScriptID 243 24) self) ; cliffyGoesWith
					)
					(
						(and
							(== global113 3)
							(IsFlag 9)
							(not (& global169 $0020))
							(not (IsFlag 80))
							(not register)
							(!= global130 0)
						)
						(self setScript: (ScriptID 243 24) self) ; cliffyGoesWith
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gEgo
					view: 6
					loop: 0
					posn: [local68 (* local75 2)] [local68 (+ (* local75 2) 1)]
				)
				(if register
					(gEgo setScale: Scaler 116 71 149 123 init:)
					(if (Random 0 2)
						(gEgo cel: 0 cycleSpeed: 6 setCycle: End self)
						(gSq5Music2 number: 260 loop: 1 play:)
					else
						(self setScript: (ScriptID 243 30) self) ; funnyBeam
					)
				else
					(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
					(gSq5Music2 number: 260 loop: 1 play:)
					(if (and (gCast contains: droole) (== (droole view:) 31))
						(droole setCycle: Beg droole)
					)
					(if (and (gCast contains: cliffy) (== (cliffy view:) 33))
						(cliffy setCycle: Beg cliffy)
					)
					(if (and (== global164 9) (gCast contains: bea))
						(bea setCycle: Beg)
					)
				)
			)
			(5
				(gSq5Music2 stop:)
				(proc240_30)
				(cond
					((and (== global113 8) (not (IsFlag 75)))
						(= next (ScriptID 243 13)) ; beamToGenetix
						(self dispose:)
					)
					(
						(and
							(== global113 14)
							(<= 2 (eureka puke:) 6)
							(not register)
						)
						(= next (ScriptID 243 13)) ; beamToGenetix
						(self dispose:)
					)
					(
						(and
							(IsFlag 63)
							(IsFlag 76)
							(IsFlag 75)
							(== global164 1)
						)
						(= next (ScriptID 243 23)) ; talkAboutBea
						(self dispose:)
					)
					(register
						(NormalEgo 0 2)
						(gEgo
							setScale: 0
							heading: 180
							posn:
								[local20 (+ (* local75 8) 6)]
								[local20 (+ (* local75 8) 7)]
						)
						(= local74 1)
						(if (not (extraLeaves client:))
							(gGame handsOn:)
						)
						(if (and (== global113 14) (== (eureka puke:) 1))
							(gMessager say: 29 2 55 0) ; "***Captain get up here quick! The puckoid mass is attacking the Goliath!"
						)
						(self dispose:)
					)
					(else
						(gEgo hide:)
						(= local74 0)
						(= seconds 3)
					)
				)
			)
			(6
				(gEgo get: 10) ; Communicator
				(if (and (!= global113 14) (IsFlag 84))
					(EgoDead 11) ; "Next time, don't dawdle."
				else
					(switch global113
						(3
							(if (and (IsFlag 9) (not (IsFlag 89)))
								(gCurRoom newRoom: 325)
							else
								(ClearFlag 61)
								(gCurRoom newRoom: 300)
							)
						)
						(4
							(if (< global127 3)
								(= next (ScriptID 243 25)) ; bounceEgo
								(self dispose:)
							else
								(SetFlag 74)
								(gCurRoom newRoom: 500)
							)
						)
						(5
							(if (not (IsFlag 30))
								(= next (ScriptID 243 25)) ; bounceEgo
								(self dispose:)
							else
								(gCurRoom newRoom: 410)
							)
						)
						(7
							(= next (ScriptID 243 25)) ; bounceEgo
							(self dispose:)
						)
						(8
							(if (IsFlag 75)
								(gCurRoom newRoom: 730)
							else
								(gCurRoom newRoom: 760)
							)
						)
						(6
							(gCurRoom newRoom: 620)
						)
						(14
							(cond
								((== (eureka puke:) 7)
									(if (== global164 9)
										(if (IsFlag 59)
											(gCurRoom newRoom: 1040)
										else
											(gCurRoom newRoom: 1001)
										)
									else
										(EgoDead 37) ; "Bea is dead. In an alternate future she would've bourne your son. In the future past of Space Quest 4 your son would've saved your life from the time rippers. But she didn't so he couldn't, therefore you aren't."
									)
								)
								((< 0 (eureka puke:) 7)
									(EgoDead 48) ; "Wasting all that time beaming back and forth gave the big snot ball enough time to munch down on the Goliath and the Eureka. Having no particular place to beam to, your molecules spread out across the universe."
								)
								(else
									(= next (ScriptID 243 25)) ; bounceEgo
									(self dispose:)
								)
							)
						)
						(else
							(EgoDead 45) ; "Handy transporter safety tip #21: Beaming directly into deep space may cause serious injury or death."
						)
					)
				)
			)
		)
	)
)

(instance openTank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(gGame handsOff:)
				)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 223 146 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(gEgo
					view: 243
					loop: 0
					cel: 0
					posn: 222 145
					looper: 0
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(gSq5Music2 number: 124 loop: 1 play: self)
			)
			(5
				(gEgo setCycle: Beg self)
				(if (IsFlag 43)
					(tankTop setCycle: Beg self)
					(bubbles init: cel: (bubbles lastCel:) setCycle: Beg self)
				else
					(tankTop init: 1 setCycle: End self)
					(bubbles init: cel: 0 setCycle: End self)
				)
			)
			(6)
			(7)
			(8
				(bubbles dispose:)
				(NormalEgo 0 6)
				(gEgo setScale: Scaler 116 71 149 123 posn: 223 146)
				(if (IsFlag 43)
					(ClearFlag 43)
					(tankTop dispose:)
				else
					(SetFlag 43)
					(tankTop stopUpd:)
				)
				(if (== client gCurRoom)
					(if (and (== global126 2) (IsFlag 43))
						(= next (ScriptID 243 11)) ; getSpike
					else
						(gGame handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance openBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 205 139 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(gEgo
					view: 243
					loop: 2
					cel: 0
					posn: 205 139
					setCycle: End self
				)
			)
			(4
				(gSq5Music2 number: 124 loop: 1 play:)
				(= seconds 2)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo 0 6)
				(gEgo
					x: 205
					y: 139
					setScale: Scaler 116 71 149 123
					setHeading: 45 self
				)
			)
			(7
				(chamber init:)
				(cryoDoor setCycle: End self)
			)
			(8
				(chamber setPri: 9 setMotion: MoveTo 202 132 self)
			)
			(9
				(gEgo setHeading: 0 self)
			)
			(10
				(proc240_30)
				(SetFlag 44)
				(chamber init:)
				(cryoDoor dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 205 139 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gEgo
					view: 243
					loop: 2
					cel: 0
					posn: 205 139
					setCycle: End self
				)
			)
			(4
				(gSq5Music2 number: 124 loop: 1 play:)
				(= seconds 2)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo 0 6)
				(gEgo
					x: 205
					y: 139
					setScale: Scaler 116 71 149 123
					setHeading: 45 self
				)
			)
			(7
				(chamber setPri: 9 setMotion: MoveTo 241 132 self)
			)
			(8
				(gEgo setHeading: 90 self)
			)
			(9
				(ClearFlag 44)
				(cryoDoor init: setCycle: Beg self)
			)
			(10
				(chamber dispose:)
				(cryoDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance beaTalker of Talker
	(properties
		x 172
		y 55
		view 261
		loop 1
		signal 16384
	)

	(method (init)
		(= font gUserFont)
		(if local80
			(= gSystemWindow gSpeakWindow)
			(self
				view: 261
				loop: 1
				cel: 0
				x: 172
				y: 55
				signal: 16384
				disposeWhenDone: 1
			)
			(gSystemWindow tailX: 205 tailY: 93 isBottom: 0 xOffset: 20)
			(beaMouth view: 261 loop: 0 nsLeft: 3 nsTop: 21 signal: 16384)
			(super init: 0 0 beaMouth &rest)
		else
			(self
				view: 1001
				loop: 0
				x: 10
				y: 25
				textX: 120
				textY: 10
				talkWidth: 150
				disposeWhenDone: 1
			)
			(= gSystemWindow gSq5Win)
			(beaMouth view: 1001 loop: 1 nsLeft: 47 nsTop: 34)
			(beaEyes setLoop: (Random 2 3))
			(super init: 0 beaEyes beaMouth &rest)
		)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance beaEyes of Prop
	(properties
		nsTop 20
		nsLeft 54
		view 1001
		loop 2
	)
)

(instance beaMouth of Prop
	(properties
		nsTop 21
		nsLeft 3
		view 261
		signal 16384
	)
)

(instance tkrCliffy of ChoiceTalker
	(properties
		x 0
		y 5
		view 1003
		talkWidth 150
		keepWindow 1
		textX 115
		textY 20
	)

	(method (init)
		(= keepWindow (not normal))
		(= font gUserFont)
		(cliffyEyes setLoop: (Random 2 3))
		(super init: cliffyBust cliffyEyes cliffyMouth &rest)
	)
)

(instance cliffyBust of Prop
	(properties
		view 1003
	)
)

(instance cliffyEyes of Prop
	(properties
		nsTop 14
		nsLeft 58
		view 1003
		loop 2
	)
)

(instance cliffyMouth of Prop
	(properties
		nsTop 32
		nsLeft 52
		view 1003
		loop 1
	)
)

(instance tkrRoger of ChoiceTalker
	(properties
		x 0
		y 15
		view 1000
		talkWidth 150
		keepWindow 1
		textX 100
		textY 20
	)

	(method (init)
		(= font gUserFont)
		(if local79
			(self
				view: 261
				loop: 4
				cel: 0
				x: 115
				textX: 30
				textY: 10
				talkWidth: 250
				y: 40
			)
			(= gSystemWindow gSpeakWindow)
			(gSystemWindow tailX: 110 tailY: 40 isBottom: 1 xOffset: -10)
			(rogMouth view: 261 loop: 3 nsLeft: 7 nsTop: 28)
			(super init: 0 0 rogMouth &rest)
		else
			(self
				view: 1000
				loop: 0
				cel: 0
				x: 0
				textX: 120
				textY: 20
				talkWidth: 150
				y: 15
			)
			(rogMouth view: 1000 loop: 1 nsLeft: 44 nsTop: 35)
			(rogEyes setLoop: (Random 2 3))
			(= keepWindow (not normal))
			(super init: 0 rogEyes rogMouth &rest)
		)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance rogEyes of Prop
	(properties
		nsTop 21
		nsLeft 47
		view 1000
		loop 2
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 35
		nsLeft 44
		view 1000
		loop 1
	)

	(method (init)
		(if local79
			(self view: 261 loop: 3 nsLeft: 7 nsTop: 28)
		else
			(self view: 1000 loop: 1 nsLeft: 44 nsTop: 35)
		)
		(super init: &rest)
	)
)

(instance cryoButton of Feature
	(properties
		x 232
		y 104
		noun 9
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 44)
						(cond
							((IsFlag 45)
								(gMessager say: 11 4 12) ; "You don't want to close the chamber yet. Trust us."
							)
							((!= (chamber view:) 259)
								(gMessager say: 11 4 12) ; "You don't want to close the chamber yet. Trust us."
							)
							(else
								(gCurRoom setScript: closeBox)
							)
						)
					)
					(local81
						(gMessager say: 11 4 13) ; "Try opening the chamber without Bea in your hands. Your efforts will meet with greater success."
					)
					(else
						(gCurRoom setScript: openBox)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tank of Feature
	(properties
		x 232
		y 104
		onMeCheck 8
	)

	(method (init)
		(= noun
			(switch global126
				(2 25)
				(else 24)
			)
		)
		(if (gAddToPics contains: stain)
			(= noun 23)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 4 31 29)) ; Do, Spike, Antacid
				(super doVerb: theVerb &rest)
			)
			((IsFlag 57)
				(gMessager say: 23 0 0 0) ; "You'll have to wait till Cliffy fixes the tank before you can use it again."
			)
			(local81
				(gMessager say: 24 0 13 0) ; "You might want to put Bea down first. Besides, she probably wouldn't be very comfortable in the tank anyway."
			)
			(else
				(switch theVerb
					(4 ; Do
						(gCurRoom setScript: openTank)
					)
					(31 ; Spike
						(gCurRoom setScript: (ScriptID 243 9)) ; putSpikeInTank
					)
					(29 ; Antacid
						(cond
							((!= global126 2)
								(gMessager say: 24 29 0 0) ; "That won't have any effect on the empty specimen tank."
							)
							((IsFlag 56)
								(gMessager say: 25 29 33 0) ; "Spike's already been neutralized."
							)
							(else
								(gCurRoom setScript: (ScriptID 243 12)) ; useAntAcids
							)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
		)
	)
)

(instance thePad of Feature
	(properties
		x 124
		y 145
		noun 26
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					(local81
						(self doVerb: 4)
					)
					((not local74)
						(cond
							((InRect 66 120 159 131 gEgo)
								(gCurRoom setScript: getOnPad 0 0)
							)
							((< (gEgo x:) 113)
								(gCurRoom setScript: getOnPad 0 1)
							)
							(else
								(gCurRoom setScript: getOnPad 0 2)
							)
						)
					)
				)
			)
			(4 ; Do
				(if local81
					(gCurRoom setScript: (ScriptID 243 7)) ; putBeaOnPad
				else
					(super doVerb: theVerb)
				)
			)
			(24 ; Order
				(if local74
					(cond
						((== global130 6)
							(gMessager say: 26 24 38 0) ; "Cliffy has the remote unit for the transporter down on the surface. You'll have to wait until he beams up before you can transport."
						)
						(
							(or
								(and (gCast contains: bea) (!= global164 9))
								local81
								(and
									(IsFlag 63)
									(== global113 6)
									(!= global164 1)
								)
								(and
									(!= gPrevRoomNum 225)
									(== global113 8)
									(!= global164 8)
								)
							)
							(gMessager say: noun 24 13 0) ; "Not a good plan, ace. If you don't get Bea on ice quickly, she'll croak."
						)
						(else
							(gCurRoom setScript: beamRoger 0 0)
						)
					)
				else
					(gMessager say: noun 24 39 0) ; "You have to be on the pad to do that."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance northDoor of Prop
	(properties
		x 23
		y 95
		noun 20
		view 259
		priority 5
		signal 20496
	)

	(method (setCycle param1)
		(if param1
			(gSq5Music2 number: 103 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (init)
		(if (OneOf gPrevRoomNum 100 225)
			(= cel (self lastCel:))
		)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4) ; Walk, Do
			(cond
				(local81
					(gMessager say: noun 4 13 0) ; "And just what do you think you're going to do with her in the hall?"
				)
				((and (IsFlag 75) (< global164 8))
					(gMessager say: noun 4 25 0) ; "You better figure out a way to cure Bea. She's getting ''ripe'' rather quickly."
				)
				(
					(and
						(== global113 6)
						(!= global164 1)
						(or (IsFlag 45) (gCast contains: bea))
					)
					(gMessager say: noun 4 29 0) ; "You still have a few details to take care of--like saving the ambassador."
				)
				((and (== global113 4) (not (IsFlag 74)) (>= global127 3))
					(gMessager say: noun 4 30 0) ; "Your crew awaits you on the station. It would be wise of you to join them."
				)
				(
					(and
						(== global113 4)
						(or (not (IsFlag 54)) (IsFlag 49))
						(>= global127 3)
					)
					(gMessager say: noun 4 30 0) ; "Your crew awaits you on the station. It would be wise of you to join them."
				)
				(else
					(gCurRoom setScript: exitRoom)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

