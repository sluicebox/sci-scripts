;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 742)
(include sci.sh)
(use Main)
(use n913)
(use Scaler)
(use Polygon)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	vizierWedding 0
	stopWedding 1
	giveMint 2
	kingQueenEntry 3
	genieReappears 4
	genieScr 5
	glint 7
)

(local
	local0
)

(instance vizierWedding of Script
	(properties)

	(method (handleEvent event)
		(if
			(and
				(== (gTheIconBar at: 0) (gTheIconBar curIcon:))
				(& (event type:) $1040) ; evMOVE | direction
			)
			(if (< (event y:) (gEgo y:))
				((ScriptID 740 7) add: -1 3 3 23 1) ; roomConv, "Alexander approaches the wedding party."
				(client setScript: stopWedding)
			else
				(client setScript: triedToEscape)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1005 28) talkWidth: 87 textX: 60 textY: 23) ; Cassima
				((ScriptID 740 2) init:) ; vizier
				((ScriptID 80 5) ; guard1
					view: 7425
					loop: 0
					cel: 0
					x: 236
					y: 182
					scaleSignal: 1
					scaleX: 143
					scaleY: 143
					init:
					setCycle: 0
					setLoop: -1
					loop: 0
					cel: 0
					noun: 12
					stopUpd:
				)
				((ScriptID 80 6) ; guard2
					view: 7426
					loop: 0
					cel: 0
					x: 78
					y: 178
					scaleSignal: 1
					scaleX: 138
					scaleY: 138
					init:
					setCycle: 0
					setLoop: -1
					loop: 0
					cel: 0
					noun: 12
					stopUpd:
				)
				(if (not (IsFlag 10))
					((ScriptID 740 4) ; jollo
						view: 746
						loop: 0
						cel: 0
						x: 54
						y: 157
						stopUpd:
					)
				)
				((ScriptID 740 1) init: cel: 4 setCycle: Beg self) ; priest
			)
			(1
				(gMessager say: 1 0 3 1 self) ; "The Captain of the Guard leads Alexander into the throne room, where a ceremony seems to be in progress. Alexander feels his blood run cold at the sight."
			)
			(2
				((ScriptID 740 2) setCycle: End self) ; vizier
			)
			(3
				(SetFlag 59)
				(gMessager say: 1 0 3 2 self) ; "I, Cassima, declare Abdul Alhazred as my lawful and beloved husband, and KING of this realm...."
			)
			(4
				(ClearFlag 59)
				((ScriptID 740 2) cel: 2) ; vizier
				((ScriptID 740 1) setScript: preachPriest) ; priest
				(= cycles 10)
			)
			(5
				((ScriptID 740 2) stopUpd:) ; vizier
				(gMessager say: 1 0 3 3 self oneOnly: 0) ; "(SOFTLY WHISPERING TO HIMSELF) But...Cassima, what are you saying?"
			)
			(6
				(gGame handsOn:)
				(gWalkHandler addToFront: self)
				(gDirectionHandler addToFront: self)
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(= seconds 13)
			)
			(7
				(gGame handsOff:)
				(client setScript: (ScriptID 744 1)) ; saladinKillEgo
			)
		)
	)
)

(instance stopWedding of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 964)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 740 7) init: self) ; roomConv
			)
			(1
				((ScriptID 740 1) setScript: 0 setCycle: Beg) ; priest
				((ScriptID 740 2) setCycle: End self) ; vizier
			)
			(2
				(= cycles 10)
			)
			(3
				((ScriptID 740 2) setCycle: Beg) ; vizier
				(gEgo setSpeed: 8 setStep: 5 3 setMotion: MoveTo 158 146)
				((ScriptID 740 5) ; saladin
					view: 7361
					setSpeed: 8
					setStep: 5 3
					setMotion: MoveTo 192 148 self
				)
			)
			(4
				((ScriptID 740 5) setHeading: 0) ; saladin
				(= cycles 10)
			)
			(5
				(gEgo reset: 6)
				(client setScript: (ScriptID 745 0)) ; closeupWedding
			)
		)
	)
)

(instance genieScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local0) ((User alterEgo:) edgeHit:))
			(= local0 1)
			(gMessager say: 3 3 25 1) ; "Alexander attempts to escape through the grand hall doors...."
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 752 2) self (ScriptID 740 3)) ; geniePoofOut, genie
			)
			(1
				((ScriptID 740 3) ; genie
					loop: 8
					cel: 4
					x: 109
					y: 145
					scaleSignal: 1
					scaleX: 112
					scaleY: 112
				)
				(= seconds 3)
			)
			(2
				(self setScript: (ScriptID 752 1) self (ScriptID 740 3)) ; geniePoofIn, genie
			)
			(3
				(UnLoad 128 7501)
				(if (not local0)
					(gMessager say: 1 0 6 8 self) ; "Shamir, the vizier's genie, begins to throw balls of dazzling light at the guard dogs!"
				else
					(= ticks 1)
				)
			)
			(4
				(if (not local0)
					(= global106
						(switch global106
							((ScriptID 740 5) ; saladin
								((ScriptID 80 5) view: 7421 yourself:) ; guard1
							)
							((ScriptID 80 5) ; guard1
								((ScriptID 80 6) view: 7422 yourself:) ; guard2
							)
							(else
								(ScriptID 740 5) ; saladin
							)
						)
					)
					((= global156 killDog) register: global106)
				else
					(gMessager say: 3 3 25 2) ; "Trying to leave the castle, eh? I always knew you were a coward!"
					(= register 1)
					(= local0 0)
					(= global106 gEgo)
					(= global156 0)
				)
				(global106 setCycle: End self)
			)
			(5
				(if (!= global106 (ScriptID 740 5)) ; saladin
					(global106
						setLoop: 1
						cel: 0
						setCycle: Walk
						setMotion:
							MoveTo
							((ScriptID 740 3) x:) ; genie
							((ScriptID 740 3) y:) ; genie
					)
				)
				(= cycles 1)
			)
			(6
				(self setScript: (ScriptID 752 0) self (ScriptID 740 3)) ; throwDazzle, genie
			)
			(7
				(if (not local0)
					(if (not (OneOf global106 (ScriptID 80 6) gEgo)) ; guard2
						(-= state 4)
					)
					(if (not (HaveMouse))
						(= seconds 4)
					else
						(= seconds 2)
					)
				else
					(if (== global106 gEgo)
						(++ state)
					)
					(= ticks 5)
				)
			)
			(8
				(if register
					(EgoDead 18) ; "Genie, meenie, minie, moe...Alexander can't be slow!"
				else
					(gGame handsOff:)
					(gMessager say: 1 0 8 0 self) ; "The genie, finding a free moment in the battle, suddenly realizes that Alexander is still in the room and sends a dazzle spell his way."
				)
			)
			(9
				(= global106 gEgo)
				(= global156 0)
				(self setScript: (ScriptID 752 0) 0 (ScriptID 740 3)) ; throwDazzle, genie
			)
		)
	)
)

(instance killDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global106 setLoop: 2 cel: 0 setCycle: End self)
			)
			(1
				(global106 setPri: (+ (global106 priority:) 1) addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance genieReappears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UnLoad 128 748)
				(gGlobalSound4 number: 943 loop: 1 play:)
				((ScriptID 740 2) ; vizier
					view: 7414
					setLoop: 0
					cel: 0
					setPri: (+ ((ScriptID 740 8) priority:) 1) ; door
					setCycle: End self
				)
			)
			(1
				((ScriptID 740 2) ; vizier
					view: 7413
					loop: 0
					cel: 0
					setScale: 0
					x: 207
					y: 131
					cycleSpeed: (if (not gHowFast) 4 else 8)
					stopUpd:
				)
				((ScriptID 740 3) ; genie
					view: 7021
					loop: 8
					cel: 4
					x: 169
					y: 141
					scaleSignal: 1
					scaleX: 112
					scaleY: 112
					ignoreActors: 1
					setPri: 10
					init:
					noun: 5
					stopUpd:
				)
				(if (== client kingQueenEntry)
					(king loop: 3 cel: 0 setCycle: End king)
				)
				((ScriptID 740 1) ; priest
					view: 7412
					setLoop: 0
					cel: 0
					posn: 152 134
					setPri: 0
					setCycle: End self
				)
				(if (not (IsFlag 10))
					((ScriptID 740 4) ; jollo
						startUpd:
						view: 7465
						setLoop: 0
						cel: 0
						cycleSpeed: 6
						setPri: 13
						setCycle: End (ScriptID 740 4) ; jollo
					)
				)
				(UnLoad 128 741)
				(UnLoad 128 746)
				(UnLoad 128 7414)
			)
			(2
				(= cycles 10)
			)
			(3
				((ScriptID 740 1) addToPic:) ; priest
				(self dispose:)
			)
		)
	)
)

(instance giveMint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				((ScriptID 740 2) ; vizier
					view: 7415
					setLoop: 0
					cel: 0
					setPri: 9
					setCycle: End self
				)
			)
			(2
				(gMessager say: 4 67 0 0 self 160) ; "Perhaps the princess would care for some delicious peppermint leaves?"
			)
			(3
				(client setScript: (ScriptID 744 1)) ; saladinKillEgo
			)
		)
	)
)

(instance triedToEscape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 3 24 0 self) ; "Alexander attempts to escape through the grand hall doors...."
			)
			(1
				(client setScript: (ScriptID 744 1) 0 1) ; saladinKillEgo
			)
		)
	)
)

(instance preachPriest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not ((ScriptID 740 1) cel:)) ; priest
					((ScriptID 740 1) setLoop: (Random 0 1) setCycle: End self) ; priest
				else
					((ScriptID 740 1) setCycle: Beg self) ; priest
				)
			)
			(1
				(= state -1)
				(= cycles (Random 10 40))
			)
		)
	)
)

(instance king of Actor
	(properties
		x 120
		y 182
		noun 16
		view 7441
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk setScale: Scaler 100 75 189 134)
	)

	(method (cue)
		(self view: 7464 loop: 0 cel: 2 addToPic:)
	)
)

(instance glint of Prop
	(properties
		view 902
		priority 15
		signal 18448
	)
)

(instance kingQueenEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(king
					init:
					setSpeed: 5
					yStep: (if (not gHowFast) 4 else 2)
					setCycle: Walk
					ignoreActors:
					setScale: Scaler 101 90 189 141
				)
				((ScriptID 740 2) view: 7414 setLoop: 0 cel: 0) ; vizier
				(= cycles 2)
			)
			(1
				(gTheIconBar enable:)
				(Face gEgo king self)
			)
			(2
				(= seconds 3)
			)
			(3
				(gMessager say: 1 0 7 1 self) ; "King Caliphim and Queen Allaria burst into the throne room looking alive and well, and full of wrath! Behind them, a line of supporters look prepared to battle, if necessary, for their beloved royal couple!"
			)
			(4
				(king setMotion: MoveTo 122 142 self)
			)
			(5
				(gEgo setHeading: 315)
				(king
					view: 744
					loop: 2
					cel: 0
					x: 133
					y: 143
					setScale: 0
					setCycle: End self
				)
				(UnLoad 128 7441)
			)
			(6
				(king stopUpd:)
				(gMessager say: 1 0 7 2 self) ; "(SHOUTING) Cassima! Darling, are you all right? Has he hurt you?"
			)
			(7
				(gMessager say: 1 0 7 3 self) ; "Get your hands off of her, you murderous goat!"
			)
			(8
				((ScriptID 740 2) ; vizier
					view: 7415
					setLoop: 0
					cel: 0
					setPri: 9
					setCycle: CT 3 1 self
				)
			)
			(9
				((ScriptID 742 7) init: posn: 164 107 cel: 0 setCycle: End self) ; glint
			)
			(10
				((ScriptID 742 7) dispose:) ; glint
				(= cycles 2)
			)
			(11
				(SetFlag 59)
				(gMessager say: 1 0 7 4 self) ; "If I WANT your advice, I'll ASK for it...MOTHER!"
			)
			(12
				(ClearFlag 59)
				(gMessager say: 1 0 7 5 self) ; "(HORRIFIED) But...Caliphim...that's NOT Cassima! I'd know my daughter anywhere!"
			)
			(13
				(gMessager say: 1 0 7 6 self) ; "(OUTRAGED, TO VIZIER) What have you done with our daughter, you devil?"
			)
			(14
				(gGame givePoints: 5)
				((ScriptID 740 2) view: 7414 cel: 0) ; vizier
				(gMessager say: 1 0 7 7 self) ; "The lovely image of Cassima suddenly bursts into smoke and is replaced by...the vizier's genie!"
			)
			(15
				(self setScript: (ScriptID 742 4) self) ; genieReappears
			)
			(16
				(gMessager say: 1 0 7 8 self) ; "(OUTRAGED, TO VIZIER) Why, you...you conniving serpent!"
			)
			(17
				(gMessager say: 1 0 7 9 self) ; "Get him, guards! Saladin, your sword!"
			)
			(18
				(gMessager say: 1 0 7 10 self) ; "DRAT IT ALL! You may have ruined my plans, but you won't get me--OR your precious Cassima! GET THEM, SHAMIR! I COMMAND YOU!"
			)
			(19
				(LoadMany 0 1063 1029 1001)
				(UnLoad 128 899)
				(UnLoad 128 8992)
				(UnLoad 128 891)
				(UnLoad 128 890)
				(self setScript: (ScriptID 740 23) self) ; theGreatEscape
			)
			(20
				(gMessager say: 1 0 7 11 self) ; "He's getting away! Stop him!"
			)
			(21
				(gMessager say: 1 0 7 12 self) ; "Yes, Sire! As soon as I deal with this genie!"
			)
			(22
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 150 139 208 139 208 153 180 153 150 146
							yourself:
						)
				)
				(LoadMany 0 1004 1026)
				(UnLoad 128 892)
				(UnLoad 128 899)
				(UnLoad 128 8921)
				(UnLoad 128 8992)
				(UnLoad 128 891)
				(UnLoad 128 890)
				((ScriptID 740 3) setScript: (ScriptID 742 5)) ; genie, genieScr
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 744)
			)
		)
	)
)

