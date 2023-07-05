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
	local14
	local15
	local16
	[local17 12]
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
		(Load rsPIC 99)
		(super init:)
		(theMeter init:)
		(theNeedle init:)
		(theProp init: stopUpd:)
		(theChopper init:)
		(theVan init:)
		(theJeep init:)
		(self setScript: VanScript)
		(aControls setPri: 15 init:)
		(User canInput: 0 canControl: 1 blocks: 1)
	)
)

(instance VanScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceDirectionHandler add: self)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: self)
		(gIceDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(= local8 (theVan distanceTo: theJeep))
		(if (and (or (== local1 8) (== local1 0)) (< local8 25) (> local11 0))
			(= local1 11)
		)
		(cond
			(
				(and
					(== (theSong prevSignal:) -1)
					(== local1 1)
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
				(switch local11
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
				(switch local11
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
			((and (< (theVan y:) 36) (!= local1 18))
				(= local1 1)
			)
			((and (& (theVan onControl:) $2000) (== local1 0))
				(cond
					((< (VanScript state:) 6)
						(= local2 280)
						(= local3 176)
						(= local9 1)
						(= local4 3)
					)
					((< (VanScript state:) 16)
						(= local2 227)
						(= local3 107)
						(= local9 3)
						(= local4 4)
					)
					((< (VanScript state:) 23)
						(= local2 192)
						(= local3 61)
						(= local9 5)
						(= local4 5)
					)
				)
				(if (> local0 (Random 4 7))
					(= local1 16)
					(VanScript changeState: 40)
				)
				(if (!= local13 15)
					(= local1 17)
					(VanScript changeState: 40)
				)
			)
			((and (& (theVan onControl:) $1000) (== local1 0))
				(cond
					((< (VanScript state:) 11)
						(= local2 23)
						(= local3 125)
					)
					((< (VanScript state:) 19)
						(= local2 29)
						(= local3 71)
					)
					((< (VanScript state:) 27)
						(= local2 66)
						(= local3 29)
					)
				)
				(if (> local0 (Random 4 7))
					(= local1 16)
					(VanScript changeState: 37)
				)
				(if (!= local13 14)
					(= local1 17)
					(VanScript changeState: 37)
				)
			)
			((== local1 11)
				(theSong stop:)
				(VanScript changeState: 45)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F8))
				(theSong dispose:)
				(theJeep setScript: 0 setMotion: 0)
				(theVan setScript: 0 setMotion: 0)
				(= local16 1)
				(VanScript changeState: 34)
			)
			((and (== (event type:) $0040) (== local1 0)) ; direction
				(switch (event message:)
					(JOY_UP
						(++ local0)
						(++ local6)
						(theVan setStep: local0 local6)
						(if (> local15 2)
							(-- local15)
						)
					)
					(JOY_DOWN
						(if (> local6 1)
							(-- local6)
						)
						(if (> local0 1)
							(-- local0)
						)
						(++ local15)
						(theVan setStep: local0 local6)
					)
					(JOY_RIGHT
						(= local13 14)
					)
					(JOY_LEFT
						(= local13 15)
					)
				)
				(switch local0
					(1
						(= local7 114)
					)
					(2
						(= local7 123)
					)
					(3
						(= local7 128)
					)
					(4
						(= local7 135)
					)
					(5
						(= local7 140)
					)
					(6
						(= local7 147)
					)
					(7
						(= local7 152)
					)
					(8
						(= local7 159)
					)
					(9
						(= local7 164)
					)
					(10
						(= local7 176)
					)
				)
				(theNeedle setMotion: MoveTo local7 190)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 4)
				(= local6 3)
				(= local15 2)
				(theVan illegalBits: 0 ignoreActors: setStep: local0 local6)
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
				(= local1 8)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(5
				(theVan posn: 289 171 setCel: 6)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(6
				(theVan posn: 279 165 setCel: 7)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(7
				(theVan posn: 263 162 setLoop: 1 setCycle: Fwd)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(8
				(= local1 0)
				(theVan setMotion: MoveTo 102 139 self)
			)
			(9
				(theVan posn: 76 134 setLoop: 7 setCel: 1)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(10
				(theVan posn: 65 129 setCel: 2)
				(= local1 8)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(11
				(theVan posn: 76 125 setLoop: 8 setCel: 3)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(12
				(= local6 2)
				(theVan
					posn: 96 124
					setLoop: 4
					setCycle: Fwd
					setStep: local0 local6
					setMotion: MoveTo 221 109 self
				)
				(= local1 0)
			)
			(13
				(= local1 8)
				(theVan posn: 234 104 setLoop: 8 setCel: 5)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(14
				(theVan posn: 239 100 setCel: 6)
				(= local1 8)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(15
				(theVan posn: 230 99 setCel: 7)
				(= local1 8)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(16
				(theVan setLoop: 3 setCycle: Fwd setMotion: MoveTo 109 82 self)
				(= local1 0)
			)
			(17
				(= local1 8)
				(theVan posn: 100 82 setLoop: 8 setCel: 1)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(18
				(theVan posn: 91 78 setLoop: 8 setCel: 2)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(19
				(theVan posn: 104 73 setCel: 3)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(20
				(= local6 1)
				(theVan
					setStep: local0 1
					setMotion: MoveTo 187 60 self
					setLoop: 6
					setCycle: Fwd
				)
				(= local1 0)
			)
			(21
				(theVan posn: 191 58 setLoop: 9 setCel: 5)
				(= local1 8)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(22
				(theVan posn: 195 56 setCel: 6)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(23
				(theVan posn: 192 53 setCel: 7)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(24
				(= local1 0)
				(theVan setLoop: 5 setCycle: Fwd setMotion: MoveTo 123 40 self)
			)
			(25
				(theVan setLoop: 9 setCel: 6 posn: 104 35)
				(= local1 8)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(26
				(theVan setCel: 3 posn: 120 33)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(27
				(theVan posn: 130 33 setLoop: 9 setCel: 4)
				(theNeedle setStep: 10 10 setMotion: MoveTo 114 191)
				(if global132
					(= cycles local15)
				else
					(= cycles 1)
				)
			)
			(28
				(theVan
					view: 488
					setLoop: 0
					posn: 134 32
					setMotion: MoveTo 168 32 self
				)
				(= local1 20)
			)
			(29
				(theSong fade:)
				(theVan setCel: 1)
				(if global132
					(= cycles 10)
				else
					(= cycles 5)
				)
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
				(Print 88 1 #at -1 120 #dispose) ; "Whew," you say as you draw a deep breath, "That was a close one!"
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
				(= local1 1)
				(theChopper
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo -20 -20
				)
				(Print 88 2 #at -1 120 #dispose) ; "After narrowly escaping the terrorists, you find yourself safely enroute to the USS Saratoga."
			)
			(34
				(= local1 18)
				(theJeep hide:)
				(theVan hide:)
				(theNeedle hide:)
				(aControls hide:)
				(proc0_3)
				(User blocks: 0)
				(if (not local16)
					(gGame changeScore: 10)
				else
					(theChopper hide:)
					(theMeter hide:)
					(theProp hide:)
					(gGame changeScore: -10)
				)
				(gCurRoom drawPic: 99 8)
				(= cycles 25)
			)
			(35
				(gCurRoom newRoom: 90)
			)
			(36)
			(37
				(if (< (theVan distanceTo: theJeep) 25)
					(= local1 11)
				)
				(theVan
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo local2 local3 self
				)
				(theNeedle setStep: 10 10 setMotion: MoveTo 114 191)
				(theJeep setScript: 0 setMotion: 0 setCel: 0)
				(= cycles (= seconds 0))
			)
			(38
				(theSong number: (proc0_5 78) loop: 1 play:)
				(switch global132
					(0
						(= local5 20)
					)
					(1
						(= local5 15)
					)
					(2
						(= local5 10)
					)
				)
				(theVan
					setStep: local5 local5
					setMotion: Jump
					setCycle: Fwd
					cycleSpeed: 1
					setPri: 1
				)
			)
			(39
				(ShakeScreen 4 ssUPDOWN)
				(cond
					((== local1 19)
						(EgoDead 988 0 2 88 3) ; "The automatic gun fire from the terrorists has caused the van to go out of control. Next time don't allow them to get so close to you."
					)
					((== local1 17)
						(EgoDead 988 0 2 88 4) ; "Unfortunately you didn't turn RIGHT!"
					)
					(else
						(= local1 1)
						(EgoDead 988 0 2 88 5) ; "Unfortunately the speed of your vehicle was too fast to negotiate the dangerous curves. You might try slowing up just a tad prior to entering the curves."
					)
				)
			)
			(40
				(if (< (theVan distanceTo: theJeep) 25)
					(= local1 19)
				)
				(theVan setMotion: MoveTo local2 local3 self)
			)
			(41
				(theNeedle setStep: 10 10 setMotion: MoveTo 114 191)
				(theVan
					view: 388
					setMotion: MoveTo (+ local2 5) (- local3 1)
					setLoop: local9
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
					posn: (+ local2 5) (- local3 6)
					setPri: 15
				)
				(theSong number: (proc0_5 20) loop: 1 play:)
			)
			(43
				(theVan setLoop: (+ local9 1) setCycle: Fwd)
				(theProp dispose:)
				(= cycles 10)
			)
			(44
				(if (== local1 19)
					(EgoDead 988 0 1 88 3) ; "The automatic gun fire from the terrorists has caused the van to go out of control. Next time don't allow them to get so close to you."
				)
				(if (== local1 16)
					(EgoDead 988 0 1 88 5) ; "Unfortunately the speed of your vehicle was too fast to negotiate the dangerous curves. You might try slowing up just a tad prior to entering the curves."
				)
				(if (== local1 17)
					(EgoDead 988 0 1 88 6) ; "Unfortunately you didn't turn LEFT!"
				)
			)
			(45
				(= local1 1)
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
				(= local11 3)
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
				(= local11 8)
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
				(= local11 4)
			)
			(8
				(theJeep view: 188 setLoop: 6 setCel: 1 posn: 75 133)
				(= cycles 2)
				(= local11 8)
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
				(= local11 5)
			)
			(12
				(theJeep view: 188 setLoop: 7 setCel: 5 posn: 231 106)
				(= cycles 2)
				(= local11 8)
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
				(= local11 6)
			)
			(16
				(theJeep view: 188 setLoop: 8 setCel: 1 posn: 96 80)
				(= cycles 2)
				(= local11 8)
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
				(= local11 7)
			)
			(20
				(theJeep view: 188 setLoop: 8 setCel: 5 posn: 193 60)
				(= local11 8)
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

