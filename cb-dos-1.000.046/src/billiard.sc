;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 245)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	billiard 0
)

(synonyms
	(attorney man)
	(actress woman)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 2]
	local8
	local9
	local10
	local11
	local12
	local13
	local14 = -1
	local15 = -1
	local16 = -1
	[local17 56] = [0 0 0 0 0 0 -32768 0 0 105 114 0 0 -32768 0 0 105 128 0 0 -32768 207 114 105 114 0 0 -32768 105 128 207 128 0 0 -32768 0 0 207 114 0 0 -32768 0 0 207 128 0 0 -32768 0 0 0 0 0 0 -32768]
	[local73 30] = [0 0 85 123 -32768 105 114 145 109 -32768 105 128 162 143 -32768 0 0 230 123 -32768 207 114 145 109 -32768 207 128 162 143 -32768]
	local103
	[local104 14] = [207 114 105 114 72 120 -32768 207 128 105 128 72 120 -32768]
	local118
	[local119 129] = [600 0 179 98 500 1 600 1 185 98 191 101 600 2 185 103 -32768 600 0 127 103 500 1 600 1 125 100 158 99 500 2 172 99 600 2 183 98 -32768 600 0 182 98 500 2 600 2 186 101 -32768 600 1 190 102 153 103 600 2 127 103 -32768 600 0 157 103 500 1 600 1 176 104 600 2 182 103 -32768 600 0 134 101 500 2 132 98 600 1 125 100 600 2 129 104 131 103 -32768 600 0 186 102 500 1 600 1 191 100 187 98 600 2 182 100 -32768 600 0 157 101 500 1 143 104 600 1 135 102 600 2 130 100 -32768 700]
	[local248 87] = [600 0 191 101 145 105 600 1 140 104 500 2 600 2 124 103 -32768 600 0 122 103 124 104 144 98 600 1 154 104 600 2 160 102 -32768 600 0 175 98 600 1 188 101 500 2 600 2 190 103 -32768 600 0 191 103 180 104 600 1 165 101 500 2 600 2 163 98 154 100 -32768 600 0 151 98 146 100 500 2 600 1 154 104 168 102 600 2 183 99 -32768]
	[local335 97] = [600 1 133 98 125 100 129 104 600 2 151 98 161 100 -32768 600 1 180 104 191 102 600 2 178 98 -32768 600 0 126 100 600 1 164 104 183 101 500 0 600 2 188 98 191 100 -32768 600 1 192 99 188 98 164 101 137 104 600 2 130 101 -32768 600 0 123 102 128 104 600 1 154 98 600 2 161 101 -32768 600 1 125 100 135 98 600 2 143 101 -32768 600 1 124 102 128 104 600 2 138 103 -32768]
)

(procedure (localproc_0 param1 param2)
	(param1 setStep: (- 5 param2) (- 4 param2) moveSpeed: param2)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2)
	(= local103
		(cond
			((== (param1 x:) 85) 0)
			((== (param1 y:) 109) 7)
			((== (param1 y:) 143) 14)
			((== (param1 x:) 230) 21)
		)
	)
	(if (> (CueBall x:) 154)
		(+= local103 28)
	)
	(if (== param1 Clarence)
		(= temp0 35)
		(= temp1 32)
		(= temp2 23)
	else
		(= temp0 37)
		(= temp1 36)
		(= temp2 25)
	)
	(= [local17 (+ local103 4)]
		(if (< (CueBall x:) 155)
			(- (CueBall x:) temp0)
		else
			(+ (CueBall x:) temp1)
		)
	)
	(= [local17 (+ local103 5)] (+ (CueBall y:) temp2))
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(= local103
		(*
			(= local103
				(cond
					((< (param1 x:) 155)
						(if (< (CueBall x:) 155)
							(Random 1 2)
						else
							(Random 0 2)
						)
					)
					((> (CueBall x:) 154)
						(Random 4 5)
					)
					(else
						(Random 3 5)
					)
				)
			)
			5
		)
	)
	(if (and local12 (!= local13 18))
		(= temp0 local8)
		(= temp1 local9)
	else
		(= temp0 (param2 x:))
		(= temp1 (param2 y:))
	)
	(if
		(and
			(== [local73 (+ local103 2)] temp0)
			(== [local73 (+ local103 3)] temp1)
			(or (== (-= local103 5) 0) (== local103 15))
		)
		(+= local103 10)
	)
)

(procedure (localproc_3 param1)
	(param1
		loop:
			(= local10
				(switch (param1 x:)
					(85 0)
					(145 2)
					(162 3)
					(230 1)
				)
			)
		cel: 0
		forceUpd:
	)
	(if (and (== param1 Gloria) (<= local10 1))
		(Gloria loop: (+= local10 4) forceUpd:)
	)
)

(procedure (localproc_4 param1 &tmp temp0)
	(if (> (param1 x:) 159)
		(= temp0 171)
	else
		(= temp0 40)
	)
	(Print &rest #at temp0 140 #font 4 #width 125 #mode 1 #dispose)
)

(procedure (localproc_5 param1 param2)
	(param1 setCycle: Fwd)
	(param2 setCycle: 0 cel: 0 stopUpd:)
	(localproc_4 param1 &rest)
)

(procedure (localproc_6)
	(localproc_5 Gloria Clarence &rest)
)

(procedure (localproc_7)
	(localproc_5 Clarence Gloria &rest)
)

(instance billiard of Rgn
	(properties)

	(method (init)
		(super init:)
		(CueBall setLoop: 9 setCel: 2 setPri: 8 init: stopUpd:)
		(Ball1 setLoop: 9 setCel: 0 setPri: 8 init: stopUpd:)
		(Ball2 setLoop: 9 setCel: 0 setPri: 8 init: stopUpd:)
		(if (not (& gMustDos $0002))
			(LoadMany rsFONT 4 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(Load rsSCRIPT 985)
		(LoadMany rsMESSAGE 243 249 248)
		(LoadMany rsVIEW 405 407 365 364)
		(LoadMany rsSYNC 7 3)
		(= global208 68)
		(= [global377 6] 248)
		(= [global377 2] 249)
		(Clarence cel: (Clarence lastCel:) init: stopUpd:)
		(Gloria init: stopUpd:)
		(self setScript: playGame)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/people')
					(Print 245 0) ; "It appears that Clarence and Gloria are in the middle of a game of billiards."
				)
				((Said 'listen/attorney,actress')
					(Print 245 1) ; "They're not saying anything of interest."
				)
				((and (IsFlag 51) (Said 'tell//gertie<about'))
					(|= global145 $0042)
					(= local12 1)
					(= global202 0)
					(Gloria startUpd: setScript: goSee)
				)
			)
		)
	)
)

(instance CBPath of Script
	(properties)

	(method (changeState)
		(repeat
			(if (!= [local119 (++ local14)] -32768)
				(switch [local119 local14]
					(500
						(if (== [local119 (++ local14)] 1)
							(Ball1 setScript: B1Path)
						else
							(Ball2 setScript: B2Path)
						)
					)
					(600
						(localproc_0 CueBall [local119 (++ local14)])
					)
					(else
						(CueBall
							setMotion:
								MoveTo
								[local119 local14]
								[local119 (++ local14)]
								self
						)
						(break)
					)
				)
			else
				(client setScript: 0)
				(break)
			)
		)
	)
)

(instance B1Path of Script
	(properties)

	(method (changeState)
		(repeat
			(if (!= [local248 (++ local15)] -32768)
				(switch [local248 local15]
					(500
						(if (== [local248 (++ local15)] 0)
							(CueBall setScript: CBPath)
						else
							(Ball2 setScript: B2Path)
						)
					)
					(600
						(localproc_0 Ball1 [local248 (++ local15)])
					)
					(else
						(Ball1
							setMotion:
								MoveTo
								[local248 local15]
								[local248 (++ local15)]
								self
						)
						(break)
					)
				)
			else
				(client setScript: 0)
				(break)
			)
		)
	)
)

(instance B2Path of Script
	(properties)

	(method (changeState)
		(repeat
			(if (!= [local335 (++ local16)] -32768)
				(switch [local335 local16]
					(500
						(if (== [local335 (++ local16)] 0)
							(CueBall setScript: CBPath)
						else
							(Ball1 setScript: B1Path)
						)
					)
					(600
						(localproc_0 Ball2 [local335 (++ local16)])
					)
					(else
						(Ball2
							setMotion:
								MoveTo
								[local335 local16]
								[local335 (++ local16)]
								self
						)
						(break)
					)
				)
			else
				(client setScript: 0)
				(break)
			)
		)
	)
)

(instance GoSeePath of Script
	(properties)

	(method (changeState)
		(if (!= [local104 (++ local118)] -32768)
			(Gloria
				setMotion:
					MoveTo
					[local104 local118]
					[local104 (++ local118)]
					self
			)
		else
			(client setScript: 0)
		)
	)
)

(instance playGame of Script
	(properties)

	(method (doit)
		(super doit:)
		(DisposeScript 990)
		(if (and local0 (== (CueBall script:) (Ball1 script:) (Ball2 script:)))
			(if (== [local119 (+ local14 1)] 700)
				(= local14 (= local15 (= local16 -1)))
			)
			(= local0 0)
			(= cycles 14)
		)
		(cond
			((and (not local12) (or (Clarence isBlocked:) (Gloria isBlocked:)))
				(if (not local5)
					(if (Clarence isBlocked:)
						(= global213 7)
					else
						(= global213 3)
					)
					(Say 1 245 2) ; "Laura, will you please step aside?!"
					(User canInput: 0)
					(= local5 1)
				)
			)
			(local5
				(User canInput: 1)
				(= local5 0)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0002))
						(|= gMustDos $0002)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(User canInput: 0)
				(if (not local4)
					(switch global178
						(0
							(localproc_7 245 3)
						)
						(1
							(localproc_7 245 4)
						)
						(2
							(localproc_7 245 5)
						)
						(3
							(localproc_6 245 6)
						)
						(4
							(localproc_7 245 7)
						)
					)
				)
				(= cycles 20)
			)
			(2
				(if (not local4)
					(switch global178
						(0
							(localproc_6 245 8)
						)
						(1
							(localproc_6 245 9)
						)
						(2
							(localproc_6 245 10)
						)
						(3
							(localproc_7 245 11)
						)
						(4
							(localproc_6 245 12)
						)
					)
				)
				(if (< global178 4)
					(++ global178)
				)
				(if (not local4)
					(= local4 1)
				)
				(= cycles 20)
			)
			(3
				(cls)
				(User canInput: 1)
				(Gloria stopUpd:)
				(localproc_3 Gloria)
				(Clarence setCycle: Walk)
				(localproc_1 Clarence)
				(= cycles 1)
			)
			(4
				(if (== [local17 local103] -32768)
					(= cycles 1)
				else
					(if [local17 local103]
						(Clarence
							setMotion:
								MoveTo
								[local17 local103]
								[local17 (+ local103 1)]
								self
						)
					else
						(= cycles 1)
					)
					(+= local103 2)
					(= state 3)
				)
			)
			(5
				(Clarence
					view: 405
					cel: 0
					loop: (if (< (Clarence x:) 155) 0 else 2)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(Clarence cel: 0 loop: (+ (Clarence loop:) 1) setCycle: Fwd)
				(= cycles 7)
			)
			(7
				(CueBall setScript: CBPath)
				(Clarence loop: (- (Clarence loop:) 1))
				(Clarence
					cel: (Clarence lastCel:)
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(8
				(= local0 1)
			)
			(9
				(if (< (Random 1 100) 25)
					(localproc_4 Clarence 245 13) ; "Darn! Missed again."
				)
				(Clarence view: 407 cycleSpeed: 0 setCycle: Walk)
				(localproc_2 Clarence Gloria)
				(= cycles 1)
			)
			(10
				(if (== [local73 local103] -32768)
					(= cycles 1)
				else
					(if [local73 local103]
						(Clarence
							setMotion:
								MoveTo
								[local73 local103]
								[local73 (+ local103 1)]
								self
						)
					else
						(= cycles 1)
					)
					(+= local103 2)
					(= state 9)
				)
			)
			(11
				(cls)
				(Clarence stopUpd:)
				(localproc_3 Clarence)
				(if local12
					(= state 19)
					(= local13 10)
				else
					(Gloria view: 364 setCycle: Walk)
					(localproc_1 Gloria)
				)
				(= cycles 1)
			)
			(12
				(cond
					(local12
						(= state 19)
						(= local13 11)
						(= cycles 1)
					)
					((== [local17 local103] -32768)
						(= cycles 1)
					)
					(else
						(if [local17 local103]
							(Gloria
								setMotion:
									MoveTo
									[local17 local103]
									[local17 (+ local103 1)]
									self
							)
						else
							(= cycles 1)
						)
						(+= local103 2)
						(= state 11)
					)
				)
			)
			(13
				(if local12
					(= state 19)
					(= local13 12)
					(= cycles 1)
				else
					(Gloria
						view: 365
						cel: 0
						loop: (if (< (Gloria x:) 155) 0 else 2)
						cycleSpeed: 1
						setCycle: End self
					)
				)
			)
			(14
				(if local12
					(= state 19)
					(= local13 12)
				else
					(Gloria
						cel: 0
						loop: (+ (Gloria loop:) 1)
						cycleSpeed: 0
						setCycle: Fwd
					)
				)
				(= cycles 7)
			)
			(15
				(if (not local12)
					(CueBall setScript: CBPath)
				)
				(Gloria loop: (- (Gloria loop:) 1))
				(Gloria cel: (Gloria lastCel:) cycleSpeed: 1 setCycle: Beg self)
			)
			(16
				(if local12
					(= state 19)
					(if (CueBall script:)
						(= local13 18)
					else
						(= local13 12)
					)
					(= cycles 1)
				else
					(= local0 1)
				)
			)
			(17
				(if local12
					(= state 19)
					(= local13 18)
				else
					(Gloria view: 364 cycleSpeed: 0 setCycle: Walk)
					(localproc_2 Gloria Clarence)
					(if
						(and
							(!= local103 0)
							(!= local103 15)
							(< (Random 1 100) 50)
						)
						(localproc_4 Gloria 245 14) ; "If you keep playing like this, dahling. I'm going to win!"
					)
				)
				(= cycles 1)
			)
			(18
				(cond
					(local12
						(= state 19)
						(= local13 18)
						(= cycles 1)
					)
					((== [local73 local103] -32768)
						(= cycles 1)
					)
					(else
						(if [local73 local103]
							(Gloria
								setMotion:
									MoveTo
									[local73 local103]
									[local73 (+ local103 1)]
									self
							)
						else
							(= cycles 1)
						)
						(+= local103 2)
						(= state 17)
					)
				)
			)
			(19
				(if local12
					(= state 19)
					(= local13 18)
				else
					(cls)
					(Gloria stopUpd:)
					(localproc_3 Gloria)
					(= state 2)
				)
				(= cycles 1)
			)
			(20
				(= cycles 1)
			)
			(21
				(if local12
					(= state 20)
				else
					(= state local13)
				)
				(= cycles 1)
			)
		)
	)
)

(instance goSee of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== global202 3)
			(= global202 0)
			(if (not seconds)
				(= cycles 1)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global190 1)
				(HandsOff)
				(cls)
				(if (and (> (playGame state:) 10) (< (playGame state:) 20))
					(= state -1)
				else
					(cls)
					(= global213 3)
					(Say 1 245 15) ; "Mother??? Oh, no! It can't be!"
					(= local8 (Gloria x:))
					(= local9 (Gloria y:))
					(= local10 (Gloria loop:))
					(= local11 (Gloria cel:))
					(if (not (& (gEgo onControl: 0) $0001))
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 20)
								(+ (gEgo y:) 20)
						)
					)
					(Gloria
						view: 364
						illegalBits: 0
						ignoreActors: 1
						setCycle: Walk
					)
					(Clarence ignoreActors: 1)
					(cond
						((< local8 106)
							(= local118 3)
						)
						((< local9 115)
							(= local118 1)
						)
						((> local9 127)
							(= local118 8)
						)
						((> local9 123)
							(= local118 6)
						)
						(else
							(= local118 -1)
						)
					)
					(self setScript: GoSeePath)
				)
				(= cycles 1)
			)
			(1
				(cls)
				(if (self script:)
					(= state 0)
					(= cycles 1)
				else
					(= global202 1)
				)
			)
			(2
				(Gloria setMotion: MoveTo 22 125 self)
			)
			(3
				(= global202 2)
				(= seconds 5)
			)
			(4
				(if (and (& (Clarence signal:) $0004) (not local0))
					(= global202 1)
				else
					(= state 3)
					(= cycles 1)
				)
			)
			(5
				(Clarence ignoreActors: 0)
				(Gloria
					loop: -1
					illegalBits: -32768
					ignoreActors: 0
					setAvoider: (Avoid new:)
					setCycle: Walk
					setMotion: MoveTo 72 125 self
				)
			)
			(6
				(Gloria illegalBits: -32764)
				(= global202 2)
			)
			(7
				(= global213 3)
				(Say 1 245 16) ; "You're very mean! There's NOTHING there!"
				(if (== local13 18)
					(= temp0 (Gloria x:))
					(Gloria x: local8)
					(localproc_2 Gloria Clarence)
					(Gloria
						x: temp0
						setMotion:
							MoveTo
							[local73 (+ local103 2)]
							[local73 (+ local103 3)]
							self
					)
				else
					(Gloria setMotion: MoveTo local8 local9 self)
				)
			)
			(8
				(if (!= local13 18)
					(Gloria loop: local10 cel: local11)
				)
				(HandsOn)
				(Gloria illegalBits: 0 setAvoider: 0 setCycle: 0)
				(DisposeScript 985)
				(= local12 (= global190 0))
				(client setScript: 0)
			)
		)
	)
)

(instance Mouth of Prop ; UNUSED
	(properties
		view 364
		loop 6
		signal 16384
	)
)

(instance CueBall of Act
	(properties
		y 100
		x 130
		view 136
		signal 16384
		illegalBits 0
	)
)

(instance Ball1 of Act
	(properties
		y 99
		x 183
		view 136
		signal 16384
		illegalBits 0
	)
)

(instance Ball2 of Act
	(properties
		y 103
		x 138
		view 136
		signal 16384
		illegalBits 0
	)
)

(instance Gloria of Act
	(properties
		y 123
		x 230
		view 364
		loop 5
		illegalBits 0
	)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Clarence) (gEgo distanceTo: Gloria))
			(= global214 64)
		else
			(= global214 4)
		)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0004)))
				(event claimed: 1)
				(DoLook {gloria})
			)
			(
				(and
					(& global207 $0004)
					(or (MousedOn self event 3) (Said 'look/actress[/!*]'))
				)
				(event claimed: 1)
				(Print 245 0) ; "It appears that Clarence and Gloria are in the middle of a game of billiards."
			)
			((Said 'talk/actress')
				(= global213 3)
				(Say 1 245 17) ; "Please leave us alone, dahling."
			)
		)
	)
)

(instance Clarence of Act
	(properties
		y 123
		x 85
		view 407
		loop 4
		illegalBits 0
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'look,talk/person,men')
				(Print 245 18) ; "Which person are you referring to?"
			)
			((Said 'talk/people')
				(Print 245 19) ; "You can only talk to one person at a time."
			)
			((and (MousedOn self event 3) (not (& global207 $0040)))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney,people'))
				)
				(event claimed: 1)
				(Print 245 0) ; "It appears that Clarence and Gloria are in the middle of a game of billiards."
			)
			((Said 'talk/attorney')
				(if (< (++ local2) 2)
					(= global213 7)
					(Say 1 245 20) ; "Beat it, kid!"
				else
					(Print 245 21) ; "Clarence pointedly refuses to acknowledge you. You must have annoyed him at some time."
				)
			)
		)
	)
)

