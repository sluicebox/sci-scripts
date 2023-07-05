;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use PolyPath)
(use StopWalk)
(use NameFind)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	blowArbitrator 0
	blowinIt 1
)

(local
	local0
	local1
	[local2 4] = [-17 -20 -23 -27]
	[local6 4] = [-44 -43 -41 -39]
	[local10 4] = [19 20 24 28]
	[local14 4] = [-50 -50 -48 -47]
	local18
	[local19 15] = [1005 10 1 2 1 2 2 2 1 0 1005 17 1 1 0]
	[local34 6] = [1005 18 1 2 2 0]
	[local40 7] = [1005 21 1 2 2 2 0]
	[local47 6] = [1005 25 1 2 2 0]
	[local53 12] = [1005 28 2 1 2 0 1005 31 2 1 2 0]
	[local65 9] = [1005 34 1 2 2 1 2 2 0]
	[local74 6] = [1005 40 2 1 2 0]
	[local80 4] = [1005 43 1 0]
	[local84 5] = [1005 44 2 1 0]
	[local89 5] = [1005 0 1 1 0]
	[local94 6] = [1005 46 2 1 2 0]
	[local100 5] = [1005 49 1 1 0]
	[local105 5] = [1005 51 1 1 0]
	[local110 4] = [1005 53 1 0]
	local114
	local115
	local116
	local117
)

(instance hornSound of Sound
	(properties
		flags 1
		number 904
	)
)

(instance blowinIt of Script
	(properties)

	(method (dispose &tmp temp0)
		(hornSound dispose:)
		(= temp0 0)
		(if
			(not
				(OneOf
					client
					blowArbitrator
					summonWill
					willEnters
					campWillComes
				)
			)
			(= temp0 1)
		)
		(= register 1)
		(super dispose: &rest)
		(if temp0
			(DisposeScript 5)
		)
	)

	(method (doit)
		(if
			(and
				(OneOf (gRgnMusic number:) 585 160 905)
				(== (gEgo view:) 10)
			)
			(gRgnMusic setVol: 0)
			(gRgnMusic fade: 127 30 8 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (or (== client blowArbitrator) (== client summonWill)))
					(= local0 global143)
					(HandsOff)
				)
				(= global111 (gEgo loop:))
				(gEgo
					view: 10
					setCel: 0
					setLoop:
						(if
							(or
								(== (gEgo loop:) 2)
								(== (gEgo loop:) 4)
								(== (gEgo loop:) 0)
								(== (gEgo loop:) 6)
							)
							0
						else
							1
						)
					setCycle: End self
				)
			)
			(1
				(if (and (not (Random 0 50)) (!= gCurRoomNum 120))
					(bubble init: setScript: tinyBubbles)
				)
				(hornSound play:)
				(= seconds 5)
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo global111 0 1)
				(SetFlag 148)
				(if
					(and
						(not
							(or
								(== client blowArbitrator)
								(== client summonWill)
							)
						)
						(not local0)
					)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance blowArbitrator of Script
	(properties)

	(method (init)
		(HandsOff)
		(super init: &rest)
	)

	(method (dispose)
		(HandsOn)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(OneOf
						gCurRoomNum
						450
						440
						350
						390
						270
						280
						290
						300
						310
						452
						455
						460
						470
						480
						530
						550
						560 ; tunnel1
						561 ; tunnel2
						562 ; tunnel3
						570
					)
					(Say 1005 3) ; "I dare not wind my horn here."
					(self dispose:)
				else
					(= local0 global143)
					(HandsOff)
					(= ticks 6)
				)
			)
			(1
				(cond
					(
						(and
							(== gCurRoomNum 220) ; forest
							(==
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								182
								183
							)
						)
						(Say 1005 55 self) ; "I've found in the past that my men cannot hear my horn well from this part of the forest."
					)
					((and (== gDay 2) (IsFlag 182))
						(gEgo setMotion: PolyPath 160 165 self)
					)
					((and (== gDay 1) (NameFind {Tuck} gCast))
						(if (== gBlowCount 0)
							(self setScript: blowinIt self)
						else
							(Say 1005 2 self) ; "Tuck is right. I've no need to wind my horn right now."
						)
					)
					((and (== gDay 5) (not (IsFlag 25)))
						(cond
							((not (IsFlag 111))
								(self setScript: blowinIt self)
							)
							((and (>= global150 1) (not (IsFlag 147)))
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							((>= gBlowCount 1)
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							(else
								(self setScript: summonWill self)
							)
						)
					)
					((and (== gDay 5) (IsFlag 25))
						(cond
							((>= global142 3)
								(self dispose:)
							)
							((and (>= gBlowCount 1) (== global142 0))
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							((and (>= global150 1) (not (IsFlag 55)))
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							((not (IsFlag 111))
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							(else
								(self setScript: summonWill self)
							)
						)
					)
					((and (== gDay 6) (not (IsFlag 25)))
						(cond
							((>= global142 3)
								(self dispose:)
							)
							((and (>= gBlowCount 1) (== global142 0))
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							((and (>= global150 1) (not (IsFlag 55)))
								(Say 1005 17 self) ; "'Tis pointless to call for Will again. Whatever I do today, I must needs do on my own."
							)
							(else
								(self setScript: summonWill self)
							)
						)
					)
					((and (== gDay 6) (IsFlag 25))
						(self setScript: summonWill self)
					)
					((== gDay 9)
						(if (IsFlag 36)
							(self setScript: summonWill self)
						else
							(Say 1005 7 self) ; "After Will's warning, I'd best not wind my horn until I can be sure of any danger."
						)
					)
					((== gDay 10)
						(self setScript: summonWill self)
					)
					((== gDay 11)
						(if (== global150 0)
							(self setScript: summonWill self)
						else
							(self setScript: blowinIt self)
						)
					)
					((== gDay 12)
						(if (IsFlag 38)
							(self setScript: summonWill self)
						else
							(Say 1005 8 self) ; "I'd be foolish indeed to wind my horn knowing Sheriff's men are abroad in Sherwood."
						)
					)
					((== gDay 13)
						(self setScript: blowinIt self)
					)
					(else
						(self setScript: summonWill self)
					)
				)
			)
			(2
				(cond
					(
						(and
							(== gCurRoomNum 220) ; forest
							(==
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								182
								183
							)
						)
						(self dispose:)
					)
					((and (== gDay 1) (NameFind {Tuck} gCast))
						(if (== gBlowCount 0)
							(++ gBlowCount)
							(Converse 1 @local89 15 1 self) ; "The men are all out and about."
						else
							(++ gBlowCount)
							(self dispose:)
						)
					)
					(
						(and
							(== gDay 5)
							(not (IsFlag 25))
							(not (IsFlag 111))
						)
						(Say 1005 54 self) ; "Will would have been here by now if he were coming."
					)
					((and (== gDay 5) (IsFlag 25))
						(if (OneOf global142 1 2)
							(self setScript: blowinIt self)
						else
							(self dispose:)
						)
					)
					((and (== gDay 6) (not (IsFlag 25)))
						(if (>= 2 global142 1)
							(self setScript: blowinIt self)
						else
							(self dispose:)
						)
					)
					((== gDay 10)
						(if (== global159 2)
							(if (== gCurRoomNum 220) ; forest
								(SetFlag 176)
							)
							(gCurRoom newRoom: 171) ; strat
						else
							(self setScript: blowinIt self)
						)
					)
					((== gDay 11)
						(if (== gCurRoomNum 220) ; forest
							(SetFlag 176)
						)
						(gCurRoom newRoom: 171) ; strat
					)
					((== gDay 13)
						(if (== gCurRoomNum 220) ; forest
							(SetFlag 176)
						)
						(gCurRoom newRoom: 171) ; strat
					)
					(else
						(self dispose:)
					)
				)
			)
			(3
				(cond
					((and (== gDay 5) (not (IsFlag 25)))
						(self dispose:)
					)
					((and (== gDay 6) (not (IsFlag 25)))
						(if (== gCurRoomNum 220) ; forest
							(SetFlag 176)
						)
						(gCurRoom newRoom: 171) ; strat
					)
					((and (== gDay 5) (IsFlag 25))
						(if (== gCurRoomNum 220) ; forest
							(SetFlag 176)
						)
						(gCurRoom newRoom: 171) ; strat
					)
					((== gDay 10)
						(if (== gCurRoomNum 220) ; forest
							(SetFlag 176)
						)
						(gCurRoom newRoom: 171) ; strat
					)
					(else
						(self dispose:)
					)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance summonWill of Script
	(properties)

	(method (init)
		(= local1 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (OneOf gCurRoomNum 220 180 250) ; forest
					(self setScript: willEnters self)
				else
					(self setScript: campWillComes self)
				)
			)
			(1
				(cond
					((and (== gDay 5) (not (IsFlag 25)))
						(cond
							((and (IsFlag 147) (== gBlowCount 0))
								(+= gBlowCount 1)
								(Converse 2 @local19 1 1 14 0 self) ; "I'd have your advice on using the Fens Monk's robe."
							)
							((and (IsFlag 111) (== global150 0))
								(+= global150 1)
								(Converse 2 @local34 1 1 14 0 self) ; "The Widow's sons are in terrible danger."
							)
							(else
								(self dispose:)
							)
						)
					)
					((and (== gDay 5) (IsFlag 25))
						(cond
							((OneOf global142 1 2)
								(+= gBlowCount 1)
								(= local1 1)
								(Converse 2 @local53 1 1 14 0 self) ; "Robin, what news?"
							)
							((and (== global142 0) (!= gBlowCount 0))
								(+= gBlowCount 1)
								(Converse 2 @local47 1 1 14 0 self) ; "Will, I've taken an Abbey Monk's robe into my possession."
							)
							((and (IsFlag 55) (== gBlowCount 0))
								(+= gBlowCount 1)
								(Converse 2 @local47 1 1 14 0 self) ; "Will, I've taken an Abbey Monk's robe into my possession."
							)
							((and (IsFlag 111) (== global150 0))
								(+= global150 1)
								(Converse 2 @local34 1 1 14 0 self) ; "The Widow's sons are in terrible danger."
							)
							(else
								(self dispose:)
							)
						)
					)
					((and (== gDay 6) (not (IsFlag 25)))
						(cond
							((not (IsFlag 55))
								(+= global150 1)
								(Converse 2 @local40 1 1 14 0 self) ; "We have until sunset to rescue the Widow's sons."
							)
							((>= 2 global142 1)
								(+= gBlowCount 1)
								(= local1 1)
								(Converse 2 @local53 1 1 14 0 self) ; "Robin, what news?"
							)
							((== global142 0)
								(+= gBlowCount 1)
								(Converse 2 @local47 1 1 14 0 self) ; "Will, I've taken an Abbey Monk's robe into my possession."
							)
							(else
								(+= gBlowCount 1)
								(self dispose:)
							)
						)
					)
					((and (== gDay 6) (IsFlag 25))
						(switch global150
							(0
								(+= global150 1)
								(Converse 2 @local94 1 1 14 0 self) ; "What is it, Robin?! I see no danger."
							)
							(1
								(+= global150 1)
								(Converse 1 @local100 14 0 self) ; "What now, Robin? I see nothing amiss."
							)
							(2
								(+= global150 1)
								(Converse 1 @local105 14 0 self) ; "By my troth, Robin, if you've called me again for no good reason--!"
							)
							(else
								(+= global150 1)
								(Converse 1 @local110 14 0 self) ; "I hope you have a better reason for calling me next time."
							)
						)
					)
					((== gDay 10)
						(++ gBlowCount)
						(switch global159
							(0
								(= local1 1)
								(Converse 2 @local65 1 1 14 0 self) ; "Will, I must find a way to save Marian."
							)
							(1
								(= local1 1)
								(Converse 2 @local74 1 1 14 0 self) ; "From the look upon your face, you have not fared well."
							)
							(else
								(= local1 1)
								(Converse 1 @local80 14 0 self) ; "Say not another word. I've sent for the rest of the men to join me with all haste."
							)
						)
					)
					((== gDay 11)
						(= local1 1)
						(Converse 2 @local84 1 1 14 0 self) ; "The men are on the alert. They'll be here as quickly as they can manage."
					)
					(else
						(switch global150
							(0
								(++ global150)
								(Converse 2 @local94 1 1 14 0 self) ; "What is it, Robin?! I see no danger."
							)
							(1
								(++ global150)
								(Converse 1 @local100 14 0 self) ; "What now, Robin? I see nothing amiss."
							)
							(2
								(++ global150)
								(Converse 1 @local105 14 0 self) ; "By my troth, Robin, if you've called me again for no good reason--!"
							)
							(else
								(++ global150)
								(Converse 1 @local110 14 0 self) ; "I hope you have a better reason for calling me next time."
							)
						)
					)
				)
			)
			(2
				(if (not local1)
					(if (OneOf gCurRoomNum 220 180 250) ; forest
						(self setScript: willLeaves self)
					else
						((ScriptID 20) setMotion: PolyPath -10 120 self) ; Will
					)
				else
					(= ticks 6)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance willEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gCurRoomNum 180)
					(gEgo setMotion: PolyPath 150 175 self)
				else
					(= ticks 6)
				)
			)
			(1
				(self setScript: blowinIt self)
			)
			(2
				(if (> (gEgo x:) 185)
					(= local114 -15)
					(if (== gCurRoomNum 180)
						(= local115 187)
					else
						(= local115 145)
					)
				else
					(= local114 335)
					(if (== gCurRoomNum 180)
						(= local115 187)
					else
						(= local115 145)
					)
				)
				(= ticks (Random 10 60))
			)
			(3
				(if (> (gEgo x:) 185)
					(Willbert
						posn: local114 local115
						init:
						setCycle: StopWalk 161
						setMotion:
							PolyPath
							(- (gEgo x:) 35)
							(gEgo y:)
							self
					)
				else
					(Willbert
						posn: local114 local115
						init:
						setCycle: StopWalk 161
						setMotion:
							PolyPath
							(+ (gEgo x:) 35)
							(gEgo y:)
							self
					)
				)
				(= cycles 15)
			)
			(4
				(Face gEgo Willbert)
			)
			(5
				(= cycles 30)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance campWillComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: StopWalk 1 setMotion: PolyPath 140 78 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(= ticks 6)
			)
			(3
				(if (not (NameFind {Will} gCast))
					((ScriptID 20) init: loop: 0 x: -25 y: 120) ; Will
				)
				(DisposeScript 974)
				(self setScript: blowinIt self)
			)
			(4
				((ScriptID 20) ; Will
					setCycle: StopWalk 161
					setMotion: PolyPath 100 84 self
				)
			)
			(5
				(= ticks 6)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance willLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local116 local114)
				(= local117 local115)
				(Willbert setMotion: PolyPath local116 local117 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance thornyHorn of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1005 55 self) ; "I've found in the past that my men cannot hear my horn well from this part of the forest."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance tinyBubbles of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (gEgo loop:))
				(bubble
					posn:
						(+
							(gEgo x:)
							(if temp0 [local2 local18] else [local10 local18])
						)
						(+
							(gEgo y:)
							(if temp0 [local6 local18] else [local14 local18])
						)
					setCel: local18
				)
				(++ local18)
				(= ticks 12)
			)
			(1
				(if (< local18 4)
					(-= state 2)
				)
				(self cue:)
			)
			(2
				(bubble
					setMotion:
						MoveTo
						(if (gEgo loop:)
							(- (gEgo x:) 75)
						else
							(+ (gEgo x:) 75)
						)
						-20
						self
				)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance bubble of Actor
	(properties
		yStep 8
		view 10
		loop 2
		signal 24576
		xStep 6
	)

	(method (init)
		(self setPri: (gEgo priority:))
		(super init:)
	)
)

(instance Willbert of Actor
	(properties
		description {Will Scarlet}
		view 160
	)

	(method (init)
		(self setLoop: scarletGroop)
		(super init:)
	)

	(method (dispose)
		(self setCycle: 0 setMotion: 0 actions: 0)
		(super dispose:)
		(self delete:)
	)
)

(instance scarletGroop of Grooper
	(properties)
)

