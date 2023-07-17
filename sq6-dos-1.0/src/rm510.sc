;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use DText)
(use Str)
(use Array)
(use Inset)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm510 0
	Dr__Beleauxs 1
	Commander_Kielbasa 2
	Roger 3
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6)
	(Message msgGET 510 param1 param2 param3 param4 (local4 data:))
	(Text 0 (local5 data:) (local4 data:) 460 88)
	((= local3 (DText new:))
		font: 460
		text: (KString 8 (local4 data:)) ; StrDup
		fore: (if param6 210 else 113)
		back: 190
		x: (+ 40 (/ (- 110 (- (local5 at: 2) (local5 at: 0))) 2))
		y: (+ 17 param5)
		setSize: 88
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
)

(instance rm510 of SQRoom
	(properties
		noun 1
		picture 510
	)

	(method (init)
		(gEgo init: normalize: 0 posn: 19 65)
		(if (== gPrevRoomNum 420)
			(= style 0)
			(gEgo view: 4250 setLoop: 0 setCel: 0 posn: 131 86 setPri: 199)
			(leftSide init:)
			(teleportOperator init:)
		)
		(super init:)
		(if (or (gEgo has: 25) (== gPrevRoomNum 550)) ; Cyber_Jack
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 27 81 6 88 6 132 64 110 136 138 235 138 227 132 252 119 240 114 212 127 167 111 203 86 203 70 189 72 155 87 120 91 76 76 63 80 56 77 49 81 37 74 23 78
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 27 81 6 88 6 132 64 110 136 138 235 138 227 132 252 119 240 114 212 127 167 111 203 86 203 70 203 48 177 44 106 60 86 66 90 70 63 80 54 75 45 77 37 74 23 78
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 150 87 120 87 99 82 99 75 119 69 149 69 169 75 169 82 162 85
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 191 70 168 69 150 63 161 58 186 58 199 60 199 67
						yourself:
					)
			)
		)
		(Load 140 268) ; WAVE
		(Load rsHEAP 64941)
		(Load rsSCRIPT 64941)
		(if (== gAct 2)
			(Load rsSOUND 991 511 51020 51021)
			(Load rsFONT 460)
			(Load rsPALETTE 511)
		else
			(Load rsFONT 50)
			(Load rsMESSAGE 510)
		)
		(if (== gPrevRoomNum 550)
			(Load rsVIEW 517)
		)
		(switch gPrevRoomNum
			(420
				(self setScript: sDoTransport)
				(bellows init:)
				(kielbasa init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 56 100 72 86 143 91 138 109
							yourself:
						)
				)
			)
			(550
				(gEgo
					view: 519
					loop: 0
					cel: 10
					setCycle: 0
					setMotion: 0
					posn: 281 127
					setPri: 150
					get: 25 ; Cyber_Jack
				)
				(bellows init: approachVerbs: 2 4 26) ; Talk, Do, ???
				(keyboard
					init:
					approachVerbs: 1 4 2 26 ; Look, Do, Talk, ???
					cel: (keyboard lastCel:)
				)
				(if (and (IsFlag 163) (not (IsFlag 175)))
					(SetFlag 175)
					(= local2 1)
				)
				(if (and (IsFlag 164) (not (IsFlag 176)))
					(SetFlag 176)
					(= local2 1)
				)
				(if (and (IsFlag 165) (not (IsFlag 177)))
					(SetFlag 177)
					(= local2 1)
				)
				(if (and (IsFlag 166) (not (IsFlag 178)))
					(SetFlag 178)
					(= local2 1)
				)
				(if (and (IsFlag 167) (not (IsFlag 179)))
					(SetFlag 179)
					(= local2 1)
				)
				(cond
					(local2
						(printer init: approachVerbs: 4) ; Do
					)
					(
						(and
							(not (gEgo has: 86)) ; Incriminating_Printouts
							(or
								(and (IsFlag 175) (not (gEgo has: 81))) ; Belleaux_s_Record_Printout
								(and (IsFlag 176) (not (gEgo has: 82))) ; Nigel_s_Record_Printout
								(and (IsFlag 177) (not (gEgo has: 83))) ; Project_Immortality_Record_Printout
								(and (IsFlag 178) (not (gEgo has: 85))) ; Stellar_s_Record_Printout
								(and (IsFlag 179) (not (gEgo has: 84))) ; Sharpei_s_Record_Printout
							)
						)
						(printer init: cel: (printer lastCel:))
					)
				)
				(gCurRoom setScript: sEnterFromCyber)
			)
			(else
				(if (or (gEgo has: 25) (not (IsFlag 114))) ; Cyber_Jack
					(gGSound1 number: 510 loop: -1 play:)
					(bellows init: approachVerbs: 2 4 26) ; Talk, Do, ???
				else
					(gGSound1 number: 511 loop: -1 play:)
				)
				(if
					(and
						(not (gEgo has: 86)) ; Incriminating_Printouts
						(or
							(and (IsFlag 175) (not (gEgo has: 81))) ; Belleaux_s_Record_Printout
							(and (IsFlag 176) (not (gEgo has: 82))) ; Nigel_s_Record_Printout
							(and (IsFlag 177) (not (gEgo has: 83))) ; Project_Immortality_Record_Printout
							(and (IsFlag 178) (not (gEgo has: 85))) ; Stellar_s_Record_Printout
							(and (IsFlag 179) (not (gEgo has: 84))) ; Sharpei_s_Record_Printout
						)
					)
					(printer init: cel: (printer lastCel:))
				)
				(cond
					((and (== gAct 1) (IsFlag 106))
						(kielbasa init:)
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PBarredAccess
									init: 56 100 72 86 143 91 138 109
									yourself:
								)
						)
						(gCurRoom setScript: sUnwelcomeEntry 0 1)
					)
					((== gAct 1)
						(kielbasa init:)
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PBarredAccess
									init: 56 100 72 86 143 91 138 109
									yourself:
								)
						)
						(gCurRoom setScript: sUnwelcomeEntry)
						(SetFlag 106)
					)
					(else
						(keyboard init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
						(if (and (not (IsFlag 114)) (== gAct 2))
							(keyboard cel: (keyboard lastCel:))
						)
						(gCurRoom setScript: sEnterRoom)
					)
				)
			)
		)
		(door init:)
		(if (not (OneOf gPrevRoomNum 420 550))
			(door setCel: (door lastCel:))
		)
		(doorPanel init: approachVerbs: 4) ; Do
		(floorSensor init:)
		(holdingTank1 init:)
		(holdingTank2 init:)
		(burners init:)
		(blueMachine init:)
		(tubeHolder init:)
		(tableLight init:)
		(stuffHolder init:)
		(flask init:)
		(weirdDevice init:)
		(table1 init:)
		(table2 init:)
		(tallTank1 init:)
		(tallTank2 init:)
		(wallLight init:)
		(floorGrid init:)
		(wallPoster init:)
		(plasmaSphere init:)
		(cage1 init:)
		(cage2 init:)
		(cage3 init:)
		(cage4 init:)
		(labDoor init: approachVerbs: 4) ; Do
		(computer init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(tekStuff init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(labChair init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(lamp init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(monitor init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(wasteHole init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(books init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(books2 init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(container init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(papers1 init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(papers2 init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(paper3 init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
		(box init: approachVerbs: 1 4 2 26) ; Look, Do, Talk, ???
	)

	(method (dispose)
		(gGSound1 fade:)
		(gEgo setScale: 0)
		(super dispose:)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 38 85 self)
			)
			(1
				(sFX number: 268 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(2
				(if (and (== gAct 2) (not (IsFlag 115)))
					(gMessager say: 1 1 4 0 self) ; "Wow, a mad scientist working on a planet called "Delta Burksilon." You wonder what he's doing here. Designing women perhaps?"
					(SetFlag 115)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUnwelcomeEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(gEgo setMotion: MoveTo 38 85 self)
			)
			(1
				(sFX number: 268 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(2
				(if register
					(gMessager say: 0 0 8 0 self) ; "Wilco!? If you don't follow my orders immediately, I'll bust you down ... oh, I forgot. You're already as low as you can get. Trust me. I'll make your life more miserable than it already is! Now, move it!"
				else
					(gMessager say: 0 0 7 0 self) ; "Janitor! (VERY FIRMLY) I believe you were given specific orders. Carry them out immediately!"
				)
			)
			(3
				(Face gEgo door self)
			)
			(4
				(doorPanel doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromCyber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 8)
				(= cycles 3)
			)
			(1
				(if local2
					(sFX number: 577 loop: 1 play:)
					(printer setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if local2
					(sFX stop:)
				)
				(= ticks 60)
			)
			(3
				(sFX number: 518 loop: 1 play:)
				(gEgo setCycle: Beg self)
				(gGSound1 number: 511 loop: -1 play: 0 0 fade: 127 25 10 0)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo view: 518 loop: 2)
				(gEgo cel: (gEgo lastCel:) setSpeed: 8 setCycle: Beg self)
			)
			(6
				(self setScript: sGetUpFromComputer)
			)
		)
	)
)

(instance sGetPrintouts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 299 135 self)
			)
			(1
				(gEgo view: 511 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(printer dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(if (and (IsFlag 163) (not (gEgo has: 81))) ; Belleaux_s_Record_Printout
					(gEgo get: 81) ; Belleaux_s_Record_Printout
				)
				(if (and (IsFlag 164) (not (gEgo has: 82))) ; Nigel_s_Record_Printout
					(gEgo get: 82) ; Nigel_s_Record_Printout
				)
				(if (and (IsFlag 165) (not (gEgo has: 83))) ; Project_Immortality_Record_Printout
					(gEgo get: 83) ; Project_Immortality_Record_Printout
				)
				(if (and (IsFlag 166) (not (gEgo has: 85))) ; Stellar_s_Record_Printout
					(gEgo get: 85) ; Stellar_s_Record_Printout
				)
				(if (and (IsFlag 167) (not (gEgo has: 84))) ; Sharpei_s_Record_Printout
					(gEgo get: 84) ; Sharpei_s_Record_Printout
				)
				(if
					(and
						(gEgo has: 81) ; Belleaux_s_Record_Printout
						(gEgo has: 82) ; Nigel_s_Record_Printout
						(gEgo has: 83) ; Project_Immortality_Record_Printout
						(gEgo has: 85) ; Stellar_s_Record_Printout
						(gEgo has: 84) ; Sharpei_s_Record_Printout
					)
					(gEgo put: 81 put: 82 put: 83 put: 85 put: 84 get: 86) ; Belleaux_s_Record_Printout, Nigel_s_Record_Printout, Project_Immortality_Record_Printout, Stellar_s_Record_Printout, Sharpei_s_Record_Printout, Incriminating_Printouts
				)
				(gEgo normalize: 6 setMotion: MoveTo 252 119 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sFX number: 268 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 19 65 self)
			)
			(2
				(gCurRoom newRoom: 500)
				(self dispose:)
			)
		)
	)
)

(instance sDoingExperiments of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 60 120))
			)
			(1
				(bellows loop: 1)
				(bellows cel: (bellows lastCel:) setCycle: Beg self)
			)
			(2
				(bellows loop: 0 cel: 0 setCycle: Walk)
				(if (= register (RandomNumber 0 1))
					(= scratch 3)
					(bellows setMotion: MoveTo 125 60 self)
				else
					(= scratch 2)
					(bellows setMotion: MoveTo 105 62 self)
				)
			)
			(3
				(if (== scratch 3)
					(self changeState: (+ state 6))
				else
					(= cycles 1)
				)
			)
			(4
				(if (= register (RandomNumber 0 2))
					(bellows loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (== register 2)
					(bellows view: 517 loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(6
				(if register
					(= ticks 120)
				else
					(= cycles 1)
				)
			)
			(7
				(if register
					(bellows view: 5170 loop: 1)
					(bellows cel: (bellows lastCel:) setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(8
				(bellows loop: 0 cel: 0 setCycle: Walk)
				(if (= register (RandomNumber 0 1))
					(= scratch 4)
					(bellows setMotion: MoveTo 152 55 self)
				else
					(= scratch 3)
					(bellows setMotion: MoveTo 125 60 self)
				)
			)
			(9
				(if (== scratch 4)
					(self changeState: (+ state 5))
				else
					(= cycles 1)
				)
			)
			(10
				(if (= register (RandomNumber 0 1))
					(bellows loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(11
				(if register
					(= ticks 120)
				else
					(= cycles 1)
				)
			)
			(12
				(if register
					(bellows setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(13
				(bellows loop: 0 cel: 0 setCycle: Walk)
				(if (= register (RandomNumber 0 1))
					(= scratch 5)
					(bellows setMotion: MoveTo 167 53 self)
				else
					(= scratch 4)
					(bellows setMotion: MoveTo 152 55 self)
				)
			)
			(14
				(if (== scratch 5)
					(self changeState: (+ state 5))
				else
					(= cycles 1)
				)
			)
			(15
				(if (= register (RandomNumber 0 1))
					(bellows view: 517 loop: 0)
					(bellows cel: (bellows lastCel:) setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(16
				(if register
					(= ticks 120)
				else
					(= cycles 1)
				)
			)
			(17
				(if (= register (RandomNumber 0 1))
					(= scratch 5)
					(bellows
						view: 5170
						loop: 0
						cel: 0
						setCycle: Walk
						setMotion: MoveTo 167 53 self
					)
				else
					(= cycles (= scratch 1))
				)
			)
			(18
				(if (== scratch 1)
					(self changeState: (+ state 4))
				else
					(= cycles 1)
				)
			)
			(19
				(if (= register (RandomNumber 0 1))
					(bellows loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(20
				(if register
					(= ticks 120)
				else
					(= cycles 1)
				)
			)
			(21
				(self changeState: (+ state 2))
			)
			(22
				(bellows view: 5170 loop: 1 cel: 0 setCycle: End self)
			)
			(23
				(bellows loop: 2 cel: 0 setCycle: End self)
			)
			(24
				(bellows
					setLoop: 3 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 93 67 self
				)
			)
			(25
				(bellows loop: 2)
				(bellows cel: (bellows lastCel:) setCycle: Beg self)
			)
			(26
				(self changeState: 0)
			)
		)
	)
)

(instance sDoTransport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Load 140 340) ; WAVE
				(Load 140 327) ; WAVE
				(= ticks 80)
			)
			(2
				(gGSound2 number: 340 loop: 1 play:)
				(gEgo
					cycleSpeed: 9
					view: 4250
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(Load 140 342) ; WAVE
				(= ticks 60)
			)
			(4
				(gGSound2 number: 342 play:)
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(= ticks 60)
			)
			(6
				(teleportOperator setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(7
				(gGSound2 number: 356 play:)
				(teleportOperator setCycle: CT 5 1 self)
			)
			(8
				(gGSound2 number: 354 play:)
				(teleportOperator setCycle: CT 8 1 self)
			)
			(9
				(gGSound2 number: 356 play:)
				(teleportOperator setCycle: End self)
			)
			(10
				(gGSound2 number: 355 play:)
				(teleportOperator setCel: 0)
				(= ticks 60)
			)
			(11
				(Load 140 344) ; WAVE
				(ego2 init: hide:)
				(teleportOperator setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(gGSound2 number: 344 play:)
				(gEgo view: 4230 setLoop: 0 setCel: 0 setCycle: End self)
				(ego2 show: setCycle: End)
			)
			(13
				(gEgo setLoop: 1 setCel: 0 setCycle: Fwd)
				(ego2 setLoop: 1 setCycle: Fwd)
				(Load 140 346) ; WAVE
				(= ticks 240)
			)
			(14
				(gGSound2 number: 346 play:)
				(ego2 setLoop: 2 setCycle: End self)
			)
			(15
				(gEgo setLoop: 2 setCel: 0)
				(= cycles 3)
			)
			(16
				(ego2 dispose:)
				(gEgo hide:)
				(Load 140 348 423) ; WAVE
				(= ticks 120)
			)
			(17
				(teleportOperator view: 4202 setLoop: 2 setCel: 4)
				(= cycles 1)
			)
			(18
				(gGSound2 number: 348 play:)
				(teleportOperator setCel: 0 setCycle: End self)
			)
			(19
				(gGSound2 number: 350 play:)
				(gEgo
					show:
					setPri: 200
					posn: 219 83
					view: 508
					setLoop: 3
					setCel: 0
					setCycle: CT 6 1 self
				)
			)
			(20
				(gGSound2 number: 423 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(21
				(= ticks 90)
			)
			(22
				(gEgo
					setPri: -1
					setLoop: 4
					setCel: 0
					posn: 208 133
					setCycle: End self
				)
			)
			(23
				(gEgo normalize: 1)
				(teleportOperator
					setMotion:
						MoveTo
						(- (teleportOperator x:) 90)
						(teleportOperator y:)
				)
				(leftSide
					setMotion: MoveTo (- (leftSide x:) 185) (leftSide y:) self
				)
			)
			(24
				(teleportOperator dispose:)
				(leftSide dispose:)
				(gGSound1 number: 510 loop: -1 play:)
				(= ticks 120)
			)
			(25
				(gMessager say: 0 0 3 0 self) ; "Commander Kielbasa and that other guy look like they're just finishing up a conversation."
			)
			(26
				(gEgo setMotion: PolyPath 34 77 self)
			)
			(27
				(doorPanel doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sTailActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kielTail setCycle: ForwardCounter (RandomNumber 2 6) self)
			)
			(1
				(= seconds (RandomNumber 3 5))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sBellowsChinRub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bellows setCycle: ForwardCounter (RandomNumber 2 4) self)
			)
			(1
				(= seconds (RandomNumber 3 5))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sDrStormsOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 39 2 4 0 self) ; "Hello, Doctor."
			)
			(1
				(sFXType stop:)
				(bellows
					setScript: 0
					view: 516
					loop: 0
					cel: 0
					posn: 276 119
					setCycle: End self
				)
			)
			(2
				(sFX number: 266 loop: 1 play:)
				(keyboard setCycle: Beg)
				(bellows
					setLoop: 1 1
					posn: 270 127
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 204 125 self
				)
			)
			(3
				(gGame points: 3)
				(bellows setMotion: PolyPath 51 82 self)
			)
			(4
				(sFX number: 268 loop: 1 play:)
				(door setCycle: End self)
			)
			(5
				(bellows setMotion: MoveTo 9 67 self)
			)
			(6
				(sFX number: 268 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(7
				(bellows dispose:)
				(SetFlag 114)
				(gGSound1 number: 511 loop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtTechStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 5110
					loop: 0
					cel: 0
					setSpeed: 9
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: CT 6 -1 self)
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(sFX number: 519 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gGame handsOn:)
				(gCurRoom setInset: inTechStuff)
				(self dispose:)
			)
		)
	)
)

(instance sPutStuffBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setSpeed: 9 setCycle: CT 7 -1 self)
			)
			(2
				(sFX number: 519 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sConfrontDoctorBad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 205)
				(bellows setScript: 0)
				(gEgo
					view: 5111
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(if local8
					(gMessager say: 39 0 20 0 self) ; "Just leave, Mr. Wilco. I have to (SLIGHT PAUSE) prepare for the opening of Golden Lightyears. I wonder what your commander would think of your annoying presence here? Why, he'd haul your keel and ... anyway, I must finish what I've started. Don't let the door mash your glutes."
				else
					(= local8 1)
					(gMessager say: 39 0 18 0 self) ; "What is this?"
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 6)
				(ClearFlag 205)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sConfrontDoctor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 205)
				(bellows setScript: 0 setCycle: 0 setMotion: 0)
				(gEgo
					view: 5111
					loop: 2
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gMessager say: 39 0 5 0 self) ; "Well, Dr. Beleauxs, I think you've got some explaining to do."
			)
			(3
				(gGame points: 3)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 6)
				(ClearFlag 205)
				(= cycles 3)
			)
			(5
				(gMessager sayRange: 39 0 19 1 11 self) ; "Oh ... my ..."
			)
			(6
				(gGSound1 fade:)
				(gMessager say: 39 0 19 12 self) ; "She is? What do you mean, "not much time remains"?!"
				(= ticks 120)
			)
			(7
				(gGSound1 number: 51020 loop: -1 play:)
			)
			(8
				(gMessager sayRange: 39 0 19 13 27 self) ; "As you must realize by now, the Golden Lightyears project was merely a front for the research I'd been conducting per Sharpei's wishes."
			)
			(9
				(gGSound1 fade:)
				(gMessager say: 39 0 19 28 self) ; "Say what? No, I don't think ..."
				(= ticks 120)
			)
			(10
				(gGSound1 number: 51021 loop: -1 play:)
			)
			(11
				(gMessager sayRange: 39 0 19 29 34 self) ; "It's her only chance. If you seriously care for your friend, you'll do this."
			)
			(12
				(= ticks 120)
			)
			(13
				(gEgo put: 86) ; Incriminating_Printouts
				(= gAct 3)
				(gCurRoom newRoom: 530)
				(self dispose:)
			)
		)
	)
)

(instance sSitAtComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 281 127 self)
			)
			(1
				(gEgo
					view: 518
					loop: 0
					cel: 0
					setPri: 134
					setSpeed: 9
					setCycle: End self
				)
			)
			(2
				(sFX number: 266 loop: 1 play:)
				(keyboard setCycle: End self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gCurRoom setInset: inComputer)
				(self dispose:)
			)
		)
	)
)

(instance sGetUpFromComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 518 loop: 0)
				(gEgo
					cel: (gEgo lastCel:)
					setPri: 134
					setSpeed: 9
					setCycle: Beg self
				)
			)
			(1
				(sFX number: 266 loop: 1 play:)
				(keyboard setCycle: Beg)
				(gEgo
					normalize: 6
					setPri: -1
					setMotion:
						MoveTo
						(computer approachX:)
						(computer approachY:)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJackOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 3 504)
				(gEgo
					view: 518
					loop: 2
					cel: 0
					setSpeed: 9
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo view: 519 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(sFX number: 517 loop: 1 play:)
				(keyboard setScript: sFlashPalette)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(PalVary 1 0 0) ; PalVaryReverse
				(gEgo put: 25) ; Cyber_Jack
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(instance sFlashPalette of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalVary 0 511 0 (RandomNumber 60 100)) ; PalVaryStart
				(= ticks (RandomNumber 2 3))
			)
			(1
				(PalVary 1 0 (RandomNumber 0 40)) ; PalVaryReverse
				(= ticks (RandomNumber 4 6))
			)
			(2
				(if (<= local7 20)
					(++ local7)
					(self changeState: (- state 2))
				else
					(= ticks 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sTypeOnComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFXType play:)
				(bellows setCycle: ForwardCounter (RandomNumber 3 7) self)
			)
			(1
				(sFXType stop:)
				(= ticks (RandomNumber 60 120))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance leftSide of Actor
	(properties
		priority 198
		fixPriority 1
		view 509
		xStep 5
		moveSpeed 0
	)

	(method (init)
		(if (> gHowFast 4)
			(= xStep 15)
		)
		(super init:)
	)
)

(instance teleportOperator of Actor
	(properties
		y 85
		priority 200
		fixPriority 1
		view 4201
		loop 1
		signal 22529
		xStep 5
		moveSpeed 0
	)
)

(instance ego2 of Actor
	(properties
		x 219
		y 83
		priority 200
		fixPriority 1
		view 508
	)
)

(instance bellows of Actor
	(properties
		noun 39
		sightAngle 40
		x 74
		y 99
		view 514
		signal 20513
	)

	(method (init)
		(super init:)
		(cond
			((gEgo has: 25) ; Cyber_Jack
				(self view: 5170 loop: 1)
				(self
					cel: (self lastCel:)
					posn: 93 67
					approachX: 62
					approachY: 84
					case: 17
					cycleSpeed: 9
					moveSpeed: 9
				)
				(self setScript: sDoingExperiments)
			)
			((== gAct 1)
				(self setScript: sBellowsChinRub)
				(= cycleSpeed 10)
			)
			((and (not (IsFlag 114)) (== gAct 2))
				(self
					view: 515
					posn: 257 121
					setPri: 134
					approachX: 215
					approachY: 131
					setScript: sTypeOnComputer
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(161 ; Incriminating_Printouts
				(gCurRoom setScript: sConfrontDoctor)
			)
			(162 ; Belleaux_s_Record_Printout
				(gCurRoom setScript: sConfrontDoctorBad)
			)
			(163 ; Nigel_s_Record_Printout
				(gCurRoom setScript: sConfrontDoctorBad)
			)
			(164 ; Project_Immortality_Record_Printout
				(gCurRoom setScript: sConfrontDoctorBad)
			)
			(165 ; Sharpei_s_Record_Printout
				(gCurRoom setScript: sConfrontDoctorBad)
			)
			(166 ; Stellar_s_Record_Printout
				(gCurRoom setScript: sConfrontDoctorBad)
			)
			(4 ; Do
				(gMessager say: noun theVerb) ; "He's kind of gross-looking. Let's not."
			)
			(2 ; Talk
				(if (and (== gAct 2) (== view 515))
					(gCurRoom setScript: sDrStormsOff)
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

(instance keyboard of Prop
	(properties
		noun 27
		approachX 224
		approachY 122
		x 286
		y 97
		view 518
		loop 1
		signal 20513
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCast contains: bellows) (== (bellows view:) 515))
					(gMessager say: 39 2 9) ; "What do you think you're doing, you nincompoop?! I'd appreciate it if you would leave my computer alone while I'm working."
				else
					(gCurRoom setScript: sSitAtComputer)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance printer of Prop
	(properties
		noun 53
		approachX 252
		approachY 119
		x 308
		y 91
		priority 132
		fixPriority 1
		view 511
		signal 20513
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetPrintouts)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		noun 25
		sightAngle 40
		x 27
		y 73
		view 513
		signal 20513
	)
)

(instance kielHead of Prop
	(properties
		x 103
		y 56
		priority 100
		fixPriority 1
		view 512
		loop 1
		cel 14
		signal 20513
	)
)

(instance kielTail of Prop
	(properties
		x 126
		y 98
		priority 100
		fixPriority 1
		view 512
		loop 8
		signal 20513
	)
)

(instance kielbasa of View
	(properties
		x 101
		y 102
		view 512
		signal 20513
	)

	(method (init)
		(super init:)
		(kielHead init:)
		(kielTail init: setScript: sTailActions)
	)
)

(instance doorPanel of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 34
		approachY 77
		x 42
		y 40
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 39 33 46 35 46 48 39 45 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sExitRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floorSensor of Feature
	(properties
		noun 3
		sightAngle 40
		x 70
		y 67
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 72 70 68 71 68 62 72 61 yourself:)
		)
		(super init: &rest)
	)
)

(instance holdingTank1 of Feature
	(properties
		noun 4
		nsLeft 78
		nsTop 48
		nsRight 85
		nsBottom 62
		sightAngle 40
		x 81
		y 55
	)
)

(instance holdingTank2 of Feature
	(properties
		noun 5
		nsLeft 93
		nsTop 44
		nsRight 100
		nsBottom 58
		sightAngle 40
		x 96
		y 51
	)
)

(instance burners of Feature
	(properties
		noun 6
		sightAngle 40
		x 90
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 101 34 78 40 77 38 79 34 81 29 83 29 85 33 87 33 87 26 94 24 99 26
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blueMachine of Feature
	(properties
		noun 7
		sightAngle 40
		x 109
		y 19
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 30 105 17 107 17 107 5 111 5 111 16 113 18 113 31 107 33
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeHolder of Feature
	(properties
		noun 8
		sightAngle 40
		x 121
		y 31
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 38 121 34 114 32 114 27 119 25 129 28 129 36
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tableLight of Feature
	(properties
		noun 9
		sightAngle 40
		x 135
		y 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 26 127 26 127 15 128 13 128 0 140 0 140 13 142 15
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stuffHolder of Feature
	(properties
		noun 10
		sightAngle 40
		x 155
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 24 150 7 165 6 165 20
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flask of Feature
	(properties
		noun 11
		sightAngle 40
		x 172
		y 14
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 167 21 169 13 171 11 171 7 174 7 175 12 178 16 178 21
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance weirdDevice of Feature
	(properties
		noun 12
		sightAngle 40
		x 137
		y 43
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 56 122 56 122 50 128 50 132 30 140 30 144 43 155 43
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table1 of Feature
	(properties
		noun 13
		sightAngle 40
		x 131
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 56 165 81 151 85 116 85 104 79 104 53 116 48 133 47 149 47 161 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table2 of Feature
	(properties
		noun 14
		sightAngle 40
		x 172
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 43 159 39 165 38 186 36 192 68 172 67 166 65 166 55 159 48
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tallTank1 of Feature
	(properties
		noun 15
		sightAngle 40
		x 183
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 111 180 72 182 69 187 69 190 74 186 76 186 112
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tallTank2 of Feature
	(properties
		noun 16
		sightAngle 40
		x 190
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 115 187 113 187 77 193 74
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wallLight of Feature
	(properties
		noun 17
		sightAngle 40
		x 197
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 47 194 36 198 36 201 48 199 60 196 60
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance floorGrid of Feature
	(properties
		noun 18
		sightAngle 40
		x 96
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 61 90 77 85 131 104 121 107 106 101 98 103
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wallPoster of Feature
	(properties
		noun 19
		sightAngle 40
		x 13
		y 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 20 18 0 23 0 0 27 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance plasmaSphere of Feature
	(properties
		noun 20
		sightAngle 40
		x 21
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 58 11 58 11 98 24 103 37 113 42 125 41 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cage1 of Feature
	(properties
		noun 21
		sightAngle 40
		x 61
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 111 62 102 67 102 85 109 76 113 76 129 55 138 43 138 43 123
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cage2 of Feature
	(properties
		noun 22
		sightAngle 40
		x 107
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 110 106 102 133 112 133 132 118 138 109 138 84 128 77 127 77 114
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cage3 of Feature
	(properties
		noun 23
		sightAngle 40
		x 82
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 57 138 79 128 107 138 yourself:)
		)
		(super init: &rest)
	)
)

(instance cage4 of Feature
	(properties
		noun 24
		sightAngle 40
		x 143
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 121 138 143 128 174 138 yourself:)
		)
		(super init: &rest)
	)
)

(instance labDoor of Feature
	(properties
		noun 25
		sightAngle 40
		approachX 34
		approachY 77
		x 28
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 70 19 74 19 56 23 35 29 24 37 22
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance labChair of Feature
	(properties
		noun 26
		sightAngle 40
		approachX 229
		approachY 131
		x 256
		y 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 123 279 133 264 139 238 133 239 120 236 101 241 98 250 98 256 104 257 108 261 108 262 111 253 118 262 116 265 116 274 110 280 112 280 115 272 120 270 125 270 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCast contains: bellows) (== (bellows view:) 515))
					(gMessager say: 26 4 1) ; "By Levy's Shoemaker, you're rude! What do you think you're doing?"
				else
					(gCurRoom setScript: sSitAtComputer)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer of Feature
	(properties
		noun 27
		sightAngle 40
		approachX 224
		approachY 122
		x 293
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 100 279 88 279 81 287 77 302 76 311 78 320 82 319 90 311 93 303 94 298 108 280 106
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCast contains: bellows) (== (bellows view:) 515))
					(gMessager say: 39 2 9) ; "What do you think you're doing, you nincompoop?! I'd appreciate it if you would leave my computer alone while I'm working."
				else
					(gCurRoom setScript: sSitAtComputer)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 28
		sightAngle 40
		approachX 229
		approachY 131
		x 259
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 69 255 65 255 60 264 48 237 46 236 43 269 24 269 0 278 0 278 27 244 44 268 45 268 48 258 59 264 65
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance monitor of Feature
	(properties
		noun 29
		sightAngle 40
		approachX 229
		approachY 131
		x 287
		y 125
		z -59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 72 273 56 282 51 282 45 298 33 291 28 291 0 295 0 295 21 319 3 319 8 300 23 300 26 304 28 320 16 318 22 304 34 304 39 293 49 306 52 308 63 298 76
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 44 1) ; "It's a monitor. You've seen one before. In fact, you're seeing two right now."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wasteHole of Feature
	(properties
		noun 30
		sightAngle 40
		approachX 229
		approachY 131
		x 251
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 95 250 93 255 94 255 99 253 99 250 98 248 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tekStuff of Feature
	(properties
		noun 31
		sightAngle 40
		approachX 244
		approachY 122
		x 229
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 84 224 72 233 69 235 71 235 80
					yourself:
				)
		)
		(super init: &rest)
		(if (not (and (not (gEgo has: 16)) (not (gEgo has: 25)))) ; Callahan_Moddie, Cyber_Jack
			(= case 13)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (bellows view:) 515)
					(gCurRoom setScript: sLookAtTechStuff)
				else
					(gMessager say: 39 2 10) ; "Mr. Wilco, I would advise you to stay out of my personal belongings. I do not want to have to get physical with you. Mind you, I will if I have to. And don't think I can't take you!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance books of Feature
	(properties
		noun 32
		sightAngle 40
		approachX 229
		approachY 131
		x 234
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 53 245 50 246 61 223 67
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance books2 of Feature
	(properties
		noun 33
		sightAngle 40
		approachX 229
		approachY 131
		x 246
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 69 253 64 254 72 253 76 237 80
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance container of Feature
	(properties
		noun 34
		sightAngle 40
		approachX 229
		approachY 131
		x 264
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 272 75 255 75 255 62 272 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance papers1 of Feature
	(properties
		noun 35
		sightAngle 40
		approachX 229
		approachY 131
		x 264
		y 77
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 78 259 75 272 75 270 78 266 78 263 80
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCast contains: bellows) (== (bellows view:) 515))
					(gMessager say: noun theVerb 1) ; "By Arnold's Accent, what precisely do you think you're doing?"
				else
					(gMessager say: noun theVerb 2) ; "You quickly thumb through the report. It goes into nauseating detail about how certain parts of the Orbital Village were constructed using microtechnology. A race of microrobots, developed here in the Lab by Dr. Beleauxs, built critical sections of the Village that would've been hazardous to assemble by normal means."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance papers2 of Feature
	(properties
		noun 36
		sightAngle 40
		approachX 229
		approachY 131
		x 282
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 76 278 72 290 74 284 78
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCast contains: bellows) (== (bellows view:) 515))
					(gMessager say: noun theVerb 1) ; "What in the Pleiades do you think you're up to?"
				else
					(gMessager say: noun theVerb 2) ; "You surreptitiously page through the memo. It's a little too dense for you (there's a switch!), but it's apparently a discussion of how to graft attenuated neurons to computerized controllers, whatever that means."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance paper3 of Feature
	(properties
		noun 37
		sightAngle 40
		approachX 229
		approachY 131
		x 274
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 84 275 80 280 83 272 88
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCast contains: bellows) (== (bellows view:) 515))
					(gMessager say: noun theVerb 1) ; "By Losira's Chromosomes! What are you doing?"
				else
					(gMessager say: noun theVerb 2) ; "You pick up the memo and read through it. Sharpei was concerned that the Secondary Transplant Subject had "evaded recruitment" and that steps would need to be taken to either procure the subject forthwith or find a new STS."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance box of Feature
	(properties
		noun 38
		sightAngle 40
		approachX 229
		approachY 131
		x 257
		y 54
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 245 48 257 46 264 48 263 58 251 60 248 58 248 52 244 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance inComputer of Inset
	(properties
		view 840
		x 127
		y 0
		disposeNotOnMe 1
		modNum 510
		noun 27
	)

	(method (init)
		(gTheIconBar setupExit: 1)
		(super init: &rest)
		(= local4 (Str newWith: 80 {}))
		(= local5 (IntArray newWith: 4 {}))
		(= local6 0)
		(powerOff init:)
		(insetMonitor init:)
		(jack init:)
		(drive init:)
		(gGame handsOn:)
	)

	(method (doit &tmp temp0)
		(= temp0 (gUser curEvent:))
		(if (and (!= gTheCursor gWaitCursor) (not ((gTheIconBar plane:) onMe: temp0)))
			(cond
				((not (self onMe: temp0))
					(if (!= gTheCursor gTheExitCursor)
						(gGame setCursor: gTheExitCursor 1)
					)
				)
				((!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(gTheIconBar setupExit: 0)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(if script
			(script dispose:)
		)
		(if local3
			(local3 dispose:)
			(= local3 0)
		)
		(local4 dispose:)
		(local5 dispose:)
		(super dispose:)
		(if local6
			(gCurRoom setScript: sJackOut)
		else
			(gCurRoom setScript: sGetUpFromComputer)
		)
	)
)

(instance powerOn of View
	(properties
		noun 50
		modNum 510
		x 117
		y 112
		priority 200
		fixPriority 1
		view 840
		cel 1
	)

	(method (init)
		(super init:)
		(menus init:)
		(account init:)
		(research init:)
		(commun init:)
		(cyber init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sFX number: 920 loop: 1 play:)
				(inComputer dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance powerOff of Feature
	(properties
		noun 50
		modNum 510
		x 141
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 112 126 112 126 120 116 120
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sFX number: 920 loop: 1 play:)
				(powerOn init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance menus of Prop
	(properties
		modNum 510
		x 49
		y 8
		priority 200
		fixPriority 1
		view 840
		loop 1
		cycleSpeed 20
	)
)

(instance insetMonitor of Feature
	(properties
		noun 44
		modNum 510
		x 94
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 35 81 35 0 153 0 153 81 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (inComputer script:)
					((inComputer script:) dispose:)
					(if local3
						(local3 dispose:)
						(= local3 0)
					)
					(account init:)
					(research init:)
					(commun init:)
					(cyber init:)
					(menus cel: 0 show:)
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

(instance jack of Feature
	(properties
		noun 49
		modNum 510
		x 85
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 57 108 113 108 113 138 57 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; Cyber_Jack
				(if (== (inComputer script:) sInsertCyberjack)
					(sFX number: 498 loop: 1 play:)
					(sInsertCyberjack dispose:)
					(if local3
						(local3 dispose:)
						(= local3 0)
					)
					(= local6 1)
					(inComputer dispose:)
				else
					(gMessager say: 49 128) ; "That's an interesting idea. Not a good one ... but interesting nonetheless."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drive of Feature
	(properties
		noun 51
		modNum 510
		x 144
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 138 128 108 160 107 160 137
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance account of Feature
	(properties
		noun 45
		modNum 510
		x 94
		y 25
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 22 130 22 130 29 58 29
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sfxChoose play:)
				(inComputer setScript: sOffLine 0 self)
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 2) ; "It's a button to access bean-counter land."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance research of Feature
	(properties
		noun 52
		modNum 510
		x 94
		y 34
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 31 130 31 130 38 58 38
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sfxChoose play:)
				(inComputer setScript: sOffLine 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sOffLine of Script
	(properties)

	(method (handleEvent event)
		(gMouseDownHandler delete: self)
		(= ticks 0)
		(self changeState: (+ state 1))
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register account)
					(menus cel: 1)
				else
					(menus cel: 2)
				)
				(= ticks 60)
			)
			(1
				(menus hide:)
				(if (== register account)
					(localproc_0 45 0 0 1 10 1)
				else
					(localproc_0 52 0 0 1 10 1)
				)
				(gMouseDownHandler addToFront: self)
				(= ticks 1200)
			)
			(2
				(if (gMouseDownHandler contains: self)
					(gMouseDownHandler delete: self)
				)
				(if (== register account)
					(gMessager say: 45 4 0 0 self) ; "These aren't on-line yet. Apparently, budget isn't a big concern here."
				else
					(gMessager say: 52 4 0 0 self) ; "Ah, who wants to look at boring old research records. Try something else."
				)
			)
			(3
				(if local3
					(local3 dispose:)
				)
				(= local3 0)
				(menus cel: 0 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance commun of Feature
	(properties
		noun 47
		modNum 510
		x 94
		y 43
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 40 130 40 130 47 58 47
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sfxChoose play:)
				(inComputer setScript: sPlodigy)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPlodigy of Script
	(properties)

	(method (handleEvent event)
		(gMouseDownHandler delete: self)
		(= ticks 0)
		(self changeState: (+ state 1))
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(menus cel: 3)
				(= ticks 60)
			)
			(1
				(menus loop: 2 cel: 0)
				(= ticks 120)
			)
			(2
				(menus hide:)
				(= ticks 60)
			)
			(3
				(menus cel: 1 show: setCycle: End self)
				(gMouseDownHandler addToFront: self)
			)
			(4
				(if (gMouseDownHandler contains: self)
					(gMouseDownHandler delete: self)
				)
				(menus setCycle: 0)
				(gMessager say: 47 4 0 0 self) ; "After a click of the screen button, Plodigy begins to painfully slowly fill the screen."
			)
			(5
				(menus loop: 1 cel: 0 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cyber of Feature
	(properties
		noun 48
		modNum 510
		x 94
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 48 130 48 130 55 58 55
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (== (inComputer script:) sInsertCyberjack))
					(sfxChoose play:)
					(inComputer setScript: sInsertCyberjack)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sInsertCyberjack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(account dispose:)
				(research dispose:)
				(commun dispose:)
				(cyber dispose:)
				(menus cel: 4)
				(= ticks 60)
			)
			(1
				(menus hide:)
				(= cycles 1)
			)
			(2
				(localproc_0 48 0 14 1 20 0)
				(= ticks 50)
			)
			(3
				(if local3
					(local3 dispose:)
					(= local3 0)
				)
				(= ticks 30)
			)
			(4
				(self changeState: (- state 2))
			)
		)
	)
)

(instance inTechStuff of Inset
	(properties
		view 850
		x 174
		y 22
		disposeNotOnMe 1
		modNum 510
		noun 31
	)

	(method (init)
		(gTheIconBar disable: 4 setupExit: 1)
		(if (not (& ((gTheIconBar at: 7) signal:) $0004))
			(= local1 1)
			(gTheIconBar disable: 7)
		)
		(super init: &rest)
		(if (and (not (gEgo has: 16)) (not (gEgo has: 25))) ; Callahan_Moddie, Cyber_Jack
			(moddie init:)
		else
			(= case 13)
		)
		(leftChip init:)
		(circuitBoard init:)
		(redBox init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 0 4 0 2 0 0) ; "It feels slightly gritty. You suppress an urge to dust it."
			)
			(2 ; Talk
				(gMessager say: 0 2 0 4 0 0) ; "You get a jump on senility by mumbling to yourself."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gUser curEvent:))
		(if (and (!= gTheCursor gWaitCursor) (not ((gTheIconBar plane:) onMe: temp0)))
			(cond
				((not (self onMe: temp0))
					(if (!= gTheCursor gTheExitCursor)
						(gGame setCursor: gTheExitCursor 1)
					)
				)
				((!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(gTheIconBar setupExit: 0 enable: 4)
		(if local1
			(gTheIconBar enable: 7)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(super dispose:)
		(gCurRoom setScript: sPutStuffBack)
	)
)

(instance moddie of View
	(properties
		noun 40
		modNum 510
		x 39
		y 26
		priority 200
		fixPriority 1
		view 850
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(inTechStuff case: 13)
				(tekStuff case: 13)
				(gEgo get: 16) ; Callahan_Moddie
				(gGame points: 1 461)
				(gMessager say: 31 4) ; "You take possession of the Callahan moddie."
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftChip of Feature
	(properties
		noun 41
		modNum 510
		sightAngle 40
		x 20
		y 23
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 19 31 8 21 8 21 18 16 32 31 32 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance circuitBoard of Feature
	(properties
		noun 42
		modNum 510
		sightAngle 40
		x 30
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 21 15 31 12 40 25 31 29 yourself:)
		)
		(super init: &rest)
	)
)

(instance redBox of Feature
	(properties
		noun 43
		modNum 510
		sightAngle 40
		x 70
		y 23
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 28 61 16 76 16 85 31 86 31 58 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance Dr__Beleauxs of SmallTalker
	(properties
		name {Dr. Beleauxs}
		talkView 514
		talkLoop 4
	)

	(method (init)
		(= client bellows)
		(cond
			((== (client view:) 515)
				(= bodyView 515)
				(= bodyLoop 2)
				(= talkView 515)
				(= talkLoop 3)
				(= prepMove 1)
			)
			(
				(or
					(== (client script:) sDoingExperiments)
					(== (gCurRoom script:) sConfrontDoctor)
					(== (gCurRoom script:) sConfrontDoctorBad)
				)
				(if sDoingExperiments
					(= local9 sDoingExperiments)
					(= local10 (sDoingExperiments state:))
					(sDoingExperiments dispose:)
					(client setMotion: 0)
				)
				(cond
					(
						(and
							(== (client view:) 5170)
							(OneOf (client loop:) 2 3 4)
						)
						(= prepMove 0)
						(= talkView 5170)
						(= talkLoop 4)
					)
					((and (== (client view:) 5171) (== (client loop:) 1))
						(= prepMove 0)
						(= talkView 5171)
						(= talkLoop 1)
					)
					(else
						(= prepMove 1)
						(= bodyView 5171)
						(= bodyLoop 0)
						(= talkView 5171)
						(= talkLoop 1)
					)
				)
			)
		)
		(super init:)
	)

	(method (realDispose)
		(if (== (gCurRoom script:) sConfrontDoctor)
			(if (== talkView 5170)
				(client view: 5170 loop: 4 cel: 0)
			else
				(client view: 5171 loop: 1 cel: 0)
			)
		)
		(super realDispose:)
		(if
			(and
				scratch
				(== local9 sDoingExperiments)
				(!= (gCurRoom script:) sConfrontDoctor)
			)
			(sDoingExperiments start: local10)
			(client setScript: sDoingExperiments)
		)
	)
)

(instance Commander_Kielbasa of SmallTalker
	(properties
		name {Commander Kielbasa}
		bodyView 512
		bodyLoop 2
		talkView 512
		talkLoop 3
		prepMove 1
	)

	(method (init)
		(= client kielHead)
		(if local0
			(= bodyLoop 5)
			(= talkLoop 6)
		)
		(super init:)
	)
)

(instance Roger of SmallTalker
	(properties
		talkView 5111
		talkLoop 1
	)

	(method (init)
		(= client gEgo)
		(if (== (gCurRoom script:) sConfrontDoctorBad)
			(= talkLoop 1)
		else
			(= talkLoop 3)
		)
		(super init:)
	)
)

(instance sFX of Sound
	(properties
		number 268
	)
)

(instance sFXType of Sound
	(properties
		number 513
		loop -1
	)
)

(instance sfxChoose of Sound
	(properties
		flags 1
		number 915
	)
)

