;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use n666)
(use Print)
(use Inset)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
	Manuel_Auxveride 1
)

(local
	local0 = 1
)

(instance rm480 of SQRoom
	(properties
		noun 1
		picture 480
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 32 137 288 137 294 130 238 105 107 105
					yourself:
				)
		)
		(super init:)
		(if (!= gPrevRoomNum 340)
			(gGame handsOff:)
		)
		(Load 140 499 4901) ; WAVE
		(if (IsFlag 185)
			(Load rsVIEW 484)
		)
		(seat_1 init: approachVerbs: 4) ; Do
		(seat_2 init: approachVerbs: 4) ; Do
		(seat_3 init: approachVerbs: 4) ; Do
		(seat_4 init: approachVerbs: 4) ; Do
		(exitSign init: approachVerbs: 4) ; Do
		(tank init: approachVerbs: 4) ; Do
		(outsideWindow init: approachVerbs: 4) ; Do
		(styrofoam init: approachVerbs: 4) ; Do
		(wad init: approachVerbs: 4) ; Do
		(cup init: approachVerbs: 4) ; Do
		(cockpit init: approachVerbs: 4) ; Do
		(cockpitSeat1 init: approachVerbs: 4) ; Do
		(cockpitSeat2 init: approachVerbs: 4) ; Do
		(lights init: approachVerbs: 4) ; Do
		(wire init: approachVerbs: 4) ; Do
		(pipe init: approachVerbs: 4) ; Do
		(compartment1 init: approachVerbs: 4) ; Do
		(compartment2 init: approachVerbs: 4) ; Do
		(compartment3 init: approachVerbs: 4) ; Do
		(morePipes init: approachVerbs: 4) ; Do
		(controlScreen init:)
		(seeThroughSeat1 init:)
		(seeThroughSeat2 init:)
		(seeThroughSeat3 init:)
		(seeThroughSeat4 init:)
		(if (IsFlag 50)
			(powerOn init:)
		)
		(if (IsFlag 87)
			(photoHanging init:)
		)
		(if (IsFlag 96)
			(shuttleHood init:)
		)
		(if (and (!= gPrevRoomNum 340) (IsFlag 94))
			(manualOveride init: approachVerbs: 4 2) ; Do, Talk
		)
		(if (not (IsFlag 444))
			(recallNotice init: approachVerbs: 4) ; Do
		)
		(if (IsFlag 45)
			(gloveBox init: approachVerbs: 4) ; Do
		else
			(theGloveBox init: approachVerbs: 4) ; Do
		)
		(switch gPrevRoomNum
			(340
				(Load rsVIEW 484 482)
				(= global148 0)
				(shuttleDoor cel: 0 init: approachVerbs: 4) ; Do
				(manualOveride
					view: 484
					loop: 2
					x: 250
					y: 112
					priority: 110
					fixPriority: 1
				)
				(manualOveride
					cel: (manualOveride lastCel:)
					approachVerbs: 4 2 ; Do, Talk
					init:
				)
				(gEgo
					normalize:
					view: 484
					loop: 0
					x: 72
					y: 125
					init:
					hide:
					setScript: sTransportIn
				)
			)
			(450
				(= global148 450)
				(shuttleDoor init: approachVerbs: 4) ; Do
				(gEgo normalize: 0 posn: 62 111 init: setScript: sEnterRoom)
			)
			(500
				(= global148 500)
				(shuttleDoor init: approachVerbs: 4) ; Do
				(gEgo normalize: 0 posn: 62 111 init: setScript: sEnterRoom)
				(SetFlag 174)
				(SetFlag 187)
			)
			(470
				(= global148 470)
				(ClearFlag 52)
				(ClearFlag 53)
				(ClearFlag 108)
				0
				(ClearFlag 109)
				(SetFlag 46)
				(shuttleDoor cel: 0 init: approachVerbs: 4) ; Do
				(gEgo
					normalize: 0
					init:
					posn: 222 108
					put: 45 ; Eva_Helmet
					put: 46 ; Eva_Suit
					setScript: sEnterWithSuit
				)
			)
			(610
				(= global148 610)
				(ClearFlag 52)
				(ClearFlag 53)
				(ClearFlag 108)
				0
				(ClearFlag 109)
				(SetFlag 46)
				(SetFlag 158)
				(shuttleDoor cel: 0 init: approachVerbs: 4) ; Do
				(gEgo
					normalize: 0
					init:
					posn: 222 108
					put: 42 ; Eva_Full
					put: 44 ; Eva_Full_Enz
					put: 43 ; Eva_Full_Both
					put: 45 ; Eva_Helmet
					put: 46 ; Eva_Suit
					setScript: sEnterWithSuit
				)
			)
			(740
				(= global148 740)
				(ClearFlag 52)
				(ClearFlag 53)
				(ClearFlag 108)
				0
				(ClearFlag 109)
				(SetFlag 46)
				(shuttleDoor cel: 0 init: approachVerbs: 4) ; Do
				(gEgo
					normalize: 0
					init:
					posn: 222 108
					put: 45 ; Eva_Helmet
					put: 46 ; Eva_Suit
					setScript: sEnterWithSuit
				)
			)
			(else
				(shuttleDoor cel: 0 init: approachVerbs: 4) ; Do
				(gEgo
					view: 4801
					loop: 1
					cel: 0
					posn: 173 105
					setSpeed: 6
					setPri: 90
					init:
					setScript: sStandFromCockpit
				)
			)
		)
		(cockpitView init:)
		(closet init: approachVerbs: 4) ; Do
	)

	(method (notify)
		(gEgo setScript: sRogerGlueCrystal)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 4801
					loop: 0
					cel: 0
					posn: 171 105
					setSpeed: 6
					setPri: 90
					setCycle: End self
				)
			)
			(2
				(if (IsFlag 174)
					(gTheIconBar clearInvItem:)
					(gCurRoom newRoom: 495)
				else
					(gCurRoom newRoom: 490)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStandFromCockpit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 2)
				(= cycles 5)
			)
			(3
				(if (IsFlag 185)
					(ClearFlag 185)
					(gCurRoom setScript: sTransportToPoly)
					(gEgo setScript: sWalkToPad)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sTransportIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(localSound number: 923 play:)
				(gEgo
					cel: (gEgo lastCel:)
					show:
					setSpeed: 6
					put: 106 ; Trans_Signaler
					setCycle: Beg self
				)
			)
			(2
				(gEgo normalize: 6)
				(= cycles 5)
			)
			(3
				(manualOveride setCycle: Beg self)
			)
			(4
				(= ticks 30)
			)
			(5
				(localSound number: 4901 play:)
				(manualOveride loop: 1)
				(manualOveride cel: (manualOveride lastCel:))
				(manualOveride setCycle: Beg self)
			)
			(6
				(manualOveride hide:)
				(enginePanel
					cel: (enginePanel lastCel:)
					init:
					setCycle: Beg self
				)
			)
			(7
				(enginePanel dispose:)
				(= ticks 30)
			)
			(8
				(if (IsFlag 94)
					(localSound number: 499 play:)
					(manualOveride view: 481 loop: 0 x: 197 y: 87 setPri: 50)
					(manualOveride
						cel: (manualOveride lastCel:)
						show:
						setCycle: Beg self
					)
				else
					(manualOveride dispose:)
					(= cycles 1)
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkToPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setSpeed: 6 setMotion: MoveTo 72 125 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sDoTheSounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(localSound number: 356 play: self)
			)
			(2
				(localSound number: 354 play: self)
			)
			(3
				(localSound number: 356 play: self)
			)
			(4
				(localSound number: 355 play: self)
			)
			(5
				(localSound number: 356 play: self)
			)
			(6
				(localSound number: 354 play: self)
			)
			(7
				(localSound number: 356 play: self)
			)
			(8
				(localSound number: 355 play: self)
			)
			(9
				(= ticks 30)
			)
			(10
				(localSound number: 356 play: self)
			)
			(11
				(localSound number: 356 play: self)
			)
			(12
				(localSound number: 354 play: self)
			)
			(13
				(localSound number: 356 play: self)
			)
			(14
				(localSound number: 356 play: self)
			)
			(15
				(localSound number: 356 play: self)
			)
			(16
				(localSound number: 354 play: self)
			)
			(17
				(self dispose:)
			)
		)
	)
)

(instance sTransportToPoly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 356 354 355 489 923) ; WAVE
				(= cycles 1)
			)
			(1
				(enginePanel init: setCycle: End self)
			)
			(2
				(localSound number: 4901 play:)
				(manualOveride setCycle: End self)
			)
			(3
				(if (IsFlag 94)
					(manualOveride hide:)
				)
				(= ticks 60)
			)
			(4
				(enginePanel dispose:)
				(manualOveride
					view: 484
					loop: 1
					cel: 0
					x: 250
					y: 112
					priority: 110
					fixPriority: 1
				)
				(localSound number: 499 play:)
				(if (IsFlag 94)
					(manualOveride show: setCycle: End self)
				else
					(manualOveride init: setCycle: End self)
				)
			)
			(5
				(manualOveride loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(manualOveride loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(manualOveride view: 482 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(gEgo view: 482 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(9
				(localSound number: 489 play:)
				(gEgo setCycle: End self)
			)
			(10
				(gEgo normalize: 6 get: 106) ; Trans_Signaler
				(= cycles 10)
			)
			(11
				(gMessager say: 0 0 15 0 self) ; "Manuel tosses you a transport signaller."
			)
			(12
				(self setScript: sDoTheSounds)
				(manualOveride view: 484 loop: 3 cel: 0 setCycle: End self)
			)
			(13
				(manualOveride setCycle: Beg self)
			)
			(14
				(manualOveride loop: 2)
				(manualOveride cel: (manualOveride lastCel:) show:)
				(= cycles 5)
			)
			(15
				(localSound number: 923 play:)
				(= cycles 5)
			)
			(16
				(gEgo
					view: 484
					loop: 0
					cel: 0
					x: 72
					y: 125
					setSpeed: 9
					setCycle: End self
				)
			)
			(17
				(= ticks 120)
			)
			(18
				(gCurRoom newRoom: 340)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWithSuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= ticks 90)
			)
			(2
				(gMessager say: 0 0 6 0 self) ; "You neatly replace the EVA suit in its proper place."
			)
			(3
				(gEgo setScript: sOpenCloset 0)
				(self dispose:)
			)
		)
	)
)

(instance sOpenCloset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(Load 140 483) ; WAVE
				else
					(Load 140 484) ; WAVE
				)
				(= cycles 1)
			)
			(1
				(closet hide:)
				(if (IsFlag 53)
					(gEgo
						view: 4871
						posn: 236 108
						loop: (if (IsFlag 108) 0 else 1)
					)
					(gEgo
						cel:
							(if register
								0
							else
								(gEgo lastCel:)
							)
						setSpeed: 6
					)
					(if register
						(gEgo setCycle: CT 3 1 self)
					else
						(gEgo setCycle: CT 3 -1 self)
					)
				else
					(gEgo
						view: 4870
						posn: 236 108
						loop: (if (IsFlag 108) 0 else 1)
					)
					(gEgo
						cel:
							(if register
								0
							else
								(gEgo lastCel:)
							)
						setSpeed: 6
					)
					(if register
						(gEgo setCycle: CT 3 1 self)
					else
						(gEgo setCycle: CT 3 -1 self)
					)
				)
			)
			(2
				(if register
					(gEgo setCycle: End self)
					(sfx number: 483 play:)
				else
					(gEgo setCycle: Beg self)
					(sfx number: 484 play:)
				)
			)
			(3
				(if (IsFlag 46)
					(if (not (IsFlag 108))
						(evaHelmet dispose:)
					)
					(if (not (IsFlag 109))
						(evaSuit dispose:)
					)
					(closet view: 480 loop: 0 cel: 0 show:)
					(closet approachX: 236)
					(ClearFlag 46)
				else
					(closet
						view: 480
						loop: (if (IsFlag 108) 0 else 6)
						cel: 1
						show:
					)
					(closet approachX: 222)
					(SetFlag 46)
				)
				(gEgo posn: (if register 222 else 236) 108 normalize: 0)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSpecialClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 484) ; WAVE
				(gEgo setMotion: MoveTo 222 108 self)
			)
			(1
				(closet hide:)
				(client setSpeed: 6)
				(ClearFlag 46)
				(if (IsFlag 53)
					(client
						view: 4871
						posn: 236 108
						loop: (if (IsFlag 108) 0 else 1)
					)
					(client cel: (client lastCel:) setCycle: Beg self)
				else
					(client
						view: 4870
						posn: 236 108
						loop: (if (IsFlag 108) 0 else 1)
					)
					(client cel: (client lastCel:) setCycle: Beg self)
				)
				(= cycles (* (client cycleSpeed:) 7))
			)
			(2
				(sfx number: 484 play:)
			)
			(3
				(closet loop: 0 cel: 0 approachX: 222 show:)
				(gEgo posn: 236 108 normalize: 0)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerGetsSuckedOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shuttleDoor hide:)
				(gEgo
					view: (if (IsFlag 53) 486 else 485)
					loop: 0
					cel: 0
					posn: 98 109
					setSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(1
				(localSound number: 412 play: self)
				(gEgo setCycle: End)
				(= ticks 90)
			)
			(2
				(cup setCycle: End)
				(= ticks 90)
			)
			(3
				(styrofoam setCycle: End)
				(= ticks 90)
			)
			(4
				(wad setCycle: End self)
			)
			(5)
			(6
				(proc666_0 13 self)
			)
			(7
				(shuttleDoor show:)
				(cup cel: 0)
				(wad cel: 0)
				(styrofoam cel: 0)
				(gEgo normalize: 1)
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerGlueCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 487) ; WAVE
				(= cycles 1)
			)
			(1
				(gEgo
					view: 4880
					loop: 3
					cel: 0
					posn: 259 117
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(2
				(sfx number: 487 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 0)
				(= cycles 1)
			)
			(4
				(SetFlag 81)
				(gGame points: 1 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerFixCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 4880
					loop: 4
					cel: 0
					posn: 259 117
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(2
				(gMessager say: 38 0 0 0 self) ; "You hold the glue-coated segment to the broken Divalium crystal for ten seconds to set the glue."
			)
			(3
				(crystal loop: 2)
				(gEgo put: 24 put: 40 setCycle: End self) ; Crystal_With_Glue, Elmo_Gluzall
			)
			(4
				(gEgo normalize: 0)
				(= cycles 1)
			)
			(5
				(SetFlag 82)
				(gGame points: 5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetEvaSuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo get: 46) ; Eva_Suit
				(evaSuit dispose:)
				(gEgo
					view: 488
					loop: 0
					cel: 0
					x: 237
					y: 107
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: 0)
				(= cycles 1)
			)
			(3
				(SetFlag 109)
				(gGame points: 1 414)
				(if (IsFlag 108)
					(= next sSpecialClose)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGetEvaHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(evaHelmet dispose:)
				(closet view: 480 loop: 0 cel: 1)
				(gEgo
					view: 488
					loop: (if (IsFlag 53) 2 else 1)
					cel: 0
					x: 226
					y: 110
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(cond
					((and (IsFlag 104) (IsFlag 105))
						(gEgo get: 43) ; Eva_Full_Both
					)
					((IsFlag 105)
						(gEgo get: 42) ; Eva_Full
					)
					((IsFlag 104)
						(gEgo get: 44) ; Eva_Full_Enz
					)
					(else
						(gEgo get: 45) ; Eva_Helmet
					)
				)
				(gEgo normalize: loop: 6)
				(= cycles 1)
			)
			(3
				(gGame points: 1 415)
				(SetFlag 108)
				(if (IsFlag 109)
					(= next sSpecialClose)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGetRecallNotice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(recallNotice hide:)
				(gEgo
					view: 489
					loop: 1
					cel: 0
					x: 169
					y: 107
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gCurRoom setInset: inBigRecall)
				(= cycles 1)
			)
			(3
				(gEgo loop: 2 cel: 0 get: 91 setSpeed: 8 setCycle: End self) ; Recall_Notice
			)
			(4
				(gEgo normalize: loop: 7)
				(= cycles 1)
			)
			(5
				(gGame points: 1 444 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenCompartment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(if register
					(crystal init: approachVerbs: 4 112 setCycle: Fwd) ; Do, Elmo_Gluzall
				)
				(compartment2 hide:)
				(gEgo view: 4880 loop: 0)
				(gEgo
					cel:
						(if (== (compartment2 cel:) 1)
							(gEgo lastCel:)
						else
							0
						)
					posn: 255 118
					setSpeed: 6
				)
				(if register
					(Load 140 485) ; WAVE
					(Load 140 486) ; WAVE
					(gEgo setCycle: CT 4 1 self)
				else
					(Load 140 485) ; WAVE
					(Load 140 484) ; WAVE
					(gEgo setCycle: CT 8 -1 self)
				)
			)
			(2
				(if register
					(gEgo setCycle: CT 9 1 self)
					(sfx number: 485 play:)
				else
					(gEgo setCycle: CT 1 -1 self)
					(sfx number: 485 play:)
				)
			)
			(3
				(if register
					(gEgo setCycle: End self)
					(sfx number: 486 play:)
				else
					(gEgo setCycle: Beg self)
					(sfx number: 484 play:)
				)
			)
			(4
				(if register
					(compartment2 cel: 1 posn: 273 122 show:)
				else
					(compartment2 cel: 0 posn: 267 66 show:)
					(crystal dispose:)
				)
				(= cycles 1)
			)
			(5
				(gEgo normalize: loop: 0)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 111 111 self)
			)
			(2
				(localSound number: 481 play:)
				(shuttleDoor setCycle: Beg self)
			)
			(3
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
				(gEgo setHeading: 270 self)
			)
			(1
				(shuttleDoor dispose:)
				(gEgo
					view: 487
					loop:
						(cond
							((IsFlag 52) 1)
							((IsFlag 53) 2)
							(else 0)
						)
					cel: 0
					x: 98
					y: 109
					setSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(2
				(localSound number: 481 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: loop: 1 setMotion: MoveTo 62 111 self)
			)
			(4
				(cond
					((== global148 610)
						(= global170 4)
						(gCurRoom newRoom: global148)
					)
					((and (== global120 2) (IsFlag 1))
						(gCurRoom newRoom: 500)
					)
					(else
						(gCurRoom newRoom: global148)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance cup of Prop
	(properties
		noun 13
		sightAngle 40
		approachX 108
		approachY 105
		x 107
		y 105
		priority 100
		fixPriority 1
		view 4860
		loop 1
		signal 20513
	)
)

(instance styrofoam of Prop
	(properties
		noun 19
		sightAngle 40
		approachX 217
		approachY 105
		x 216
		y 104
		view 4860
		loop 2
		signal 20513
	)
)

(instance wad of Prop
	(properties
		noun 19
		sightAngle 40
		approachX 217
		approachY 105
		x 242
		y 104
		view 4860
		loop 3
		signal 20513
	)
)

(instance manualOveride of Prop
	(properties
		noun 42
		approachX 156
		approachY 105
		x 197
		y 87
		priority 50
		fixPriority 1
		view 481
		signal 20513
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 186)
					(self setScript: sTalkToManual)
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

(instance crystal of Prop
	(properties
		noun 34
		approachX 259
		approachY 117
		x 275
		y 65
		view 4880
		loop 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(112 ; Elmo_Gluzall
				(cond
					((or (IsFlag 53) (IsFlag 52))
						(gMessager say: 0 0 9) ; "It would be rather hard to do that while wearing the EVA suit."
					)
					((IsFlag 82)
						(gMessager say: noun theVerb 13) ; "You already fixed the crystal. I don't think it would work any better if you poured more glue on it."
					)
					((IsFlag 81)
						(gMessager say: noun theVerb 12) ; "There's no need to attempt gluing it again."
					)
					(else
						(gEgo setScript: sRogerGlueCrystal)
					)
				)
			)
			(151 ; Crystal_With_Glue
				(cond
					((or (IsFlag 53) (IsFlag 52))
						(gMessager say: 0 0 9) ; "It would be rather hard to do that while wearing the EVA suit."
					)
					((IsFlag 81)
						(gEgo setScript: sRogerFixCrystal)
					)
					(else
						(gMessager say: noun theVerb 4) ; "I guess the Divalium crystal won't work in this form. Fortunately, I have vast experience in the re-forming of broken items."
					)
				)
			)
			(1 ; Look
				(cond
					((IsFlag 82)
						(gMessager say: noun theVerb 13) ; "All appears well in the crystal compartment."
					)
					((IsFlag 81)
						(gMessager say: noun theVerb 14) ; "The compartment crystal has been glued already."
					)
					(else
						(gMessager say: noun theVerb 12) ; "Wow. The crystal seems to have broken. I swear it wasn't me!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(if (IsFlag 82)
			(= loop 2)
		else
			(= loop 1)
		)
		(super init:)
	)
)

(instance shuttleDoor of Prop
	(properties
		noun 8
		approachX 98
		approachY 109
		x 76
		y 41
		view 480
		loop 3
		cel 5
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 157)
					(gMessager say: noun theVerb 16) ; "This is the shuttle hatch."
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 158)
						(cond
							((and (OneOf global148 610 740) (IsFlag 53))
								(gEgo setScript: sExitRoom)
							)
							((IsFlag 52)
								(gMessager say: noun theVerb 8) ; "You don't have to wear your helmet out there."
							)
							((== local0 1)
								(gMessager say: noun theVerb 7 1) ; "It's pretty sticky out there, maybe you should wear your EVA Suit."
								(++ local0)
							)
							(else
								(gMessager say: noun theVerb 7 2) ; "That's not a request, Roger. If you want out, put on the damn suit."
							)
						)
					)
					((IsFlag 186)
						(gEgo setScript: sRogerGetsSuckedOut)
					)
					((and (IsFlag 187) (== global148 0))
						(gEgo setScript: sRogerGetsSuckedOut)
					)
					((and (IsFlag 139) (not (IsFlag 52)))
						(gEgo setScript: sRogerGetsSuckedOut)
					)
					(else
						(gEgo setScript: sExitRoom)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (initialize))
)

(instance closet of Prop
	(properties
		noun 21
		approachX 236
		approachY 108
		x 246
		y 81
		z 31
		priority 105
		fixPriority 1
		view 480
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 157))
						(gMessager say: 0 0 10) ; "You've got way too much to do to spend time messing with THAT now."
					)
					((IsFlag 186)
						(gMessager say: noun theVerb 16) ; "I don't need this suit right now."
					)
					((IsFlag 187)
						(if (== global148 0)
							(gMessager say: noun theVerb 16) ; "I don't need this suit right now."
						else
							(gMessager say: noun theVerb 11) ; "You don't need to do that while on Delta Burksilon."
						)
					)
					((and (IsFlag 108) (IsFlag 109))
						(super doVerb: theVerb)
					)
					(
						(and
							(IsFlag 139)
							(IsFlag 420)
							(not (IsFlag 51))
							(IsFlag 82)
						)
						(gMessager say: noun theVerb 16) ; "I don't need this suit right now."
					)
					((IsFlag 46)
						(gEgo setScript: sOpenCloset 0 0)
					)
					(else
						(if (not (IsFlag 108))
							(if (not (gEgo has: 45)) ; Eva_Helmet
								(not (IsFlag 53))
							)
							(evaHelmet init: approachVerbs: 4) ; Do
						)
						(if (not (IsFlag 109))
							(evaSuit init: approachVerbs: 4) ; Do
						)
						(gEgo setScript: sOpenCloset 0 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(if (IsFlag 46)
			(self loop: (if (IsFlag 108) 0 else 6) cel: 1)
			(= approachX 222)
			(if (not (IsFlag 108))
				(evaHelmet init: approachVerbs: 4) ; Do
			)
			(if (not (IsFlag 109))
				(evaSuit init: approachVerbs: 4) ; Do
			)
		)
		(super init:)
	)

	(method (initialize))
)

(instance enginePanel of Prop
	(properties
		noun 35
		approachX 241
		approachY 110
		x 264
		y 83
		priority 112
		fixPriority 1
		view 480
		loop 1
		signal 20513
	)
)

(instance gloveBox of Prop
	(properties
		noun 7
		sightAngle 40
		approachX 185
		approachY 101
		x 172
		y 79
		view 480
		loop 4
		signal 20513
	)
)

(instance cockpitView of Prop
	(properties
		sightAngle 40
		x 109
		y 38
		signal 20513
	)

	(method (init)
		(switch global148
			(450
				(self view: 4900 noun: 27)
			)
			(500
				(self view: 483 loop: 0 noun: 41)
			)
			(610
				(self view: 4902 noun: 29)
			)
			(740
				(self view: 4904 noun: 28)
			)
			(else
				(self view: 483 loop: 1 noun: 37)
			)
		)
		(super init:)
	)
)

(instance controlScreen of View
	(properties
		noun 14
		sightAngle 40
		x 164
		y 67
		view 4800
	)

	(method (init)
		(cond
			((IsFlag 75)
				(if (IsFlag 51)
					(= loop 2)
				else
					(= loop 1)
				)
			)
			((IsFlag 76)
				(= loop 8)
			)
			((IsFlag 77)
				(= loop 7)
			)
			((IsFlag 73)
				(cond
					((IsFlag 51)
						(= loop 10)
					)
					((IsFlag 97)
						(= loop 11)
					)
					(else
						(= loop 3)
					)
				)
			)
			((IsFlag 74)
				(if (IsFlag 51)
					(= loop 4)
				else
					(= loop 5)
				)
				(ptsOn init:)
			)
			((IsFlag 78)
				(= loop 6)
			)
			((IsFlag 79)
				(= loop 9)
			)
			(else
				(= loop 0)
			)
		)
		(super init:)
	)
)

(instance ptsOn of View
	(properties
		noun 14
		sightAngle 40
		x 159
		y 67
		view 4800
		loop 4
		cel 1
	)
)

(instance photoHanging of View
	(properties
		noun 14
		sightAngle 40
		x 172
		y 65
		view 4800
		loop 12
	)
)

(instance photoOnScreen of View ; UNUSED
	(properties
		noun 14
		sightAngle 40
		x 159
		y 67
		view 4800
		loop 13
	)
)

(instance powerOn of View
	(properties
		noun 14
		sightAngle 40
		x 180
		y 67
		view 4800
		loop 14
	)
)

(instance shuttleHood of View
	(properties
		noun 39
		sightAngle 40
		x 109
		y 39
		z 1
		view 4907
		signal 20513
	)
)

(instance evaSuit of View
	(properties
		noun 32
		sightAngle 40
		approachX 237
		approachY 106
		x 253
		y 106
		z 26
		view 480
		loop 6
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sGetEvaSuit)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (initialize))
)

(instance recallNotice of View
	(properties
		noun 36
		approachX 169
		approachY 107
		x 155
		y 84
		priority 103
		fixPriority 1
		view 480
		loop 5
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (IsFlag 53) (IsFlag 52))
					(gMessager say: 0 0 9) ; "It would be rather hard to do that while wearing the EVA suit."
				else
					(gEgo setScript: sGetRecallNotice)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance compartment2 of View
	(properties
		noun 23
		approachX 255
		approachY 118
		x 267
		y 66
		priority 10
		fixPriority 1
		view 480
		loop 2
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 157))
						(gMessager say: 0 0 10) ; "You've got way too much to do to spend time messing with THAT now."
					)
					((or (IsFlag 53) (IsFlag 52))
						(gMessager say: 0 0 9) ; "It would be rather hard to do that while wearing the EVA suit."
					)
					((IsFlag 48)
						(ClearFlag 48)
						(gEgo setScript: sOpenCompartment 0 0)
					)
					(else
						(SetFlag 48)
						(gEgo setScript: sOpenCompartment 0 1)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 48)
					(gMessager say: noun theVerb 5) ; "Yeah, it's right there where I left it."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(if (IsFlag 48)
			(self cel: 1 posn: 273 122)
			(crystal init: approachVerbs: 4 112 setCycle: Fwd) ; Do, Elmo_Gluzall
		)
		(super init:)
	)
)

(instance theGloveBox of Feature
	(properties
		noun 7
		nsLeft 165
		nsTop 74
		nsRight 179
		nsBottom 82
		sightAngle 40
		approachX 185
		approachY 101
		x 185
		y 100
	)
)

(instance seat_1 of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 64
		approachY 139
		x 64
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 7 139 7 132 12 128 18 128 19 126 16 125 16 111 20 108 47 108 51 111 51 123 47 126 46 128 56 128 59 131 59 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat_2 of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 128
		approachY 139
		x 128
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 139 151 139 151 131 148 128 138 128 137 126 140 125 143 122 143 110 140 108 112 108 108 112 108 125 111 126 111 128 105 128 99 132
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat_3 of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 211
		approachY 139
		x 211
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 188 139 241 139 240 132 235 128 228 128 227 126 231 124 231 111 226 108 199 108 196 110 196 123 199 126 204 126 204 128 191 128 188 131
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat_4 of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 266
		approachY 139
		x 266
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 138 311 138 311 108 304 108 277 108 274 110 274 123 279 128 269 128 266 131
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitSign of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 86
		approachY 109
		x 85
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 81 28 81 32 94 37 97 33 84 27
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tank of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 63
		approachY 122
		x 62
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 66 64 66 66 64 66 35 65 32 60 32 57 35 57 63
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance outsideWindow of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 21
		approachY 135
		x 20
		y 135
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 6 36 20 36 62 0 103 yourself:)
		)
		(super init: &rest)
	)
)

(instance cockpit of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 171
		approachY 105
		x 172
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 101 202 101 239 75 239 43 236 38 229 35 191 35 189 38 155 38 155 35 116 35 108 37 106 43 106 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cockpitSeat1 of Feature
	(properties
		noun 15
		sightAngle 160
		approachX 171
		approachY 105
		x 171
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 98 162 93 162 91 162 87 167 82 166 80 161 79 161 70 151 68 151 66 154 66 155 56 144 56 143 58 143 65 146 65 146 68 136 71 136 78 132 81 132 85 136 86 136 93 144 98
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (IsFlag 53) (IsFlag 52))
					(gMessager say: 0 0 9) ; "It would be rather hard to do that while wearing the EVA suit."
				else
					(gEgo setScript: sSitDown)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cockpitSeat2 of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 197
		approachY 105
		x 197
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 99 202 99 209 93 209 71 199 67 202 65 202 56 191 56 190 65 194 68 185 70 184 79 178 79 179 83 184 87 183 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lights of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 173
		approachY 111
		x 169
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 0 156 39 190 38 205 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wire of Feature
	(properties
		noun 17
		sightAngle 40
		approachX 208
		approachY 125
		x 211
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 5 209 10 210 20 209 27 210 32 214 25 213 19 213 9 207 2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pipe of Feature
	(properties
		noun 18
		sightAngle 40
		approachX 274
		approachY 135
		x 289
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 0 239 20 246 39 258 51 270 56 289 61 306 63 310 70 310 88 308 88 308 100 305 100 305 110 311 110 311 114 309 114 309 116 306 116 306 119 298 119 298 116 296 113 294 113 294 116 291 116 291 119 289 120 289 138 319 138 319 0 297 0 299 7 310 13 309 28 307 30 306 37 312 38 311 42 307 42 307 46 296 46 296 47 289 47 288 49 277 47 262 39 254 23 251 7 251 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance compartment1 of Feature
	(properties
		noun 22
		sightAngle 40
		approachX 258
		approachY 120
		x 273
		y 116
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 38 284 32 284 61 267 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance compartment3 of Feature
	(properties
		noun 24
		sightAngle 40
		approachX 258
		approachY 120
		x 273
		y 116
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 93 284 118 266 113 266 89
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance morePipes of Feature
	(properties
		noun 26
		sightAngle 40
		approachX 249
		approachY 113
		x 262
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 33 241 40 304 10 297 0 282 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seeThroughSeat1 of Feature
	(properties
		noun 1
		nsLeft 24
		nsTop 125
		nsRight 40
		nsBottom 128
		sightAngle 40
		y 141
	)
)

(instance seeThroughSeat2 of Feature
	(properties
		noun 1
		nsLeft 116
		nsTop 125
		nsRight 132
		nsBottom 128
		sightAngle 40
		y 141
	)
)

(instance seeThroughSeat3 of Feature
	(properties
		noun 1
		nsLeft 207
		nsTop 125
		nsRight 223
		nsBottom 128
		y 141
	)
)

(instance seeThroughSeat4 of Feature
	(properties
		noun 1
		nsLeft 284
		nsTop 125
		nsRight 288
		nsBottom 128
		sightAngle 40
		y 141
	)
)

(instance evaHelmet of Feature
	(properties
		noun 33
		approachX 226
		approachY 110
		x 235
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 69 233 69 229 65 229 62 232 59 237 59 241 62 241 66
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sGetEvaHelmet)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (initialize))
)

(instance inBigRecall of Inset
	(properties
		view 489
		x 96
		y 0
		disposeNotOnMe 1
		noun 40
	)

	(method (init)
		(gTheIconBar setupExit: 1)
		(gGame handsOn:)
		(super init: &rest)
	)

	(method (doit)
		(if (not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
			(cond
				(
					(and
						(gUser canInput:)
						(not (self onMe: (gUser curEvent:)))
						(!= gTheCursor gTheExitCursor)
					)
					(gGame setCursor: gTheExitCursor 1)
				)
				(
					(and
						(gUser canInput:)
						(self onMe: (gUser curEvent:))
						(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 40 theVerb) ; "It's the recall notice."
			)
			(4 ; Do
				(gMessager say: 0 theVerb 0 2 0 0) ; "It feels slightly gritty. You suppress an urge to dust it."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb 0 3 0 0) ; "Your utterances fall on uninterested aural organs."
			)
			(else
				(gMessager say: 0 26 0 2 0 0) ; "As cool as it would be to interface these two items, no good would come of it."
			)
		)
	)

	(method (dispose)
		(gTheIconBar setupExit: 0)
		(gGame handsOff:)
		(super dispose:)
	)
)

(instance Manuel_Auxveride of SmallTalker
	(properties
		name {Manuel Auxveride}
	)

	(method (init)
		(= client manualOveride)
		(if (== (client view:) 481)
			(self talkView: 481 talkLoop: 1)
		else
			(self talkView: 484 talkLoop: 5)
		)
		(super init:)
	)
)

(instance localSound of Sound
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance sTalkToManual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 10)
			)
			(1
				(DoAudio audPLAY 480 42 2 0 1)
				(gGame setCursor: gNormalCursor 1)
				(if
					((Print new:)
						addBitmap: 4954 0 0
						addButtonBM: 4954 1 0 1 { } 4 3
						addButtonBM: 4954 2 0 0 { } 31 15
						init:
					)
					(gGame setCursor: gWaitCursor 1)
					(= cycles 1)
				else
					(DoAudio audSTOP 480 42 2 0 1)
					(gGame handsOn:)
					(gGame setCursor: (gTheIconBar getCursor:))
					(self dispose:)
				)
			)
			(2
				(DoAudio audSTOP 480 42 2 0 1)
				(= cycles 1)
			)
			(3
				(gMessager say: 0 0 18 0 self) ; "Step over to the transport pad and I will beam you down to the surface of Polysorbate."
			)
			(4
				(gEgo setScript: sWalkToPad)
				(= next sTransportToPoly)
				(self dispose:)
			)
		)
	)
)

