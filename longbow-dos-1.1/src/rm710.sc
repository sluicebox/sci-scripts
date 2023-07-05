;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm710 0
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
	local11
	local12
	local13
	local14
	local15 = 1
	local16
	local17
	[local18 5] = [118 133 152 171 183]
	[local23 5] = [29 27 25 23 26]
	[local28 10] = [125 125 125 125 125 127 129 131 133 134]
	[local38 10] = [175 175 175 172 170 168 165 162 158 156]
)

(procedure (localproc_0)
	(= local13
		(switch local15
			(0 88)
			(1 88)
			(2 86)
			(3 80)
			(4 78)
			(5 76)
			(6 71)
			(7 69)
			(8 65)
			(9 60)
		)
	)
	(= local14
		(switch local15
			(0 68)
			(1 68)
			(2 64)
			(3 62)
			(4 58)
			(5 58)
			(6 54)
			(7 51)
			(8 47)
			(9 45)
		)
	)
)

(procedure (localproc_1)
	(= local2 (/ 80 global125))
	(= local3 (Max 3 (- (/ 66 global125) (* local15 2))))
	(= local0 (/ 36 global125))
	(= local1 (+ 4 global125))
	(= local4
		(switch global125
			(2 5)
			(3 4)
			(4 2)
		)
	)
	(= local6
		(cond
			((<= local15 3)
				(- 30 (* global125 2))
			)
			((<= local15 6)
				(- 25 (* global125 2))
			)
			((<= local15 9)
				(- 20 (* global125 2))
			)
		)
	)
	(= local5 (- global125 1))
)

(procedure (localproc_2)
	(= local16 1)
	(robin
		cycleSpeed: local5
		moveSpeed: local5
		setCel: 0
		setCycle: Fwd
		setMotion: MoveTo (Min local17 [local38 (robin loop:)]) 88
	)
)

(procedure (localproc_3)
	(= local16 -1)
	(robin
		cycleSpeed: local5
		moveSpeed: local5
		setCel: 0
		setCycle: Rev
		setMotion: MoveTo (Max local17 [local28 (robin loop:)]) 88
	)
)

(instance rm710 of Rm
	(properties
		picture 710
	)

	(method (init)
		(= local7 (== gPrevRoomNum 702))
		(= local12 global125)
		(= style (if (IsFlag 0) 10 else 8))
		(LoadMany rsVIEW 711 710)
		(LoadMany rsSOUND 631 931 928 929 915 930)
		(super init:)
		(HandsOn)
		(gTheIconBar disable: 0 1 3 4 5 6 7)
		(localproc_1)
		((gTheIconBar at: 2) message: 1)
		(gGame setCursor: gTheCursor 1 150 175)
		(splashSound init:)
		(fenL init: setScript: (throwRock new:) 0 rockL)
		(fenR init:)
		(rockL init:)
		(rockR init:)
		(robin init:)
		(gRgnMusic number: 631 loop: -1 play:)
		(= local13 88)
		(= local14 68)
		(boat
			setLoop: (if local7 10 else 8)
			init:
			setScript: (if local7 cmonRobin else 0)
		)
		(if (not local7)
			(if (== global125 1)
				(= local11 1)
				(robin setScript: toTheBoat)
			else
				(SetMessageColor 29)
				(Say 1710 0 80 {Monk}) ; "Brothers! The prisoner is escaping! Stop him!"
				(SetMessageColor 0)
				(gMouseDownHandler add: self)
				(gDirectionHandler add: self)
				(if (proc13_1 710 0 81 {YES} 1 81 {NO} 0) ; "Would you like to save your game now?"
					(gGame save:)
				)
			)
		)
		(SetMessageColor 0)
	)

	(method (doit)
		(if (== (mod (++ local9) 5) 0)
			(Palette palANIMATE 240 255 -1)
		)
		(if (and (not local10) (!= global125 local12))
			(= local12 global125)
			(if (== global125 1)
				(= local10 1)
				(= local11 1)
				(robin setScript: toTheBoat)
			else
				(localproc_1)
			)
		)
		(super doit:)
	)

	(method (dispose)
		((gTheIconBar at: 2) message: 3)
		(splashSound dispose:)
		(thudSound dispose:)
		(gRgnMusic fade: 0 30 8 1)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((& (event type:) $0040) ; direction
				(event claimed: 1)
				(switch (event message:)
					(JOY_RIGHT
						(= local17 319)
						(localproc_2)
					)
					(JOY_LEFT
						(= local17 0)
						(localproc_3)
					)
				)
			)
			((& (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(= temp2 (/ (+ local13 local14) 2))
				(= local17 (event x:))
				(= temp0 (- (robin x:) 20))
				(= temp1 (+ (robin x:) 20))
				(if (< local14 (event y:) local13)
					(cond
						((<= local17 (robin x:))
							(localproc_3)
						)
						((> local17 (robin x:))
							(localproc_2)
						)
					)
				)
			)
		)
	)
)

(instance robin of Actor
	(properties
		x 149
		y 88
		yStep 1
		view 711
		loop 1
		cel 91
		priority 11
		signal 26640
	)

	(method (doit)
		(if (not local10)
			(cond
				(script)
				((and cycler (not mover))
					(self setCycle: 0)
					(= local16 0)
				)
			)
		)
		(super doit:)
	)
)

(instance fenL of Actor
	(properties
		x 115
		y 193
		yStep 4
		view 710
		priority 14
		signal 26640
		cycleSpeed 18
		illegalBits 0
		moveSpeed 0
	)
)

(instance fenR of Actor
	(properties
		x 180
		y 193
		yStep 4
		view 710
		loop 1
		priority 14
		signal 26640
		cycleSpeed 18
		illegalBits 0
		moveSpeed 0
	)
)

(instance boat of Actor
	(properties
		x 173
		y 50
		view 710
		loop 8
		priority 10
		signal 2064
		cycleSpeed 18
		illegalBits 0
		moveSpeed 18
	)
)

(instance rockL of Actor
	(properties
		yStep 6
		view 710
		loop 2
		priority 13
		signal 18576
		illegalBits 0
		xStep 4
	)
)

(instance rockR of Actor
	(properties
		yStep 6
		view 710
		loop 2
		priority 13
		signal 18576
		illegalBits 0
		xStep 4
	)
)

(instance throwRock of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(switch (= state newState)
			(0
				(= ticks local0)
			)
			(1
				(client
					setCel: 0
					yStep: local1
					setMotion:
						MoveTo
						(if (== client fenR) 180 else 115)
						157
						self
				)
			)
			(2
				(if local10
					(self dispose:)
				else
					(= ticks 12)
				)
			)
			(3
				(client setCel: 1)
				(if local10
					(self dispose:)
				else
					(= ticks local2)
				)
			)
			(4
				(client setCel: 2 setCycle: End)
				(= temp1
					(cond
						((== local16 1)
							(Min [local38 local15] (+ (robin x:) local3))
						)
						((== local16 -1)
							(Max [local28 local15] (- (robin x:) local3))
						)
						((<= (robin x:) (+ [local28 local15] 15)) [local28 local15])
						(else
							(- (robin x:) local3)
						)
					)
				)
				(= temp2
					(cond
						((== local16 1)
							(Min
								[local38 local15]
								(+ (robin x:) (* local3 2))
							)
						)
						((== local16 -1)
							(Max
								[local28 local15]
								(- (robin x:) (* local3 2))
							)
						)
						((>= (robin x:) (- [local38 local15] 15)) [local38 local15])
						(else
							(+ (robin x:) local3)
						)
					)
				)
				(= temp3
					(cond
						(local7
							(robin x:)
						)
						((< temp1 temp2)
							(Random temp1 temp2)
						)
						(else
							(Random temp2 temp1)
						)
					)
				)
				(= temp4
					(if local7
						(- local13 5)
					else
						(Random (+ local13 local3) (+ local14 (/ local3 2)))
					)
				)
				(register
					posn: (if (== client fenR) 158 else 137) 121
					cel: 0
					setLoop: 2
					yStep: 6
					setPri: 13
					show:
					cycleSpeed: local4
					moveSpeed: local4
					setCycle: End
					setMotion: MoveTo temp3 temp4 self
				)
			)
			(5
				(= temp5 (Max 4 (- (- 16 (* global125 2)) local15)))
				(thudSound play:)
				(if
					(and
						(not local8)
						(not local10)
						(<=
							(- (robin x:) temp5)
							(register x:)
							(+ (robin x:) temp5)
						)
						(<= (register y:) local13)
					)
					(= local10 1)
					(if (not local7)
						(gMouseDownHandler delete: gCurRoom)
						(gDirectionHandler delete: gCurRoom)
					)
					(fallSound play:)
					(robin setScript: fallOut)
				)
				(if (not local10)
					(if (== client fenR)
						(fenL setScript: (throwRock new:) 0 rockL)
					else
						(fenR setScript: (throwRock new:) 0 rockR)
					)
					(if
						(>
							(+
								(Abs (- (robin x:) (register x:)))
								(Abs (- (robin y:) (register y:)))
							)
							local6
						)
						(++ local15)
					)
					(if (> local15 9)
						(robin setScript: toTheBoat)
					else
						(robin setLoop: local15)
						(if (<= (robin x:) [local28 local15])
							(robin x: [local28 local15])
						)
						(if (>= (robin x:) [local38 local15])
							(robin x: [local38 local15])
						)
						(localproc_0)
						(localproc_1)
					)
				)
				(= temp0 (Random 0 (if local10 1 else 4)))
				(register
					yStep: 8
					cycleSpeed: 6
					setScript: (rockSpin new:)
					setMotion: MoveTo [local18 temp0] [local23 temp0] self
				)
			)
			(6
				(if (not local10)
					(client
						setMotion: MoveTo (if (== client fenR) 180 else 115) 193
					)
				)
				(splashSound play:)
				(register setScript: 0)
				(= ticks 4)
			)
			(7
				(register setLoop: 6 setPri: 9 setCel: 0 setCycle: End self)
			)
			(8
				(register hide:)
				(self dispose:)
			)
		)
	)
)

(instance rockSpin of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 6)
			)
			(1
				(if (== (= temp0 (client loop:)) 5)
					(= temp0 1)
				)
				(client setLoop: (+ temp0 1))
				(-= state 2)
				(self cue:)
			)
		)
	)
)

(instance fallOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic fade: 0 30 8 1)
				(fallSound number: 931 play:)
				(robin
					cycleSpeed: 3
					moveSpeed: 3
					setLoop: 10
					yStep: 5
					y: (- 88 (* local15 5))
					setCel: local15
					setCycle: CT 10 1 self
					setMotion: MoveTo 144 38
				)
				(if (not local7)
					(boat setScript: 0 setCycle: End)
				)
			)
			(1
				(drownSound play:)
				(= gDeathNum 38)
				(robin setCycle: End self)
			)
			(2
				(= ticks 180)
			)
			(3
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance toTheBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local10 1)
				(= local8 1)
				(gMouseDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(robin cycleSpeed: 12 moveSpeed: 12)
				(if (<= local15 9)
					(robin
						setLoop: 0
						setCel: local15
						setMotion: MoveTo 149 88
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(robin setLoop: 9 setCycle: Fwd setMotion: MoveTo 155 88 self)
				(boat setScript: 0 setCycle: End)
			)
			(2
				(robin hide:)
				(boat setCel: 0 setLoop: 7 setCycle: End self)
			)
			(3
				(boat
					setLoop: 9
					posn: 184 50
					setCycle: Fwd
					setMotion: MoveTo 115 12 self
				)
				(= ticks 60)
			)
			(4
				(SetMessageColor 29)
				(Say 1710 1 self 80 {Monk} 67 -1 75) ; "To the boats, brothers! If they reach the shore, all is lost!"
			)
			(5)
			(6
				(boat dispose:)
				(SetMessageColor 0)
				(fenL dispose:)
				(fenR dispose:)
				(rockL dispose:)
				(rockR dispose:)
				(gCurRoom drawPic: 803 -32762)
				(if (not local11)
					(SetScore 100)
				)
				(= ticks 60)
			)
			(7
				(gRgnMusic fade: 70 30 8 0)
				(Say 1710 2 self) ; "The Monks were no match for two strong and desperate men. Once within the dark shelter of the forest, it was easy to leave them behind. The Queen's Knight was fed, clothed and his wounds treated in our camp. But as soon as he was rested, he set forth with all the ransom we had to give him."
			)
			(8
				(gCurRoom newRoom: 9)
			)
		)
	)
)

(instance cmonRobin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= ticks (client cycleSpeed:))
			)
			(2
				(client cel: 0)
				(= ticks (Random 90 240))
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance splashSound of Sound
	(properties
		flags 1
		number 928
	)
)

(instance thudSound of Sound
	(properties
		flags 1
		number 929
	)
)

(instance fallSound of Sound
	(properties
		flags 1
		number 915
	)
)

(instance drownSound of Sound
	(properties
		flags 1
		number 930
	)
)

