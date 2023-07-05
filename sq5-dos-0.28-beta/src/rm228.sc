;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 228)
(include sci.sh)
(use Main)
(use eureka)
(use Interface)
(use Talker)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm228 0
	rogTalker 15
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 0)
	(switch (param1 socketNum:)
		(1
			(if (== local0 fuse1)
				(= temp0 1)
			)
		)
		(2
			(if
				(|
					(| (== local0 fuse2) (== local0 fuse5))
					(== local0 extraFuse)
				)
				(= temp0 1)
			)
		)
		(3
			(if (== local0 fuse3)
				(= temp0 1)
			)
		)
		(4
			(if (== local0 fuse4)
				(= temp0 1)
			)
		)
		(5
			(if
				(|
					(| (== local0 fuse5) (== local0 fuse2))
					(== local0 extraFuse)
				)
				(= temp0 1)
			)
		)
		(6
			(if (== local0 fuse6)
				(= temp0 1)
			)
		)
	)
	(return temp0)
)

(class Fuse of Actor
	(properties
		noun 2
		yStep 15
		view 229
		loop 1
		signal 20497
		xStep 15
		moveSpeed 0
		socket 0
		track 0
		origX 0
		origY 0
		origZ 0
		origPri 0
		origHole 0
	)

	(method (init)
		(super init: &rest)
		(self
			origX: x
			origY: y
			origZ: z
			origPri: priority
			origHole: socket
			setLoop: 1
			setCel: 0
			stopUpd:
			setCycle: 0
		)
	)

	(method (pickup)
		(= local0 self)
		(self startUpd: setPri: 12)
		((gTheIconBar at: 2) cursor: 996)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 996)
		(if socket
			(= local0 0)
			(self posn: 15 (+ 40 (* (fuseList size:) 35)))
			(gEgo show:)
			((gTheIconBar at: 2) cursor: 982)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			(fuseList addToFront: self)
			(switch socket
				(1
					(socket1 occupied: 0)
					(socketList addToFront: socket1)
					(self setScript: sLightsFlicker)
					(gEgo hide:)
				)
				(2
					(if (IsFlag 72)
						(fuseList delete: self)
						(self dispose:)
					)
					(socketList addToFront: socket2)
					(socket2 occupied: 0)
					(gEgo hide:)
				)
				(3
					(gCurRoom drawPic: 512 100)
					(socket3 occupied: 0)
					(gEgo hide:)
					(Display
						{EXIT}
						dsCOORD
						8
						20
						dsFONT
						1605
						dsWIDTH
						30
						dsALIGN
						alCENTER
						dsCOLOR
						global155
					)
					(socketList addToFront: socket3)
				)
				(4
					(socket4 occupied: 0)
					(socketList addToFront: socket4)
					(self setScript: sPowerFailure)
					(gEgo hide:)
				)
				(5
					(socketList addToFront: socket5)
					(socket5 occupied: 0)
					(gEgo hide:)
				)
				(6
					(socket6 occupied: 0)
					(socketList addToFront: socket6)
					(self setScript: sLifeSupport)
					(gEgo hide:)
				)
			)
			(Display {EXIT} dsCOORD 8 20 dsFONT 1605 dsWIDTH 30 dsALIGN alCENTER dsCOLOR global155)
			(= z (= socket 0))
		else
			(gTheIconBar disable: 1)
			(= track 1)
		)
	)

	(method (drop)
		(= track 0)
		(self stopUpd:)
		(if (not local2)
			(gTheIconBar enable: 1)
			((gTheIconBar at: 2) cursor: 982)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		)
		(if socket
			(switch socket
				(1
					(self y: (+ (self y:) 50) z: 50)
					(Palette palSET_INTENSITY 0 255 100)
				)
				(2
					(self y: (+ (self y:) 50) z: 50)
					(if (IsFlag 72)
						(ClearFlag 72)
						(SetFlag 73)
						(SetScore 202 175)
						(eureka puke: 6)
						(badFuse dispose:)
					)
				)
				(3
					(self y: (+ (self y:) 50) z: 50)
					(gCurRoom drawPic: 51 100)
				)
				(5
					(if (IsFlag 95)
						(ClearFlag 95)
					)
					(socket5 occupied: 1)
				)
			)
			(Display {EXIT} dsCOORD 8 20 dsFONT 1605 dsWIDTH 30 dsALIGN alCENTER dsCOLOR global155)
		else
			(local0 setMotion: MoveTo 15 120)
		)
		(= local0 0)
	)

	(method (doit)
		(super doit: &rest)
		(if track
			(self x: (- gMouseX 12) y: (- gMouseY 8))
		)
	)

	(method (cue)
		(if local0
			(self drop:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(local0 drop:)
				else
					(self pickup:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Socket of Feature
	(properties
		socketNum 0
		fusePri 0
		occupied 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and local0 (not occupied))
					(if (localproc_0 self)
						(local0
							setPri: (self fusePri:)
							socket: (self socketNum:)
							track: 0
							setMotion: MoveTo (self x:) (self y:) local0
						)
						(socketList delete: self)
						(fuseList delete: local0)
						(= occupied 1)
					else
						(gMessager say: 4 0 0 1) ; "That fuse doesn't fit there."
					)
				)
			)
			(28 ; Transporter_Fuse
				(if (and (not occupied) (| (== socketNum 2) (== socketNum 5)))
					(socketList delete: self)
					(if (and (== socketNum 2) (IsFlag 72))
						(ClearFlag 72)
						(SetScore 202 175)
						(SetFlag 73)
						(badFuse dispose:)
						(eureka puke: 6)
					)
					(if (and (== socketNum 5) (IsFlag 95))
						(ClearFlag 95)
					)
					(extraFuse
						init:
						x: (self x:)
						y: (self y:)
						z: (self z:)
						socket: (self socketNum:)
						track: 0
						setPri: (self fusePri:)
					)
					(= occupied 1)
					(extraFuse cue:)
					(gEgo put: 4) ; Transporter_Fuse
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fuseList of List
	(properties)
)

(instance socketList of List
	(properties)
)

(instance rm228 of Rm
	(properties
		picture 51
		style 10
	)

	(method (doit)
		(if (GameIsRestarting)
			(Display {EXIT} dsCOORD 8 20 dsFONT 1605 dsWIDTH 30 dsALIGN alCENTER dsCOLOR global155)
		)
		(super doit: &rest)
	)

	(method (init &tmp temp0)
		(gCurRoom setRegions: 210) ; eureka
		(gEgo view: 229 posn: 39 94 setLoop: 0 setCel: 0 init: hide:)
		(fuse1 init:)
		(fuse2 init:)
		(fuse3 init:)
		(fuse4 init:)
		(fuse5 init:)
		(fuse6 init:)
		(socket1 init:)
		(socket2 init:)
		(socket3 init:)
		(socket4 init:)
		(socket5 init:)
		(socket6 init:)
		(schematic init:)
		(fuseList add:)
		(tunnelExit init:)
		(gGame handsOn:)
		(gTheIconBar select: (gTheIconBar at: 2))
		(gGame setCursor: 982)
		(gTheIconBar disable: 0 3 4 5)
		(switch gPrevRoomNum
			(225)
			(else
				(if
					(>=
						(= temp0
							(GetNumber
								{Fuse State: \n\n\n(1) Shorted Fuse \n(2) Fuse is Okay\n}
							)
						)
						0
					)
					(= local1 temp0)
				else
					(= local1 1)
				)
				(switch local1
					(1
						(gEgo get: 4) ; Transporter_Fuse
						(SetFlag 72)
						(SetFlag 60)
					)
					(2
						(ClearFlag 72)
						(SetFlag 60)
						(gEgo get: 4) ; Transporter_Fuse
					)
				)
			)
		)
		(badFuse init:)
		(super init: &rest)
		(Display {EXIT} dsCOORD 8 20 dsFONT 1605 dsWIDTH 30 dsALIGN alCENTER dsCOLOR global155)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(fuseList release: dispose:)
		(socketList release: dispose:)
		(super dispose: &rest)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (= cycles 1))
			)
			(1
				(if (fuseList size:)
					(if (socketList size:)
						(gMessager say: 0 0 0 1 self) ; "Realizing it's not a good idea to interrupt the power to critically important circuits, you replace the fuses in their slots before leaving."
					else
						(= cycles 1)
					)
				else
					(self changeState: 4)
				)
			)
			(2
				(= temp0 (fuseList at: (- (fuseList size:) 1)))
				(if (OneOf (temp0 origHole:) 2 5)
					(if (and (socket2 occupied:) (socket5 occupied:))
						(gEgo get: 4) ; Transporter_Fuse
						(fuseList delete: temp0)
						(temp0 dispose:)
						(gMessager say: 5 0 0 1 self) ; "Thinking it might come in handy later, you put the extra fuse back in your pocket."
					else
						(switch (temp0 origHole:)
							(2
								(if (socket2 occupied:)
									(temp0
										origX: (fuse5 origX:)
										origY: (fuse5 origY:)
										origZ: (fuse5 origZ:)
										origHole: (fuse5 origHole:)
										origPri: (fuse5 origPri:)
									)
									(socket5 occupied: 1)
								else
									(socket2 occupied: 1)
								)
							)
							(5
								(if (socket5 occupied:)
									(temp0
										origX: (fuse2 origX:)
										origY: (fuse2 origY:)
										origZ: (fuse2 origZ:)
										origHole: (fuse2 origHole:)
										origPri: (fuse2 origPri:)
									)
									(socket2 occupied: 1)
								else
									(socket5 occupied: 1)
								)
							)
						)
						(temp0
							x: (temp0 origX:)
							y: (- (temp0 origY:) (temp0 origZ:))
							socket: (temp0 origHole:)
							setPri: (temp0 origPri:)
						)
						(temp0 drop:)
						(fuseList delete: temp0)
						(= seconds 1)
					)
				else
					(temp0
						x: (temp0 origX:)
						y: (- (temp0 origY:) (temp0 origZ:))
						socket: (temp0 origHole:)
						setPri: (temp0 origPri:)
					)
					(temp0 drop:)
					(fuseList delete: temp0)
					(= seconds 1)
				)
			)
			(3
				(if (fuseList size:)
					(-= state 2)
				)
				(= cycles 1)
			)
			(4
				(if (not (socket2 occupied:))
					(if (not (IsFlag 72))
						(gMessager say: 4 0 1 1 self) ; "Realizing you've left a good fuse in the wrong socket, you correct your mistake."
						(fuse5 dispose:)
						(socket5 occupied: 0)
					else
						(= cycles 1)
					)
					(fuse2 init:)
				else
					(= cycles 1)
				)
			)
			(5
				(if (not (socket5 occupied:))
					(SetFlag 95)
				)
				(= cycles 1)
			)
			(6
				(gCurRoom newRoom: 225)
				(self dispose:)
			)
		)
	)
)

(instance sLightsFlicker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(for ((= register 100)) (>= register 40) ((-= register 20))
					(Palette palSET_INTENSITY 0 255 register)
				)
			)
			(2
				(gEgo hide:)
				(= seconds 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sPowerFailure of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 996)
				(for ((= register 100)) (>= register 0) ((-= register 20))
					(Palette palSET_INTENSITY 0 5 register)
					(Palette palSET_INTENSITY 7 255 register)
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 3 0 0 1 self) ; "Oops!"
			)
			(2
				(gCurRoom drawPic: 0)
				(EgoDead 4) ; "Don't blow a fuse next time."
				(self dispose:)
			)
		)
	)
)

(instance sLifeSupport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 996)
				(EgoDead 5) ; "You really blew a fuse that time."
				(self dispose:)
			)
		)
	)
)

(instance fuse1 of Fuse
	(properties
		x 121
		y 98
		z 50
		priority 8
		socket 1
	)
)

(instance fuse2 of Fuse
	(properties
		x 152
		y 97
		z 50
		priority 8
		socket 2
	)

	(method (init)
		(self x: 152 y: 97 z: 50 setPri: 8 socket: 2)
		(super init: &rest)
	)
)

(instance fuse3 of Fuse
	(properties
		x 188
		y 96
		z 50
		priority 8
		socket 3
	)
)

(instance fuse4 of Fuse
	(properties
		x 131
		y 57
		priority 5
		socket 4
	)
)

(instance fuse5 of Fuse
	(properties
		x 160
		y 58
		priority 5
		socket 5
	)

	(method (init)
		(self x: 160 y: 58 z: 0 setPri: 5 socket: 5)
		(super init: &rest)
		(if (IsFlag 95)
			(self hide:)
		)
	)
)

(instance fuse6 of Fuse
	(properties
		x 193
		y 57
		priority 5
		socket 6
	)
)

(instance extraFuse of Fuse
	(properties
		x 152
		y 97
		z 50
		priority 8
		socket 2
	)
)

(instance socket1 of Socket
	(properties
		x 121
		y 48
		nsTop 30
		nsLeft 118
		nsBottom 56
		nsRight 151
		socketNum 1
		fusePri 8
	)
)

(instance socket2 of Socket
	(properties
		x 152
		y 47
		nsTop 32
		nsLeft 153
		nsBottom 56
		nsRight 182
		socketNum 2
		fusePri 8
	)
)

(instance socket3 of Socket
	(properties
		x 188
		y 46
		nsTop 30
		nsLeft 187
		nsBottom 56
		nsRight 216
		socketNum 3
		fusePri 8
	)
)

(instance socket4 of Socket
	(properties
		x 131
		y 57
		nsTop 57
		nsLeft 133
		nsBottom 79
		nsRight 159
		socketNum 4
		fusePri 5
	)
)

(instance socket5 of Socket
	(properties
		x 160
		y 58
		nsTop 57
		nsLeft 160
		nsBottom 89
		nsRight 195
		socketNum 5
		fusePri 5
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 95)
			(self occupied: 0)
		)
	)
)

(instance socket6 of Socket
	(properties
		x 193
		y 57
		nsTop 57
		nsLeft 196
		nsBottom 89
		nsRight 240
		socketNum 6
		fusePri 5
	)
)

(instance badFuse of View
	(properties
		x 181
		y 96
		view 229
		loop 2
		priority 4
		signal 16401
	)

	(method (init)
		(if (IsFlag 72)
			(super init: &rest)
		)
	)
)

(instance schematic of Feature
	(properties
		x 180
		y 104
		nsTop 91
		nsLeft 151
		nsBottom 118
		nsRight 210
		sightAngle 40
		approachX 180
		approachY 104
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1 ; Look
				(cond
					((InRect 151 103 171 112 gMouseX gMouseY)
						(= temp0 1)
					)
					((InRect 173 103 191 112 gMouseX gMouseY)
						(= temp0 2)
					)
					((InRect 192 103 210 112 gMouseX gMouseY)
						(= temp0 3)
					)
					((InRect 151 118 171 126 gMouseX gMouseY)
						(= temp0 4)
					)
					((InRect 173 118 191 126 gMouseX gMouseY)
						(= temp0 5)
					)
					((InRect 192 118 210 126 gMouseX gMouseY)
						(= temp0 6)
					)
				)
				(if temp0
					(gMessager say: 1 0 0 temp0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tunnelExit of Feature
	(properties
		x 10
		y 10
		nsTop 10
		nsBottom 45
		nsRight 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(or
						(fuseList size:)
						(not (socket2 occupied:))
						(not (socket5 occupied:))
					)
					(gGame handsOff:)
					(gCurRoom setScript: sExit)
				else
					(gGame handsOff:)
					(gCurRoom newRoom: 225)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rogTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 122 tailY: 43 xOffset: 10 isBottom: 1)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

