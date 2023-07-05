;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 186)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	SaracenRgn 0
	saracen 1
)

(synonyms
	(saracen guardian enemy guard man)
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1)
	(saracenWindow
		brTop: (- (saracen y:) 105)
		brBottom: 70
		brLeft: 50
		brRight: 250
	)
	(if (< (saracen y:) 100)
		(saracenWindow brTop: (+ (saracen y:) 105))
	)
	(if (< (gEgo x:) 160)
		(saracenWindow brLeft: 160 brRight: 310)
	)
	(if (and (== gCurRoomNum 77) (== gPrevRoomNum 78))
		(saracenWindow brLeft: 12 brRight: 160 brTop: 86 brBottom: 50)
	)
	(if (and (== gCurRoomNum 75) (== gPrevRoomNum 76))
		(saracenWindow brLeft: 120 brRight: 310 brTop: 220 brBottom: 70)
	)
	(gTObj
		tWindow: saracenWindow
		actor: saracenHead
		tLoop: 1
		cSpeed: 3
		talkCue: param1
	)
	(Talk &rest)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
	(= temp8 1)
	(if (> (gEgo distanceTo: theHelm) 6)
		(= temp9 (gEgo x:))
		(= temp10 (gEgo y:))
		(= temp4 (gEgo x:))
		(= temp5 (gEgo y:))
		(= temp0 (- param1 (gEgo x:)))
		(= temp1 (- param2 (gEgo y:)))
		(if (< (= temp7 (- (GetAngle 0 0 temp0 temp1) 90)) 0)
			(+= temp7 360)
		)
		(gEgo ignoreActors: 1)
		(for
			((= temp6 0))
			(and (!= temp6 (- (GetDistance 0 0 temp0 temp1) 3)) temp8)
			((++ temp6))
			
			(= temp2 (+ (CosMult temp7 temp6) temp4))
			(= temp3 (+ (SinMult temp7 temp6) temp5))
			(gEgo x: temp2 y: temp3)
			(if (not (gEgo canBeHere:))
				(= temp8 0)
			)
			(if
				(and
					(gEgo
						inRect:
							(- (saracen x:) 25)
							(- (saracen y:) 10)
							(+ (saracen x:) 25)
							(+ (saracen y:) 10)
					)
					(== param1 (theHelm x:))
				)
				(= temp8 0)
			)
		)
		(gEgo posn: temp9 temp10)
	)
	(gEgo ignoreActors: 0)
	(return (not temp8))
)

(instance saracenHead of Prop
	(properties
		view 377
		loop 1
	)

	(method (init)
		(super init:)
		(self posn: (- (saracen x:) 5) (saracen y:) 37)
	)
)

(instance saracen of Act
	(properties
		y 130
		x 125
		yStep 3
		view 382
		xStep 5
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if local1
			(cond
				(
					(or
						(<
							(= temp0 (GetAngle x y (gEgo x:) (gEgo y:)))
							23
						)
						(> temp0 337)
					)
					(= loop 1)
					(= cel 2)
				)
				((< 22 temp0 68)
					(= cel (= loop 1))
				)
				((< 67 temp0 113)
					(= cel (= loop 0))
				)
				((< 112 temp0 158)
					(= loop 0)
					(= cel 1)
				)
				((< 157 temp0 203)
					(= loop 0)
					(= cel 2)
				)
				((< 202 temp0 248)
					(= loop 0)
					(= cel 4)
				)
				((< 247 temp0 293)
					(= loop 1)
					(= cel 5)
				)
				((< 292 temp0 338)
					(= loop 1)
					(= cel 3)
				)
			)
		)
	)

	(method (init)
		(Load rsSOUND 116)
		(Load rsSOUND 112)
		(Load rsVIEW 88)
		(super init:)
		(= global109 6)
		(switch gCurRoomNum
			(75
				(if (== gPrevRoomNum 76)
					(self posn: 112 132)
				else
					(self posn: 175 71)
				)
			)
			(76
				(if (== gPrevRoomNum 75)
					(self posn: 110 111)
				else
					(self posn: 180 131)
				)
			)
			(77
				(if (== gPrevRoomNum 78)
					(self posn: 194 104)
				else
					(self posn: 124 125)
				)
			)
			(78
				(self posn: 103 82)
			)
		)
		(= local1 1)
		(self setScript: saracenChallenge)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (Said 'talk/saracen')
			(localproc_0 0 186 0) ; "I am not here to answer questions, infidel. To win the Grail, you must do battle with me. Draw your sword!"
		)
	)
)

(instance saracenWindow of SysWindow
	(properties
		color 15
		back 8
		title {Saracen}
		brTop 10
		brLeft 50
		brBottom 85
		brRight 250
	)
)

(instance helmFlash of Prop
	(properties
		view 88
		signal 16384
	)
)

(instance theHelm of Prop
	(properties
		view 88
		loop 2
	)

	(method (init)
		(self
			posn:
				(/ (+ (gEgo x:) (saracen x:)) 2)
				(/ (+ (gEgo y:) (saracen y:)) 2)
		)
		(if (< (- (saracen y:) 30) y (+ (saracen y:) 30))
			(= y (+ (saracen y:) 30))
		)
		(super init:)
		(self setScript: helmMagic)
	)
)

(instance SaracenRgn of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 382)
		(Load rsVIEW 376)
		(Load rsVIEW 377)
		(Load rsVIEW 378)
		(Load rsVIEW 381)
		(Load rsVIEW 88)
		(Load rsVIEW 76)
		(Load rsVIEW 656)
		(super init:)
		(switch gCurRoomNum
			(75
				(SetFlag 213)
			)
			(77
				(SetFlag 214)
			)
			(78
				(SetFlag 215)
			)
		)
		(if (and (not (IsFlag 207)) (IsFlag 213) (IsFlag 214) (IsFlag 215))
			(saracen init:)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(not (IsFlag 213))
					(not (IsFlag 214))
					(not (IsFlag 215))
					(IsFlag 207)
				)
				(event claimed: 0)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(if (or (Said '/crest') (Said '//crest'))
					(Print 186 1) ; "This Saracen is clearly an honorable foe, to offer you this helmet. Accept it or not, according to your own common sense."
				)
			)
			(
				(or
					(Said 'get,(pick<up)/crest')
					(Said 'wear/crest')
					(Said 'drop<on/crest')
				)
				(gEgo setScript: getHelm)
			)
			(
				(or
					(Said 'accept,get/challenge')
					(Said 'attack,kill,annihilate/saracen')
				)
				(if
					(localproc_1
						(+
							(saracen x:)
							(if (< (gEgo x:) (saracen x:)) -60 else 60)
						)
						(saracen y:)
					)
					(Print 186 2) ; "You cannot fight the saracen from here."
				else
					(gEgo setScript: iAmADork)
				)
			)
		)
	)
)

(instance saracenChallenge of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 3)
				(gEgo
					inRect:
						(- (saracen x:) 65)
						(- (saracen y:) 20)
						(+ (saracen x:) 65)
						(+ (saracen y:) 20)
				)
				(not (gEgo script:))
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRegMusic number: 116 loop: -1 play:)
				(= cycles 1)
			)
			(1
				(SetFlag 217)
				(if (not (IsFlag 216))
					(localproc_0 self 186 3) ; "Infidel, you must defeat me if you would win the Grail. Here, in this Temple of Aphrodite, we must match sword and shield, strength and skill, until one of us is dead."
				else
					(self cue:)
				)
			)
			(2
				(if (not (IsFlag 216))
					(localproc_0 self 186 4) ; "But I wish for an equal fight and you do not have a helmet. Therefore, I offer you one that is a strong as my own. Wear it or not, as you please."
				else
					(localproc_0 self 186 5) ; "Face me, coward! We must fight until one of us lies dead upon these sacred stones."
				)
				(theHelm init:)
			)
			(3
				(SetFlag 216)
				(HandsOn)
			)
			(4
				(HandsOff)
				(= local1 0)
				(if (< (gEgo x:) (saracen x:))
					(= global196 (+ (gEgo x:) 60))
				else
					(= global196 (- (gEgo x:) 40))
				)
				(saracen
					view: 376
					ignoreActors: 1
					setLoop: (if (< global196 (saracen x:)) 1 else 0)
					setCycle: Fwd
					setMotion: MoveTo global196 (gEgo y:) self
				)
			)
			(5
				(saracen
					view: (if (< (gEgo x:) (saracen x:)) 381 else 378)
					setLoop: 0
				)
				(= cycles 1)
			)
			(6
				(saracen
					setLoop: (if (or global124 (== (gEgo view:) 4)) 2 else 3)
					cel: -1
					setCycle: End self
				)
			)
			(7
				(saracen setCycle: Beg)
				(gEgo
					view: 76
					setLoop:
						(+
							(if (< (gEgo x:) (saracen x:)) 1 else 0)
							(if (or global124 (== (gEgo view:) 4)) 0 else 2)
						)
					cel: -1
					setCycle: End self
				)
				(gRegMusic stop:)
				(gRmMusic number: 112 loop: 1 play: self)
			)
			(8
				(if (< (gEgo loop:) 2)
					(Print ; "With your brain sliced in twain, I am sure you are having second thoughts about not taking the helmet offered to you by the Saracen."
						186
						6
						#at
						64
						(if (> (saracen y:) 120)
							(- (saracen y:) 117)
						else
							(+ (saracen y:) 16)
						)
					)
				else
					(Print ; "Interesting tactic, letting your opponent kill you without the least resistance. Not terribly effective for you, however."
						186
						7
						#at
						64
						(if (> (saracen y:) 120)
							(- (saracen y:) 117)
						else
							(+ (saracen y:) 16)
						)
					)
				)
				(EgoDead)
			)
		)
	)
)

(instance getHelm of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local0 (< (- (gEgo y:) 6) (saracen y:) (+ (gEgo y:) 6)))
			(= local0 0)
			(gEgo view: 656 cel: -1 setCycle: End self)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (localproc_1 (theHelm x:) (theHelm y:))
					(Print 186 8) ; "You cannot reach the helmet from here."
					(self dispose:)
				else
					(saracen setScript: 0)
					(HandsOff)
					(gEgo illegalBits: 0 ignoreActors: 1)
					(self cue:)
				)
			)
			(1
				(gEgo ignoreActors: 1)
				(if (< (gEgo x:) (theHelm x:))
					(gEgo
						setMotion: MoveTo (- (theHelm x:) 21) (theHelm y:) self
					)
				else
					(gEgo
						setMotion: MoveTo (+ (theHelm x:) 18) (theHelm y:) self
					)
				)
			)
			(2
				(gEgo setLoop: (if (< (gEgo x:) (theHelm x:)) 0 else 1))
				(= cycles 2)
			)
			(3
				(gEgo view: 88 cel: -1 setCycle: CT 2 1 self)
			)
			(4
				(theHelm dispose:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo view: 656 cel: 0)
				(gEgo setLoop: (if (< (gEgo x:) (saracen x:)) 0 else 1))
				(= cycles 2)
			)
			(6
				(= local1 0)
				(= global196
					(+
						(gEgo x:)
						(if (< (gEgo x:) (saracen x:)) 60 else -60)
					)
				)
				(= global197 (gEgo y:))
				(cond
					((< global196 (saracen x:))
						(if (!= (saracen cel:) 5)
							(saracen setCycle: End self)
						else
							(self cue:)
						)
					)
					((saracen cel:)
						(saracen setCycle: Beg self)
					)
					(else
						(self cue:)
					)
				)
			)
			(7
				(= local0 1)
				(if (saracen cel:)
					(saracen x: (- (saracen x:) 9))
				)
				(saracen
					setLoop: (if (< global196 (saracen x:)) 1 else 0)
					view: 376
					setCycle: Fwd
					setMotion: MoveTo global196 global197 self
				)
			)
			(8
				(if (gEgo cycler:)
					(saracen
						view: (if (< (gEgo x:) (saracen x:)) 381 else 378)
						setLoop: 0
					)
				)
			)
			(9
				(saracen
					view: (if (< (gEgo x:) (saracen x:)) 381 else 378)
					setLoop: 0
				)
				(= cycles 2)
			)
			(10
				(= global196 (saracen x:))
				(= global197 (saracen y:))
				(gCurRoom newRoom: 133) ; finalBattle
				(self dispose:)
			)
		)
	)
)

(instance iAmADork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(+
							(saracen x:)
							(if (< (gEgo x:) (saracen x:)) -60 else 60)
						)
						(saracen y:)
						self
				)
			)
			(1
				(gEgo
					view: 4
					setLoop: (if (< (gEgo x:) (saracen x:)) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(saracenChallenge cue:)
				(self dispose:)
			)
		)
	)
)

(instance helmMagic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theHelm
					loop: 2
					cel: 0
					posn: (+ (theHelm x:) 500) (theHelm y:)
					setCycle: End self
				)
			)
			(1
				(theHelm
					loop: 2
					cel: 0
					posn: (- (theHelm x:) 500) (theHelm y:)
					setCycle: End self
				)
			)
			(2
				(theHelm
					loop: 3
					posn: (theHelm x:) (theHelm y:)
					setCycle: End self
				)
			)
			(3
				(theHelm loop: 4 posn: (theHelm x:) (theHelm y:))
				(helmFlash
					init:
					loop: 3
					posn: (theHelm x:) (theHelm y:)
					setPri: (- (theHelm priority:) 1)
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(4
				(helmFlash loop: 2 cel: 2 setCycle: Beg self)
			)
			(5
				(helmFlash dispose:)
				(self dispose:)
			)
		)
	)
)

