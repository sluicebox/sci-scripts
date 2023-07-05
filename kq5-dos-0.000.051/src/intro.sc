;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	local1
	local2
	local3
)

(instance intro of Rm
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(gGame setSpeed: 3)
		(= global103 1)
		(SetFlag 34 23)
		(if (IsFlag 32)
			(gEgo
				init:
				posn: 46 166
				cycleSpeed: 1
				moveSpeed: 0
				offset: 2
				normal: 1
				view: 2
				setLoop: 0
			)
			(owl view: 760 init: signal: 16384 setLoop: 2)
			(self setScript: sceneEightScript)
		else
			(Load rsFONT 8)
			(proc0_24 132 1 24 810)
			(lightning init: hide:)
			(self setScript: sceneOneScript)
		)
		(User canInput: 0 controls: 0)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (not global327)
			(= temp0 (Event new:))
			(if (or (== (temp0 type:) evKEYBOARD) (== (temp0 type:) evMOUSEBUTTON))
				(temp0 dispose:)
				(gGlobalSound stop:)
				(gGame restart:)
			)
			(temp0 dispose:)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo moveSpeed: 0)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sceneOneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lightning init:)
				(gGlobalSound number: 1 loop: -1 playBed:)
				(aCastle init:)
				(mordack init: hide:)
				(= cycles 15)
			)
			(1
				(= local1 (Display 100 0 dsCOORD 80 100 dsWIDTH 300 dsFONT 8 dsCOLOR 0)) ; "CASTLE DAVENTRY"
				(= local0 (Display 100 0 dsCOORD 79 99 dsWIDTH 300 dsFONT 8 dsCOLOR 7)) ; "CASTLE DAVENTRY"
				(= cycles 1)
			)
			(2
				(if (< (gGlobalSound prevSignal:) 4)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(DrawPic 68 18 0)
				(= cycles 1)
			)
			(4
				(if (< (gGlobalSound prevSignal:) 5)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(mordack
					show:
					setLoop: 0
					cel: (- (NumCels mordack) 1)
					setCycle: Beg self
				)
			)
			(6
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(mordack setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(mordack setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 1)
			)
			(9
				(mordack setCycle: Beg self)
			)
			(10
				(lightning setScript: myLightning)
				(clouds init: setCycle: Fwd)
				(= cycles 1)
			)
			(11
				(if (< (gGlobalSound prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(12
				(mordack cel: 0 setCycle: End self)
			)
			(13
				(clouds setCycle: End self)
			)
			(14
				(clouds setLoop: 1 setCycle: Fwd cycleSpeed: 2)
				(= seconds 5)
			)
			(15
				(mordack cel: 0 setCycle: End)
				(clouds cycleSpeed: 1)
				(= seconds 5)
			)
			(16
				(mordack setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 1)
			)
			(17
				(mordack setCycle: Beg)
				(= cycles 1)
			)
			(18
				(if (< (gGlobalSound prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(19
				(clouds setLoop: 2 setCycle: End self)
			)
			(20
				(aCastle hide:)
				(clouds setLoop: 3 cycleSpeed: 3 setCycle: End)
				(mordack cel: 0 setLoop: 5 setCycle: End self)
			)
			(21
				(clouds dispose:)
				(mordack setCycle: Beg)
				(= cycles 1)
			)
			(22
				(if (< (gGlobalSound prevSignal:) 40)
					(-- state)
				)
				(= cycles 1)
			)
			(23
				(mordack setLoop: 0 cel: 0 setCycle: End self)
			)
			(24
				(gCurRoom newRoom: 101) ; intro2
			)
		)
	)
)

(instance myLightning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local2)
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gGlobalSound3 number: 810 loop: 1 play:)
				(lightning show: cel: 0 setLoop: 5 setCycle: End self)
			)
			(2
				(lightning hide:)
				(switch local2
					(0
						(= seconds 4)
					)
					(1
						(= seconds 2)
					)
					(2
						(= seconds 1)
					)
					(3
						(= seconds 3)
					)
				)
			)
			(3
				(if (== local2 3)
					(self dispose:)
				else
					(++ local2)
					(self init:)
				)
			)
		)
	)
)

(instance mordack of Prop
	(properties
		y 176
		x 230
		view 754
		signal 16384
		cycleSpeed 2
	)
)

(instance aCastle of Prop
	(properties
		y 77
		x 157
		view 755
		loop 4
		signal 16384
	)
)

(instance clouds of Prop
	(properties
		y 86
		x 157
		view 755
		cycleSpeed 3
	)
)

(instance lightning of Prop
	(properties
		y 77
		x 157
		view 755
		loop 5
		signal 16384
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(self setPri: (+ (aCastle priority:) 1))
	)
)

(instance sceneEightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound number: 11 loop: -1 playBed:)
				(PrintDC 100 1 #at 10 10 #dispose) ; "Come on! Up here!"
				(owl posn: 63 97 setCycle: Fwd setMotion: MoveTo 226 67 self)
				(= seconds 2)
			)
			(2
				(gEgo setScript: egoFlying)
			)
			(3
				(cls)
				(owl setCycle: End self)
			)
			(4
				(owl setLoop: 3 setCycle: End self)
			)
			(5
				(owl setLoop: 4 setCycle: Fwd setMotion: MoveTo 181 35)
				(= cycles 1)
			)
			(6
				(PrintDC 100 2 #at 10 10 #dispose) ; "Follow meeeeee...!"
				(owl setLoop: 5 setCycle: End)
				(= seconds 4)
			)
			(7
				(cls)
				(owl dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoFlying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					signal: 16384
					view: 750
					setLoop: 0
					illegalBits: 0
					setPri: 5
					normal: 0
					setCycle: Fwd
					setMotion: MoveTo 249 90 self
				)
				((gEgo head:) hide:)
			)
			(1
				(gEgo cel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo
					cel: 0
					setLoop: 9
					posn: (- (gEgo x:) 0) (- (gEgo y:) 7)
					setMotion: MoveTo 181 35
					setCycle: End self
				)
			)
			(3
				(gEgo
					cel: 0
					setLoop: 2
					setCycle: End self
					setMotion: MoveTo 181 35
				)
			)
			(4
				(gCurRoom newRoom: 106) ; intro7
			)
		)
	)
)

(instance owl of Act
	(properties
		cycleSpeed 2
	)
)

