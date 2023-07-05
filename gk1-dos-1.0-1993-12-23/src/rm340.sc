;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use Inset)
(use Talker)
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
	rm340 0
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5 = 7
	local6
	local7
	local8
)

(instance rm340 of Room
	(properties
		noun 1
		picture 340
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 340)
		(Load rsVIEW 3400)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 63 147 292 145 270 116 244 116 257 133 227 133 226 140 194 140 189 132 179 132 172 136 153 138 131 131 130 118 158 118 144 113 136 114 134 109 112 109
					yourself:
				)
		)
		(if (== gDay 5)
			(gGkMusic1
				number: 341
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		else
			(gGkMusic1
				number: 340
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(gEgo
			view: 900
			setCel: 0
			setLoop: 0
			signal: (| (gEgo signal:) $1000)
			init:
			setCycle: StopWalk -1
			state: 2
			ignoreActors: 1
			posn: 121 111
			hide:
		)
		(if (not (IsFlag 32))
			(hartrige init:)
		)
		(aquarium init:)
		(fileCabinet init:)
		(beardedHead init:)
		(forgMask init:)
		(sittingStatue init:)
		(globe init:)
		(hangingBall init:)
		(gabsChair init:)
		(desk init:)
		(stoneStatue init:)
		(trash init:)
		(bookCase init:)
		(if (and (>= gDay 5) (not (gEgo has: 45))) ; hartNotes
			(notes init:)
		)
		(= gNarrator hartrigeNarrator)
		(cond
			((== gPrevRoomNum 50) ; interrogation
				(gEgo view: 3400 setCel: 3 setLoop: 0 1 posn: 206 119 show:)
				(officeDoor init:)
				(= local0 1)
				(= local2 0)
			)
			((and (== gDay 5) (not (IsFlag 32)) (not (IsFlag 224)))
				(gCurRoom setScript: hartIsDead)
			)
			(else
				(gCurRoom setScript: enterEgo)
			)
		)
		(gWalkHandler add: self)
		(gWalkHandler add: officeDoor)
	)

	(method (dispose)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(gWalkHandler delete: self)
		(gWalkHandler delete: officeDoor)
		(if (!= gNewRoomNum 50) ; interrogation
			(SetFlag 226)
		)
		(= gNarrator GKNarrator)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gCurRoom setScript: standUp)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((gEgo inRect: 135 109 162 118)
				(gEgo setPri: 115)
				(= local4 1)
			)
			(local4
				(gEgo setPri: -1)
				(= local4 0)
			)
		)
	)
)

(instance hartrigeNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(40 45)
				(else global220)
			)
		)
		(switch global180
			(1
				(cond
					(local1
						(= temp0 3400)
						(= local8 (gEgo cycleSpeed:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: 2
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
							setCycle: Fwd
						)
					)
					(local0
						(= temp0 3400)
						(= local8 (gEgo cycleSpeed:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: 3
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
							setCycle: Fwd
						)
					)
					(
						(and
							(gCast contains: gEgo)
							(or
								(== (gEgo view:) 901)
								(== (gEgo view:) 900)
							)
							(== (gEgo loop:) 8)
						)
						(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
							(= temp0 (+ (gEgo view:) 1000))
						else
							(if (== (gEgo view:) 900)
								(= temp0
									(+ (gEgo view:) 1010 (gEgo cel:))
								)
							else
								(= temp0
									(+ (gEgo view:) 1039 (gEgo cel:))
								)
							)
							(switch (Random 0 2)
								(0 1)
								(1
									(+= temp0 10)
								)
								(2
									(= temp0 (+ (gEgo view:) 1000))
								)
							)
						)
						(= local8 (gEgo cycleSpeed:))
						(= temp1 (gEgo cel:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: temp1
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
							setCycle: Fwd
						)
					)
				)
			)
			(40
				(if (gCast contains: hartrige)
					(if (hartrige script:)
						(hartDoStuff dispose:)
					)
					(if local2
						(hartrige
							view: 340
							setCel: 0
							setLoop: 1
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					else
						(hartrige
							view: 341
							setCel: 0
							setLoop: 0
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					)
					(= local3 1)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local3
			(hartrige setCel: 0 setCycle: 0)
			(= local3 0)
			(if (and (not (gCurRoom script:)) (not (gEgo script:)))
				(hartrige setScript: hartDoStuff)
			)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setCel: (gEgo oldCel:)
				talking: 0
				cycleSpeed: local8
			)
			(if (or local0 local1)
				(gEgo setLoop: (gEgo oldLoop:) 1 setCycle: 0)
			else
				(gEgo setLoop: (gEgo oldLoop:) setCycle: StopWalk -1)
			)
		)
		(super dispose:)
	)
)

(instance lookInTheTrash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 122 126 self)
			)
			(2
				(Face gEgo trash self)
			)
			(3
				(gEgo view: 343 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(4
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(5
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(6
				(if (IsFlag 224)
					(gMessager say: 19 7 14 0 self) ; "There's nothing of interest in the waste basket."
				else
					(gMessager say: 19 7 15 0 self) ; "(AS GABE RIFFLES THROUGH GARBAGE CAN)Did you know there's a whole branch of archaeology devoted to garbage? Maybe you should look into it."
				)
				(gEgo normalize: 0 900)
			)
			(7
				(if (and (gCast contains: hartrige) (not (IsFlag 224)))
					(hartrige setScript: hartDoStuff)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 186 132 self)
			)
			(1
				(gEgo
					posn: 206 119
					view: 3400
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(if (and (== local6 8) (not (IsFlag 224)))
					(gMessager say: 9 8 22 0) ; "(SARCASTIC)That's right. Just make yourself at home."
				)
			)
			(2
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 3400 setCel: 3 setLoop: 0 setCycle: Beg self)
			)
			(1
				(gEgo normalize: 1 900 posn: 186 132)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openFileCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 106 129 self)
			)
			(2
				(gEgo view: 342 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(if (IsFlag 224)
					(gMessager say: 7 6 14 0 self) ; "The filing cabinet is locked."
				else
					(gMessager say: 7 6 15 0 self) ; "(TO GABE. DISDAINFUL)Please don't touch that."
				)
			)
			(4
				(gEgo view: 342 setCel: 4 setLoop: 0 setCycle: Beg self)
			)
			(5
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateHartrige of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hartDoStuff dispose:)
				(if local0
					(gGame handsOff:)
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(if (!= gPrevRoomNum 50) ; interrogation
					(gMessager say: 14 10 5 0 self) ; "Mind if I pick your brain?"
				else
					(gMessager say: 14 10 6 0 self) ; "Up for a few more questions?"
				)
			)
			(2
				(= global178 40)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance showHartSomething of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(hartDoStuff dispose:)
				(gGame handsOff:)
				(= local1 1)
				(gEgo view: 3400 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo view: 3400 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(cond
					((== local6 17)
						(if (IsFlag 225)
							(gMessager say: 14 17 18 0 self) ; "Can you tell me anything more about this photograph?"
						else
							(gMessager say: 14 17 17 0 self) ; "(SHOWS MURDER PHOTO TO HARTRIDGE)Is there anything you can tell me about the Voodoo aspects of this photograph?"
							(SetFlag 225)
							(SetFlag 49)
						)
					)
					((or (== local6 40) (== local6 59))
						(if (IsFlag 224)
							(gMessager say: 14 40 14 0 self) ; "Nothing means much to Dr. Hartridge anymore."
						else
							(gMessager say: 14 40 0 0 self) ; "Can you tell me anything about this?"
						)
					)
					(else
						(gMessager say: 14 0 0 0 self) ; "Can you tell me anything about this?"
					)
				)
			)
			(4
				(gEgo view: 3400 setCel: 9 setLoop: 1 setCycle: Beg self)
			)
			(5
				(hartrige setScript: hartDoStuff)
				(if (== local6 17)
					(gEgo getPoints: 149 2)
				)
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToHart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(hartDoStuff dispose:)
				(= cycles 1)
			)
			(2
				(if (and (IsFlag 226) (IsFlag 227))
					(gMessager say: 14 11 29 0 self) ; "(ANXIOUS, CURIOUS)Have you had any luck with that v\82v\82?"
				else
					(gMessager say: 14 11 local5 0 self)
				)
			)
			(3
				(if (== local5 11)
					(= local5 7)
				else
					(++ local5)
				)
				(hartrige setScript: hartDoStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3401
					setCel: 0
					setLoop: 0
					posn: 130 114
					show:
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 0 900)
				(officeDoor init:)
				(if (IsFlag 224)
					(Face gEgo hartrige self)
				else
					(cond
						((IsFlag 32)
							(gMessager say: 15 0 20 0 self) ; "Someone has taken away the body."
						)
						((IsFlag 226)
							(gMessager say: 15 0 4 0 self) ; "(VERY DRY)Mr. Knight. You're back. Oh, goody."
						)
						(else
							(gMessager say: 15 0 3 1 self) ; "(GABE ENTERS HART'S OFFICE FIRST TIME. SHARP)Are you a student?"
						)
					)
					(Face gEgo hartrige)
				)
			)
			(2
				(cond
					((IsFlag 224)
						(gGame handsOn:)
						(self dispose:)
					)
					((IsFlag 226)
						(gGame handsOn:)
						(= local2 0)
						(if (not (IsFlag 224))
							(hartrige setScript: hartDoStuff)
						)
						(self dispose:)
					)
					(else
						(gMessager sayRange: 15 0 3 2 3 self) ; "No. My name is Knight. Gabriel Knight."
					)
				)
			)
			(3
				(hartrige setScript: hartDoStuff)
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showTheVeve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(hartDoStuff dispose:)
				(= local1 1)
				(gEgo view: 3400 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo view: 3400 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(gMessager sayRange: 14 16 12 1 2 self) ; "(SHOWS GEDDE VEVE)Can you tell me anything about this pattern?"
			)
			(4
				(= gNarrator GKNarrator)
				(hartrige view: 346 setCel: 0 setLoop: 0 setCycle: End self)
				(gMessager sayRange: 14 16 12 3 4 self) ; "(EXCITED)VERY interesting! Mind if I copy this?"
			)
			(5)
			(6
				(hartrige
					view: 341
					setCel: 0
					setLoop: 3 1
					setPri: 107
					setCycle: End self
				)
				(gMessager say: 14 16 12 5) ; "(EXCITED)Great! I'll be right back!"
			)
			(7
				(hartrige setCel: 0 setLoop: 4 setCycle: End self)
			)
			(8
				(hartrige
					view: 345
					setCel: 0
					setLoop: 1 1
					posn: 184 125
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 122 112 self
				)
				(gEgo view: 3400 setCel: 9 setLoop: 1 setCycle: Beg)
			)
			(9
				(hartrige
					setCel: 0
					setLoop: 3 1
					setCycle: Walk
					setPri: -1
					setMotion: MoveTo 123 103 self
				)
			)
			(10
				(hartrige
					setCel: 0
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 148 100 self
				)
			)
			(11
				(= seconds 3)
			)
			(12
				(hartrige
					setCel: 0
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo 123 103 self
				)
			)
			(13
				(hartrige
					setCel: 0
					setLoop: 2 1
					setCycle: Walk
					setMotion: MoveTo 122 112 self
				)
			)
			(14
				(hartrige
					setLoop: 0 1
					setCel: 0
					setCycle: Walk
					setPri: 107
					setMotion: MoveTo 184 125 self
				)
				(= local7 gNarrator)
				(= gNarrator hartrigeNarrator)
			)
			(15
				(= local1 0)
				(hartrige setPri: -1 setCel: 0 setLoop: 0 posn: 184 101)
				(gMessager sayRange: 14 16 12 6 17 self) ; "(RUNS OUT AND MAKES COPY. RETURNS)Here you go. You know, this is a fascinating v\82v\82! You must tell me all about its origin!"
			)
			(16
				(hartrige setCel: 0 setLoop: 1 setCycle: End self)
			)
			(17
				(gEgo getPoints: -999 2)
				(SetFlag 227)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hartDoStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hartrige
					view: 340
					setCel: 0
					setLoop: 0
					setCycle: RandCycle 40 self 1
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance hartIsDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hartrige view: 344 loop: 2 cel: 0 posn: 199 101)
				(gEgo
					view: 3401
					loop: 0
					cel: 0
					posn: 130 114
					show:
					setCycle: End self
				)
			)
			(1
				(officeDoor init:)
				(gEgo normalize: 0 900)
				(= cycles 1)
			)
			(2
				(Face gEgo hartrige self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager sayRange: 15 0 19 1 2 self) ; "(RRCC. ENTERING OFFICE TO FIND DEAD BODY)Hey, Hartridge, what's the good word...?"
			)
			(5
				(gEgo setMotion: PolyPath 158 118 self)
			)
			(6
				(hartrige hide:)
				(gEgo
					view: 344
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 6 1 self
				)
			)
			(7
				(gEgo view: 344 setCel: 7 setLoop: 0 setCycle: End self)
				(hartrige view: 344 setLoop: 2 setCel: 1 show:)
				(gMessager sayRange: 15 0 19 3 4) ; "(RRCC. LITTLE SCREAM OF STARTLEMENT/SHOCK AS HE TIPS OVER DEAD BODY)<ah>!"
			)
			(8
				(gEgo view: 344 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9
				(= cycles 10)
			)
			(10
				(gEgo setCel: 10 setLoop: 1 setCycle: Beg self)
			)
			(11
				(gEgo normalize: 0 900 posn: 146 118)
				(SetFlag 224)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deadGuyCloseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(deadHart init: self rm340)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 1)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(if (IsFlag 224)
					(gEgo setMotion: PolyPath 130 114 self)
				else
					(gGame handsOff:)
					(gEgo setMotion: PolyPath 130 124 self)
				)
			)
			(2
				(if (IsFlag 224)
					(self dispose:)
					(gCurRoom newRoom: 330)
				else
					(Face gEgo hartrige self)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 15 0 1 (Random 1 3) self)
			)
			(5
				(gMessager say: 15 0 2 (Random 1 3) self)
			)
			(6
				(gEgo setMotion: PolyPath 120 110 self)
			)
			(7
				(self dispose:)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance takeHartNotes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 158 118 self)
			)
			(1
				(gEgo
					view: 342
					setCel: 0
					setLoop: 2
					setPri: 7
					setCycle: End self
				)
			)
			(2
				(gMessager say: 18 12 25 0) ; "(TO SELF. LOOKING AT DESK)These notes look interesting."
				(gEgo setCel: 0 setLoop: 3 setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(gEgo normalize: 0 900 get: 45 getPoints: -999 2) ; hartNotes
				(SetFlag 422)
				(self dispose:)
			)
		)
	)
)

(instance deadHart of Inset
	(properties
		view 3441
		x 94
		y 41
		disposeNotOnMe 1
		noun 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: 17 theVerb 0 0) ; "Something about Hartridge's death mask reminds Gabriel of the way Crash checked out. Not a pretty ending."
			)
			(4 ; magGlass
				(gMessager say: noun theVerb 14 0) ; "(GROSSED OUT)I can see him well enough, thanks!"
			)
			(6 ; Open
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "That would be up to the coroner."
				else
					(super doVerb: theVerb)
				)
			)
			(8 ; Operate
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "That would be up to the coroner."
				else
					(super doVerb: theVerb)
				)
			)
			(12 ; Pickup
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "(SPEAKING OF CORPSE)I'm not touching that body."
				else
					(super doVerb: theVerb)
				)
			)
			(13 ; Walk
				(super doVerb: theVerb)
			)
			(else
				(cond
					((OneOf theVerb 12 8) ; Pickup, Operate
						(super doVerb: theVerb)
					)
					((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
						(gMessager say: noun theVerb 14 0)
					)
					(else
						(gMessager say: noun 0 14 0) ; "Nothing means much to Dr. Hartridge anymore."
					)
				)
			)
		)
	)
)

(instance hartrige of Actor
	(properties
		noun 14
		x 184
		y 101
		view 340
		signal 4129
	)

	(method (init)
		(super init:)
		(if (and (IsFlag 224) (not (IsFlag 32)))
			(self view: 344 setCel: 1 setLoop: 2 x: 199 y: 101)
		)
	)

	(method (doVerb theVerb)
		(= local6 theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 224)
					(gCurRoom setScript: deadGuyCloseUp)
				else
					(super doVerb: theVerb)
				)
			)
			(9 ; Move
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "(SPEAKING OF CORPSE)I'm not touching that body."
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Open
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "That would be up to the coroner."
				else
					(super doVerb: theVerb)
				)
			)
			(10 ; Ask
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "Whatever Hartridge may have learned, he can't share it with Gabriel now--at least, not vocally."
				else
					(gEgo setScript: interrogateHartrige)
				)
			)
			(8 ; Operate
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "That would be up to the coroner."
				else
					(super doVerb: theVerb)
				)
			)
			(12 ; Pickup
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "(SPEAKING OF CORPSE)I'm not touching that body."
				else
					(super doVerb: theVerb)
				)
			)
			(17 ; murderPhoto
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "Nothing means much to Dr. Hartridge anymore."
				else
					(gEgo setScript: showHartSomething)
				)
			)
			(11 ; Talk
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "Whatever Hartridge may have learned, he can't share it with Gabriel now--at least, not vocally."
				else
					(gEgo setScript: talkToHart)
				)
			)
			(16 ; reconVeve_
				(cond
					((IsFlag 224)
						(gMessager say: noun theVerb 14 0) ; "Nothing means much to Dr. Hartridge anymore."
					)
					((IsFlag 227)
						(gMessager say: noun theVerb 13 0) ; "Hartridge made a copy of the v\82v\82. He doesn't need to see Gabriel's version again."
					)
					(else
						(gEgo setScript: showTheVeve)
					)
				)
			)
			(79 ; badge
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "Nothing means much to Dr. Hartridge anymore."
				else
					(gMessager say: noun theVerb 0 0) ; "(RRCC)Gabriel seems to be doing well enough with Hartridge without flashing that badge. At least, he hasn't gotten kicked out yet."
				)
			)
			(else
				(cond
					((IsFlag 224)
						(gMessager say: noun 0 14 0) ; "Nothing means much to Dr. Hartridge anymore."
					)
					((not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
						(gEgo setScript: showHartSomething)
					)
					((OneOf theVerb 7 9 6) ; Look, Move, Open
						(gMessager say: noun theVerb 0 0)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance aquarium of Prop
	(properties
		noun 8
		sightAngle 30
		x 181
		y 65
		view 349
	)

	(method (init)
		(super init:)
		(self setPri: 106 cycleSpeed: 20 setCycle: Fwd)
	)
)

(instance officeDoor of View
	(properties
		noun 2
		x 98
		y 48
		view 3401
		loop 1
		cel 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gCurRoom setScript: standUp)
					(return 1)
				else
					(gEgo setScript: leaveTheRoom)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fileCabinet of Feature
	(properties
		noun 7
		sightAngle 20
		x 86
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 74 98 54 97 54 89 97 86 98 113 88 120 77 122
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: openFileCabinet)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance beardedHead of Feature
	(properties
		noun 4
		sightAngle 20
		x 20
		y 112
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 26 20 29 44 41 43 76 33 116 0 117
					yourself:
				)
		)
		(super init:)
	)
)

(instance forgMask of Feature
	(properties
		noun 5
		sightAngle 20
		x 64
		y 143
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 145 21 112 54 105 111 127 130 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance sittingStatue of Feature
	(properties
		noun 3
		sightAngle 20
		x 279
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 310 131 283 144 244 142 236 95 291 22 318 22
					yourself:
				)
		)
		(super init:)
	)
)

(instance globe of Feature
	(properties
		noun 13
		nsLeft 54
		nsTop 55
		nsRight 75
		nsBottom 74
		sightAngle 20
		x 63
		y 65
	)
)

(instance hangingBall of Feature
	(properties
		noun 12
		sightAngle 20
		x 95
		y 32
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 95 20 106 52 94 57 82 52
					yourself:
				)
		)
		(super init:)
	)
)

(instance desk of Feature
	(properties
		noun 11
		nsLeft 147
		nsTop 98
		nsRight 232
		nsBottom 125
		sightAngle 20
		x 185
		y 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "The desk is locked."
				else
					(gMessager say: noun theVerb 15 0) ; "(TO GABE. DISDAINFUL)Please don't touch that."
				)
			)
			(8 ; Operate
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "The desk is locked."
				else
					(gMessager say: noun theVerb 15 0) ; "(TO GABE. DISDAINFUL)Please don't touch that."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stoneStatue of Feature
	(properties
		noun 6
		sightAngle 20
		x 235
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 22 245 22 244 84 230 102 220 57
					yourself:
				)
		)
		(super init:)
	)
)

(instance gabsChair of Feature
	(properties
		noun 9
		nsLeft 196
		nsTop 104
		nsRight 217
		nsBottom 132
		sightAngle 20
		x 210
		y 120
	)

	(method (doVerb theVerb)
		(= local6 theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((IsFlag 224)
						(gMessager say: noun theVerb 23 0) ; "Gabriel doesn't feel comfortable sitting around here under the circumstances."
					)
					(local0
						(gMessager say: noun theVerb 24 0) ; "Gabriel is already using the chair."
					)
					(else
						(gEgo setScript: sitDown)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trash of Feature
	(properties
		noun 19
		nsLeft 138
		nsTop 114
		nsRight 146
		nsBottom 127
		sightAngle 20
		x 142
		y 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: lookInTheTrash)
			)
			(7 ; Look
				(if (IsFlag 224)
					(gMessager say: noun theVerb 14 0) ; "There's nothing of interest in the waste basket."
				else
					(gMessager say: noun theVerb 15 0) ; "(AS GABE RIFFLES THROUGH GARBAGE CAN)Did you know there's a whole branch of archaeology devoted to garbage? Maybe you should look into it."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookCase of Feature
	(properties
		noun 10
		nsLeft 141
		nsTop 44
		nsRight 226
		nsBottom 99
		sightAngle 20
		x 200
		y 60
	)
)

(instance notes of Feature
	(properties
		noun 18
		sightAngle 20
		x 186
		y 200
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 98 201 105 176 104 171 98
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (IsFlag 422)
					(gMessager say: noun theVerb 26 0) ; "(TO PLAYER)Nothing else looks related to my case."
				else
					(gEgo setScript: takeHartNotes)
				)
			)
			(7 ; Look
				(if (IsFlag 422)
					(gMessager say: 11 7 0 0) ; "Dr. Hartridge's desk is remarkably neat. Especially considering the rest of the room."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

