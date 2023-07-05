;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4200)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4200 0
)

(instance s1_4200 of PQRoom
	(properties
		picture 4200
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 42000)
		(= global432 myTalkerStopCheck)
		(northE init:)
		(eastE init:)
		(westE init:)
		(southE init:)
		(bathroom init:)
		(Lock rsAUDIO 40105 0)
		(Load rsAUDIO 40106)
		(Lock rsAUDIO 40106 1)
		(gBackMusic number: 0 stop:)
		(gBackMusic number: 40106 loop: -1 play:)
		(UnLoad 141 40105)
		(gGame handsOn:)
		(roomTimer setReal: roomTimer 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotAtRoom)
			)
			(6
				(gCurRoom setScript: shotAtRoom)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(= global432 0)
		(super dispose:)
	)
)

(instance throwFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(roomTimer dispose: delete:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang setPri: 500 init: setCycle: CT 5 1 self)
			)
			(1
				(flashBang setPri: -1 setCycle: End self)
			)
			(2
				(gFxSound number: 1002 setLoop: 1 play:)
				(flash setPri: 1 init:)
				(= cycles 2)
			)
			(3
				(flash dispose:)
				(gMessager say: 0 16 0 0 self) ; "NO!!!"
			)
			(4
				(global112 threwFlash: 4210)
				(gCurRoom newRoom: 4210) ; s1_4210
			)
		)
	)
)

(instance shotAtRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 8 0 1 self 4210) ; "Cease fire!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(2
				(gGame handsOff: showCloseUp: 41002 180 70 self)
			)
			(3
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40106)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shotBathroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 8 3 0 self) ; "Cease fire!"
			)
			(1
				(SetFlag 155)
				(gCurRoom newRoom: 4210) ; s1_4210
			)
		)
	)
)

(instance pacmeyerStares of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: saveRobot: 1 showCloseUp: 41003 180 70 self)
			)
			(1
				(gGame saveRobot: 0 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flash of View
	(properties
		x 226
		view 42000
	)
)

(instance flashBang of Prop
	(properties
		x 196
		y 279
		view 42002
	)
)

(instance bathroom of Feature
	(properties
		nsLeft 225
		nsRight 380
		nsBottom 360
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotBathroom)
			)
			(6
				(gCurRoom setScript: shotBathroom)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 4210) ; s1_4210
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 310
		nsRight 420
		nsBottom 360
		type 8194
	)

	(method (doVerb)
		(global112 slicePie: 4210)
		(gCurRoom newRoom: 4210) ; s1_4210
	)
)

(instance westE of HotSpot
	(properties
		nsLeft 180
		nsRight 300
		nsBottom 360
		type 32770
	)

	(method (doVerb)
		(global112 slicePie: 4220)
		(gCurRoom newRoom: 4220) ; s1_4220
	)
)

(instance southE of HotSpot
	(properties
		nsTop 310
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(gCurRoom setScript: pacmeyerStares)
	)
)

(instance roomTimer of Timer
	(properties)

	(method (doit)
		(if (not (gTalkers size:))
			(super doit:)
		)
	)

	(method (cue)
		(gMessager say: 0 0 2) ; "Lucy?! It's the police! Lucy, are you in here? Lucy!"
		(self setReal: self 20)
	)
)

(instance myTalkerStopCheck of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

