;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use TargActor)
(use n814)
(use PolyPath)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm77 0
)

(local
	[local0 4]
	local4
	local5
	local6
	local7
)

(instance rm77 of Rm
	(properties
		noun 1
		picture 702
		style 8
		horizon 57
	)

	(method (dispose)
		(SetFlag 67)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(Load rsVIEW 700)
		(if (and (not gNight) (!= gPrevRoomNum 76) (IsFlag 202))
			(Load rsVIEW 78)
		)
		(super init:)
		(SL enable:)
		(NormalEgo)
		(cond
			((and (not (IsFlag 197)) (not global279))
				(SetFlag 202)
				(= global279 0)
			)
			((and (IsFlag 198) (not global279) (not (IsFlag 202)))
				(switch (Random 0 1)
					(0
						(ClearFlag 202)
					)
					(1
						(SetFlag 202)
					)
				)
			)
		)
		(if (and (not gNight) (!= gPrevRoomNum 76) (IsFlag 202))
			(= [local0 0] (Random 74 165))
			(= [local0 1] (Random 120 160))
			(= [local0 2] (Random 0 1))
			(= [local0 3] (Random 5 30))
			(stag view: 78 x: 92 y: 142 setScript: stagScript init:)
		else
			(ClearFlag 202)
		)
		(= local6 0)
		(= local5 (IsFlag 202))
		(southBush addToPic:)
		(if (and gNight (== gPrevRoomNum 170) (IsFlag 188))
			(HandsOff)
			(gEgo setScript: fairyWalkIn)
			(Load rsSCRIPT 295)
			(ClearFlag 188)
			(self setScript: (ScriptID 295 0)) ; byebye
		)
	)
)

(instance southBush of View
	(properties
		x 58
		y 167
		noun 2
		view 700
		loop 3
		priority 15
	)
)

(instance stag of TargActor
	(properties
		noun 3
		view 78
	)

	(method (init)
		(HandsOff)
		(gEgo setScript: stagWalkIn)
		(super init:)
	)

	(method (getHurt)
		(+= global250 global251)
		(= global251 0)
		(SetFlag 203)
		(if (and (!= script stagBolts) (!= script stagHurt))
			(self setScript: stagHurt)
		)
	)

	(method (doit)
		(= local4 (gEgo distanceTo: self))
		(if (!= script stagBolts)
			(cond
				([local0 2]
					(if (< local4 95)
						(self setScript: stagBolts)
					)
				)
				((< local4 75)
					(self setScript: stagBolts)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(ThrowRock self)
			)
			(16 ; dagger
				(ThrowKnife self)
			)
			(81 ; flameDartSpell
				(CastDart self)
			)
			(12 ; sword
				(self setScript: stagBolts)
			)
			(else
				(switch local6
					(0
						(gMessager say: 3 1 1) ; "The beautiful white stag is foraging for food."
					)
					(5
						(gMessager say: 3 1 2) ; "The white stag takes a mighty leap."
					)
					(else
						(gMessager say: 3 1) ; "You seem to have startled the white stag."
					)
				)
			)
		)
	)
)

(instance stagWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 90)
			)
			(1
				(HandsOff)
				(switch gPrevRoomNum
					(70
						(gEgo setMotion: PolyPath 160 70 self)
					)
					(78
						(gEgo setMotion: PolyPath 260 155 self)
					)
					(else
						(gEgo setMotion: PolyPath 80 100 self)
					)
				)
			)
			(2
				(HandsOff)
				(switch gPrevRoomNum
					(70
						(gEgo loop: 2)
					)
					(78
						(gEgo loop: 1)
					)
					(else
						(gEgo loop: 0)
					)
				)
				(= ticks 30)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance stagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoGait 0 0) ; walking
				(User canControl: 0)
				(if [local0 3]
					(= local6 0)
					(if [local0 2]
						(stag
							loop: 6
							cycleSpeed: 12
							moveSpeed: 12
							setCycle: Fwd
						)
					else
						(stag
							loop: 7
							cycleSpeed: 12
							moveSpeed: 12
							setCycle: Fwd
						)
					)
					(= seconds [local0 3])
				else
					(self cue:)
				)
			)
			(1
				(if [local0 3]
					(stag setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if [local0 3]
					(= local6 2)
					(if [local0 2]
						(stag
							loop: 4
							cel: 7
							cycleSpeed: 6
							moveSpeed: 6
							setCycle: Beg self
						)
					else
						(stag
							loop: 5
							cel: 7
							cycleSpeed: 6
							moveSpeed: 6
							setCycle: Beg self
						)
					)
				else
					(self cue:)
				)
			)
			(3
				(if [local0 2]
					(= local6 4)
					(stag
						loop: 2
						cel: 0
						cycleSpeed: 6
						moveSpeed: 6
						xStep: 5
						yStep: 3
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(User canControl: 1)
				(= local6 6)
				(stag
					loop: 1
					cel: 0
					setCycle: Fwd
					setMotion: PolyPath -40 (stag y:) self
				)
			)
			(5
				(stag posn: -250 (stag y:))
				(self cue:)
			)
			(6
				(User canControl: 1)
				(stag dispose:)
			)
		)
	)
)

(instance stagHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 3 81 0 0 self) ; "The stag looks more surprised than injured."
			)
			(1
				(client setScript: stagBolts)
			)
		)
	)
)

(instance stagBolts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (== (gEgo script:) stagWalkIn))
					(HandsOff)
					(gEgo setCycle: 0 setMotion: 0)
				)
				(if (== local6 0)
					(= local6 1)
					(stag setCycle: End)
				else
					(self cue:)
				)
				(gMessager say: 3 1 0 0 self) ; "You seem to have startled the white stag."
			)
			(1
				(stag cycleSpeed: 4 moveSpeed: 4)
				(cond
					((== local6 1)
						(= local6 3)
						(if [local0 2]
							(stag loop: 4 cel: 7 setCycle: Beg self)
						else
							(stag loop: 5 cel: 7 setCycle: Beg self)
						)
					)
					((== local6 2)
						(= local6 3)
						(stag setCycle: Beg self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(cond
					([local0 2]
						(cond
							((== local6 3)
								(= local6 5)
								(stag
									loop: 2
									cel: 0
									xStep: 5
									setCycle: End self
								)
							)
							((== local6 4)
								(= local6 5)
								(stag setCycle: End self)
							)
							(else
								(self cue:)
							)
						)
					)
					((== local6 3)
						(= local6 5)
						(self cue:)
					)
				)
			)
			(3
				(if (== local6 5)
					(stag setLoop: 9 cel: 0 setStep: 2 2 setCycle: CT 2 1 self)
				else
					(self cue:)
				)
			)
			(4
				(User canControl: 1)
				(if (== local6 5)
					(stag
						setStep: 12 9
						setCycle: Fwd
						setMotion: MoveTo -50 (stag y:) self
					)
				else
					(self cue:)
				)
			)
			(5
				(if (< (stag x:) -30)
					(self cue:)
				else
					(stag
						setStep: 12 9
						setLoop: 9
						setCycle: Fwd
						setMotion: MoveTo -50 (stag y:) self
					)
				)
			)
			(6
				(stag dispose:)
				(NormalEgo)
				(HandsOn)
				(if (== (gEgo script:) (ScriptID 804 1)) ; walkIn
					((ScriptID 804 1) changeState: 4) ; walkIn
				else
					(gEgo setMotion: PolyPath 160 140 setScript: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance fairyWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 90)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 160 110 self)
			)
			(2
				(gEgo loop: 3)
				(self dispose:)
			)
		)
	)
)

