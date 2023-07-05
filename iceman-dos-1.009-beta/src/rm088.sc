;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm088 0
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
	[local14 11]
)

(class fooHelp of Code
	(properties
		vX_c 0
		vY_c 0
		nX_c 0
		jX_c 0
		jY_c 0
		work_c 0
		vanLoop_c 0
		vanSpeed_c 0
		vanStatus_c 0
		jeepStatus_c 0
		chopperStatus_c 0
		turnVar_c 0
		gameStatus_c 0
		turnSpeed_c 0
	)

	(method (doit)
		(= vX_c local0)
		(= vY_c local1)
		(= nX_c local2)
		(= jX_c local3)
		(= jY_c local4)
		(= work_c local5)
		(= vanLoop_c local6)
		(= vanSpeed_c local7)
		(= vanStatus_c local8)
		(= jeepStatus_c local9)
		(= chopperStatus_c local10)
		(= turnVar_c local11)
		(= gameStatus_c local12)
		(= turnSpeed_c local13)
	)

	(method (dispose)
		(proc0_3)
		(gIceDirectionHandler delete: self)
		(super dispose: &rest)
	)
)

(instance rm088 of Rm
	(properties
		picture 88
		picAngle 80
	)

	(method (init)
		(Load rsVIEW 88)
		(Load rsVIEW 188)
		(Load rsVIEW 288)
		(Load rsVIEW 388)
		(Load rsVIEW 488)
		(Load rsVIEW 988)
		(Load rsSOUND 69)
		(Load rsSOUND 78)
		(Load rsSOUND 79)
		(Load rsSOUND 20)
		(Load rsPIC 700)
		(super init:)
		(theMeter init:)
		(theNeedle init:)
		(theProp init:)
		(theChopper init:)
		(theVan init:)
		(theJeep init:)
		(self setScript: VanScript)
		(aControls setPri: 15 init:)
		(User canInput: 0 canControl: 0)
	)

	(method (doit)
		(fooHelp doit:)
		(super doit:)
	)
)

(instance VanScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceDirectionHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(< (= local5 (theVan distanceTo: theJeep)) 25)
				(== local8 0)
				(> local9 0)
			)
			(= local8 11)
		)
		(cond
			(
				(and
					(== (theSong prevSignal:) -1)
					(== local8 1)
					(== (VanScript state:) 33)
				)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(VanScript changeState: 34)
			)
			((== (theSong prevSignal:) 15)
				(theSong prevSignal: 0)
				(VanScript changeState: 39)
			)
			((== (theSong prevSignal:) 20)
				(theSong prevSignal: 0)
				(VanScript changeState: 31)
			)
			((== (theSong prevSignal:) 5)
				(theSong prevSignal: 0)
				(switch local9
					(3
						(theJeep view: 288 setLoop: 1)
					)
					(4
						(theJeep view: 288 setLoop: 2)
					)
					(5
						(theJeep view: 288 setLoop: 3)
					)
					(6
						(theJeep view: 288 setLoop: 4)
					)
					(7
						(theJeep view: 288 setLoop: 5)
					)
				)
			)
			((== (theSong prevSignal:) 10)
				(theSong prevSignal: 0)
				(switch local9
					(3
						(theJeep view: 188 setLoop: 1)
					)
					(4
						(theJeep view: 188 setLoop: 2)
					)
					(5
						(theJeep view: 188 setLoop: 3)
					)
					(6
						(theJeep view: 188 setLoop: 4)
					)
					(7
						(theJeep view: 188 setLoop: 5)
					)
				)
			)
			((and (< (theVan y:) 36) (!= local8 18))
				(= local8 1)
			)
			((and (& (theVan onControl:) $2000) (== local8 0))
				(cond
					((< (VanScript state:) 6)
						(= local3 280)
						(= local4 176)
						(= local6 1)
					)
					((< (VanScript state:) 16)
						(= local3 227)
						(= local4 107)
						(= local6 3)
					)
					((< (VanScript state:) 23)
						(= local3 192)
						(= local4 61)
						(= local6 5)
					)
				)
				(if (> local0 (Random 4 7))
					(= local8 16)
					(VanScript changeState: 40)
				)
				(if (!= local11 15)
					(= local8 17)
					(VanScript changeState: 40)
				)
			)
			((and (& (theVan onControl:) $1000) (== local8 0))
				(cond
					((< (VanScript state:) 11)
						(= local3 23)
						(= local4 125)
					)
					((< (VanScript state:) 19)
						(= local3 29)
						(= local4 71)
					)
					((< (VanScript state:) 27)
						(= local3 66)
						(= local4 29)
					)
				)
				(if (> local0 (Random 4 7))
					(= local8 16)
					(VanScript changeState: 37)
				)
				(if (!= local11 14)
					(= local8 17)
					(VanScript changeState: 37)
				)
			)
			((== local8 11)
				(theSong stop:)
				(VanScript changeState: 45)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) $0040) (== local8 0)) ; direction
				(switch (event message:)
					(JOY_UP
						(++ local0)
						(++ local1)
						(theVan setStep: local0 local1)
						(if (> local13 2)
							(-- local13)
						)
					)
					(JOY_DOWN
						(if (> local1 1)
							(-- local1)
						)
						(if (> local0 1)
							(-- local0)
						)
						(++ local13)
						(theVan setStep: local0 local1)
					)
					(JOY_RIGHT
						(= local11 14)
					)
					(JOY_LEFT
						(= local11 15)
					)
				)
				(switch local0
					(1
						(= local2 114)
					)
					(2
						(= local2 123)
					)
					(3
						(= local2 128)
					)
					(4
						(= local2 135)
					)
					(5
						(= local2 140)
					)
					(6
						(= local2 147)
					)
					(7
						(= local2 152)
					)
					(8
						(= local2 159)
					)
					(9
						(= local2 164)
					)
					(10
						(= local2 176)
					)
				)
				(theNeedle setMotion: MoveTo local2 190)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 4)
				(= local1 3)
				(= local13 2)
				(theVan illegalBits: 0 ignoreActors: setStep: local0 local1)
				(theSong number: (proc0_5 69) loop: 1 play:)
				(= cycles 20)
			)
			(1
				(theVan setMotion: MoveTo 98 197 self)
			)
			(2
				(JeepScript cue:)
				(theVan setMotion: MoveTo 218 182 self)
			)
			(3
				(theVan setMotion: MoveTo 269 177 self)
				(aControls setPri: 14)
			)
			(4
				(theVan posn: 281 175 setLoop: 7 setCel: 5)
				(= local8 8)
				(= cycles local13)
			)
			(5
				(theVan posn: 289 171 setCel: 6)
				(= cycles local13)
			)
			(6
				(theVan posn: 279 165 setCel: 7)
				(= cycles local13)
			)
			(7
				(theVan posn: 263 162 setLoop: 1 setCycle: Fwd)
				(= cycles local13)
			)
			(8
				(= local8 0)
				(theVan setMotion: MoveTo 102 139 self)
			)
			(9
				(theVan posn: 76 134 setLoop: 7 setCel: 1)
				(= cycles local13)
			)
			(10
				(theVan posn: 65 129 setCel: 2)
				(= local8 8)
				(= cycles local13)
			)
			(11
				(theVan posn: 76 125 setLoop: 8 setCel: 3)
				(= cycles local13)
			)
			(12
				(= local1 2)
				(theVan
					posn: 96 124
					setLoop: 4
					setCycle: Fwd
					setStep: local0 local1
					setMotion: MoveTo 221 109 self
				)
				(= local8 0)
			)
			(13
				(= local8 8)
				(theVan posn: 234 104 setLoop: 8 setCel: 5)
				(= cycles local13)
			)
			(14
				(theVan posn: 239 100 setCel: 6)
				(= local8 8)
				(= cycles local13)
			)
			(15
				(theVan posn: 230 99 setCel: 7)
				(= local8 8)
				(= cycles local13)
			)
			(16
				(theVan setLoop: 3 setCycle: Fwd setMotion: MoveTo 109 82 self)
				(= local8 0)
			)
			(17
				(= local8 8)
				(theVan posn: 100 82 setLoop: 8 setCel: 1)
				(= cycles local13)
			)
			(18
				(theVan posn: 91 78 setLoop: 8 setCel: 2)
				(= cycles local13)
			)
			(19
				(theVan posn: 104 73 setCel: 3)
				(= cycles local13)
			)
			(20
				(= local1 1)
				(theVan
					setStep: local0 1
					setMotion: MoveTo 187 60 self
					setLoop: 6
					setCycle: Fwd
				)
				(= local8 0)
			)
			(21
				(theVan posn: 191 58 setLoop: 9 setCel: 5)
				(= local8 8)
				(= cycles local13)
			)
			(22
				(theVan posn: 195 56 setCel: 6)
				(= cycles local13)
			)
			(23
				(theVan posn: 192 53 setCel: 7)
				(= cycles local13)
			)
			(24
				(= local8 0)
				(theVan setLoop: 5 setCycle: Fwd setMotion: MoveTo 123 40 self)
			)
			(25
				(theVan setLoop: 9 setCel: 6 posn: 104 35)
				(= local8 8)
				(= cycles local13)
			)
			(26
				(theVan setCel: 3 posn: 120 33)
				(= cycles local13)
			)
			(27
				(theVan posn: 130 33 setLoop: 9 setCel: 4)
				(theNeedle setStep: 10 10 setMotion: MoveTo 114 191)
				(= cycles local13)
			)
			(28
				(theVan
					view: 488
					setLoop: 0
					posn: 134 32
					setMotion: MoveTo 168 32 self
				)
				(= local8 20)
			)
			(29
				(theSong fade:)
				(theVan setCel: 1)
				(= cycles 10)
			)
			(30
				(Print 88 0 #at -1 120 #dispose) ; "After stopping, the three of you hurriedly exit the van and climb into the helicopter."
				(theSong number: (proc0_5 79) loop: 1 play:)
				(theProp
					setPri: 14
					view: 488
					setLoop: 1
					posn: 185 25
					cycleSpeed: 3
					setCycle: End
				)
			)
			(31
				(Print 88 1 #at -1 120 #dispose) ; "Whew!" You think to yourself, "That was a close one!"
				(theChopper
					setPri: 15
					setLoop: 3
					setMotion: MoveTo 211 29 self
					moveSpeed: 1
				)
				(theProp hide:)
			)
			(32
				(theChopper
					setLoop: 4
					setMotion: MoveTo 100 29 self
					setCycle: Fwd
					setStep: 5 5
					moveSpeed: 0
				)
			)
			(33
				(= local8 1)
				(theChopper
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo -20 -20
				)
				(Print 88 2 #at -1 120 #dispose) ; "After narrowly escaping the terrorists, you find yourself safely en-route to the USS Saratoga."
				(gGame changeScore: 5)
			)
			(34
				(= local8 18)
				(theJeep hide:)
				(theVan hide:)
				(theNeedle hide:)
				(aControls hide:)
				(gCurRoom drawPic: 700 8)
				(= cycles 25)
			)
			(35
				(gCurRoom newRoom: 90)
			)
			(36)
			(37
				(if (< (theVan distanceTo: theJeep) 25)
					(= local8 11)
				)
				(theSong number: (proc0_5 78) loop: 1 play:)
				(theVan
					ignoreActors:
					illegalBits: 0
					setStep: 4 4
					setMotion: MoveTo local3 local4 self
				)
				(theNeedle setStep: 10 10 setMotion: MoveTo 114 191)
				(theJeep setScript: 0 setMotion: 0 setCel: 0)
			)
			(38
				(theVan
					setMotion: Jump -10 300
					setCycle: Fwd
					cycleSpeed: 1
					setPri: 1
					setStep: 8 8
				)
			)
			(39
				(ShakeScreen 4 ssUPDOWN)
				(cond
					((== local8 19)
						(EgoDead 988 0 2 88 3) ; "The automatic gun fire from the terrorists has caused the van to go out of control. Next time don't allow them to get so close to you."
					)
					((== local8 17)
						(EgoDead 988 0 2 88 4) ; "Unfortunately you didn't turn RIGHT!"
					)
					(else
						(= local8 1)
						(EgoDead 988 0 2 88 5) ; "Unfortunately the speed of your vehicle was too fast to negotiate the dangerous curves. You might try slowing up just a tad prior to entering the curves."
					)
				)
			)
			(40
				(if (< (theVan distanceTo: theJeep) 25)
					(= local8 19)
				)
				(theVan setMotion: MoveTo local3 local4 self)
			)
			(41
				(theNeedle setStep: 10 10 setMotion: MoveTo 114 191)
				(theVan
					view: 388
					setMotion: MoveTo (+ local3 5) (- local4 1)
					setLoop: local6
					cel: 0
					setCycle: End self
					cycleSpeed: 0
				)
				(theJeep setScript: 0 setMotion: 0 setCel: 0)
			)
			(42
				(ShakeScreen 3 ssLEFTRIGHT)
				(theProp
					view: 388
					setLoop: 0
					cel: 0
					setCycle: End self
					posn: (+ local3 5) (- local4 6)
					setPri: 15
				)
				(theSong number: (proc0_5 20) loop: 1 play:)
			)
			(43
				(theVan setLoop: (+ local6 1) setCycle: Fwd)
				(theProp dispose:)
				(= cycles 10)
			)
			(44
				(if (== local8 19)
					(EgoDead 988 0 1 88 3) ; "The automatic gun fire from the terrorists has caused the van to go out of control. Next time don't allow them to get so close to you."
				)
				(if (== local8 16)
					(EgoDead 988 0 1 88 5) ; "Unfortunately the speed of your vehicle was too fast to negotiate the dangerous curves. You might try slowing up just a tad prior to entering the curves."
				)
				(if (== local8 17)
					(EgoDead 988 0 1 88 6) ; "Unfortunately you didn't turn LEFT!"
				)
			)
			(45
				(= local8 1)
				(theVan setCel: 0 setMotion: 0)
				(theJeep setScript: 0 setMotion: 0 setCel: 0)
				(EgoDead 988 0 0 88 7) ; "The automatic gun fire from the terrorists has ruined your day. Next time don't allow them to get so close to you."
			)
		)
	)
)

(instance JeepScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(theJeep
					view: 188
					setStep: (Random 4 6) (Random 3 5)
					setCycle: Fwd
					moveSpeed: 0
					setMotion: MoveTo 127 191 self
				)
				(= local9 3)
			)
			(2
				(theJeep setMotion: MoveTo 229 182 self)
			)
			(3
				(theJeep
					setStep: (Random 4 6) (Random 3 5)
					setMotion: MoveTo 273 178 self
				)
			)
			(4
				(theJeep view: 188 setLoop: 6 setCel: 5 posn: 283 175)
				(= local9 8)
				(= cycles 2)
			)
			(5
				(theJeep setCel: 6 posn: 289 168)
				(= cycles 2)
			)
			(6
				(theJeep setCel: 7 posn: 279 165)
				(= cycles 2)
			)
			(7
				(theJeep
					setLoop: 2
					posn: 271 163
					setCycle: Fwd
					setStep: (Random 5 6) (Random 4 5)
					setMotion: MoveTo 91 137 self
				)
				(= local9 4)
			)
			(8
				(theJeep view: 188 setLoop: 6 setCel: 1 posn: 75 133)
				(= cycles 2)
				(= local9 8)
			)
			(9
				(theJeep
					setStep: (Random 3 5) (Random 2 4)
					setCel: 2
					posn: 64 127
				)
				(= cycles 2)
			)
			(10
				(theJeep setCel: 3 posn: 75 126)
				(= cycles 2)
			)
			(11
				(theJeep
					setLoop: 3
					setCycle: Fwd
					setStep: (Random 4 6) (Random 3 5)
					setMotion: MoveTo 221 108 self
				)
				(= local9 5)
			)
			(12
				(theJeep view: 188 setLoop: 7 setCel: 5 posn: 231 106)
				(= cycles 2)
				(= local9 8)
			)
			(13
				(theJeep setCel: 6 posn: 239 102)
				(= cycles 2)
			)
			(14
				(theJeep setCel: 7 posn: 231 100)
				(= cycles 2)
			)
			(15
				(theJeep
					setLoop: 2
					setCycle: Fwd
					setStep: (Random 4 6) (Random 3 5)
					setMotion: MoveTo 110 84 self
				)
				(= local9 6)
			)
			(16
				(theJeep view: 188 setLoop: 8 setCel: 1 posn: 96 80)
				(= cycles 2)
				(= local9 8)
			)
			(17
				(theJeep
					setStep: (Random 2 4) (Random 1 3)
					setCel: 2
					posn: 89 76
				)
				(= cycles 2)
			)
			(18
				(theJeep setCel: 3 posn: 105 72)
				(= cycles 2)
			)
			(19
				(theJeep
					setLoop: 5
					setCycle: Fwd
					setStep: (Random 4 6) (Random 3 5)
					setMotion: MoveTo 183 62 self
				)
				(= local9 7)
			)
			(20
				(theJeep view: 188 setLoop: 8 setCel: 5 posn: 193 60)
				(= local9 8)
				(= cycles 4)
			)
			(21
				(theJeep setCel: 6 posn: 200 56)
				(= cycles 4)
			)
			(22
				(theJeep setCel: 7 posn: 194 52)
				(= cycles 4)
			)
			(23
				(theJeep
					setLoop: 4
					setCycle: Fwd
					setStep: 2 2
					setMotion: MoveTo 128 41 self
				)
			)
			(24
				(theJeep setLoop: 8 setCel: 1 posn: 117 39)
				(= cycles 4)
			)
			(25
				(theJeep setCel: 2 posn: 108 35)
				(= cycles 4)
			)
			(26
				(theJeep setCel: 3 posn: 116 34)
				(= cycles 4)
			)
			(27
				(theJeep view: 488 setLoop: 7 setCycle: Fwd posn: 128 32)
			)
			(28
				(theJeep hide:)
			)
		)
	)
)

(instance theProp of Prop
	(properties
		y 1000
		x 1000
		view 388
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
	)
)

(instance theJeep of Act
	(properties
		y 229
		x -20
		view 188
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setLoop: 1
			setScript: JeepScript
		)
	)
)

(instance theMeter of View
	(properties
		y 184
		x 157
		view 88
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 15)
	)
)

(instance theNeedle of Act
	(properties
		y 189
		x 133
		z 10
		view 88
		cel 1
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			illegalBits: 0
			setLoop: 0
			setCel: 1
			setPri: 15
			setStep: 4 4
		)
	)
)

(instance theChopper of Act
	(properties
		view 488
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			posn: 211 37
			illegalBits: 0
			setLoop: 2
			setCycle: Fwd
		)
	)
)

(instance theVan of Act
	(properties
		y 227
		x -7
		view 88
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setLoop: 2
			setCycle: Fwd
			setScript: VanScript
		)
	)
)

(instance aControls of View
	(properties
		y 184
		x 41
		view 488
		loop 9
		signal 16384
	)
)

(instance theSong of Sound
	(properties
		priority 15
	)
)

