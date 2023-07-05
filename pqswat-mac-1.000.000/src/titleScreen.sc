;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use SwatFile)
(use Osc)
(use Motion)
(use Actor)
(use System)

(public
	titleScreen 0
)

(instance titleScreen of PQRoom
	(properties
		picture 10
	)

	(method (init)
		(Load rsVIEW 100)
		(Load rsVIEW 102)
		(Load rsVIEW 103)
		(Load rsVIEW 111)
		(Load rsPIC 11)
		(Load rsAUDIO 1002)
		(Load rsAUDIO 1003)
		(Load rsAUDIO 1001)
		(Lock rsAUDIO 1001 1)
		(super init: &rest)
		(self setScript: titleScreenScript)
	)

	(method (newRoom newRoomNumber)
		(Lock rsAUDIO 1001 0)
		(SwatFile writeIt: 2 1)
		(gBackMusic fade: 0 2 21 1)
		(if (!= newRoomNumber 15) ; mainMenu
			(gSwatInterface hideCursor: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance titleScreenScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(tempActor dispose:)
			(proc4_5)
			(gCurRoom newRoom: 15) ; mainMenu
			(return 1)
		else
			(return 0)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gBackMusic number: 1001 loop: -1 play:)
				(= seconds 3)
			)
			(2
				(swatPup1 init: setCycle: End self)
			)
			(3
				(Load rsAUDIO 1002 1101)
				(Load rsVIEW 103 111)
				(swatPup2 init: setCycle: CT 42 1 self)
			)
			(4
				(gFxSound number: 1003 loop: 1 play:)
				(swatPup2 setCycle: End self)
			)
			(5
				(= ticks 1)
				(flash init:)
				(gFxSound number: 1002 loop: 1 play:)
			)
			(6
				(flash cel: 1 setCycle: End self)
				(gBackMusic number: 1101 loop: 1 play:)
			)
			(7
				(Load rsVIEW 112)
				(swatPup2 dispose:)
				(swatPup1 setPri: 200 view: 111 loop: 0 cel: 0 posn: 18 420)
				(flash dispose:)
				(gCurRoom drawPic: 11 0)
				(= cycles 2)
			)
			(8
				(swatPup1 setCycle: End self)
			)
			(9
				(UpdateScreenItem swatPup1)
				(sniperScope
					setLoop: 0 1
					init:
					setPri: 400
					moveSpeed: 4
					setStep: 8 3
					setMotion: MoveTo 390 199 self
				)
			)
			(10
				(sniperScope setCycle: Osc)
				(holdFrame posn: 358 38 setPri: 50 setLoop: 0 cel: 1 init:)
				(= ticks 50)
			)
			(11
				(holdFrame hide:)
				(proc4_6 11 358 38 0 0 1 1)
			)
			(12
				(sniperScope setCycle: 0)
			)
			(13
				(gCurRoom newRoom: 15) ; mainMenu
			)
		)
	)
)

(instance swatPup1 of Prop
	(properties
		x 345
		y 432
		view 100
	)
)

(instance swatPup2 of Prop
	(properties
		x 592
		y 461
		view 102
	)
)

(instance flash of Prop
	(properties
		x 384
		y 415
		priority 500
		fixPriority 1
		view 103
	)
)

(instance sniperScope of Actor
	(properties
		x 640
		y 199
		view 112
		cel 1
	)
)

(instance holdFrame of View
	(properties
		view 113
		loop 1
		cel 1
	)
)

(instance tempActor of Actor
	(properties
		view 10
	)
)

