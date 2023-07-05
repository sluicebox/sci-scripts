;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4010)
(include sci.sh)
(use Main)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4010 0
)

(instance s1_4010 of PQRoom
	(properties
		picture 4010
	)

	(method (init)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 4340) ; s1_4340
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(self setScript: lucyIsCaptured)
			)
			((== gPrevRoomNum 4020) ; s1_4020
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(cond
					((IsFlag 156)
						(self setScript: twoGrabEgoMP5)
					)
					((IsFlag 157)
						(self setScript: twoGrabEgoC45)
					)
					((global112 flashBanged:)
						(global112 resetData: 0)
						(self setScript: twoGrabEgoMP5)
					)
					((IsFlag 158)
						(self setScript: twoGrabEgoC45)
					)
					((IsFlag 159)
						(self setScript: twoGrabEgoMP5)
					)
					(else
						(self setScript: twoGrabEgoMP5)
					)
				)
			)
			((OneOf gPrevRoomNum 4030 4270 4280 4290) ; s1_4030, s1_4270, s1_4280, s1_4290
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(cond
					((IsFlag 156)
						(self setScript: twoGrabLaterMP5)
					)
					((IsFlag 157)
						(self setScript: twoGrabLaterC45)
					)
					(else
						(self setScript: twoGrabLaterMP5)
					)
				)
			)
			(else
				(self setScript: officersLineUp)
			)
		)
	)
)

(instance officersLineUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 40103)
				(Lock rsAUDIO 40103 1)
				(gBackMusic number: 40103 loop: -1 play:)
				(linedUpGuys init: setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 4020) ; s1_4020
			)
		)
	)
)

(instance twoGrabEgoMP5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoMP5Pulled init: setCycle: End self)
				(cond
					((global112 flashBanged:)
						(denton setPri: 360 init:)
						(guysGotoDoor init:)
					)
					((IsFlag 162)
						(denton init:)
						(guysGotoDoor init:)
					)
					(else
						(guysMinusEgo init:)
					)
				)
			)
			(1
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance twoGrabEgoC45 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoC45Pulled init: setCycle: End self)
				(if (IsFlag 162)
					(denton setPri: 360 init:)
					(guysGotoDoor init:)
				else
					(guysMinusEgo init:)
				)
			)
			(1
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance twoGrabLaterMP5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoMP5Pulled cel: 105 init: setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance twoGrabLaterC45 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoC45Pulled cel: 130 init: setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance lucyIsCaptured of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(egoAndLucy setPri: 10 init: setCycle: End)
				(katieRunsToMomma setPri: 500 init: setCycle: End self)
			)
			(1
				(Lock rsAUDIO 6006 0)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance denton of View
	(properties
		x 272
		y 269
		view 40106
	)
)

(instance guysGotoDoor of View
	(properties
		x 371
		y 264
		view 40106
		loop 1
	)
)

(instance guysMinusEgo of View
	(properties
		x 464
		y 272
		view 40106
		loop 2
	)
)

(instance egoAndLucy of Prop
	(properties
		x 186
		y 270
		view 40104
	)
)

(instance katieRunsToMomma of Prop
	(properties
		x 480
		y 360
		view 40105
	)
)

(instance linedUpGuys of Prop
	(properties
		x 629
		y 268
		view 40100
	)
)

(instance egoMP5Pulled of Prop
	(properties
		x 484
		y 293
		view 40101
	)
)

(instance egoC45Pulled of Prop
	(properties
		x 482
		y 300
		view 40102
	)
)

