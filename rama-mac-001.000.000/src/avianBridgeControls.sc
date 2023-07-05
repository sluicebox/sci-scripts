;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6009)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Feature)
(use Sound)
(use System)

(public
	avianBridgeControls 0
)

(local
	local0
	[local1 15] = [6005 6094 6010 6024 6095 6029 6044 6092 6090 6093 6091 6049 6064 6096 6069]
)

(instance avianBridgeControls of CloseupLocation
	(properties
		noun 5
		heading 135
	)

	(method (init)
		(Load rsAUDIO 6000)
		(switch gPrevRoomNum
			(6001 ; avianLeftShaft1
				(if (IsFlag 139)
					(= local0 1)
				else
					(= local0 0)
				)
			)
			(6003 ; avianLeftShaft2
				(if (IsFlag 140)
					(= local0 4)
				else
					(= local0 3)
				)
			)
			(6005 ; avianLeftShaft3
				(cond
					((IsFlag 137)
						(= noun 0)
						(= local0 10)
					)
					((IsFlag 136)
						(if (IsFlag 138)
							(= noun 0)
							(= local0 9)
						else
							(= local0 8)
						)
					)
					((IsFlag 138)
						(= noun 0)
						(= local0 7)
					)
					(else
						(= local0 6)
					)
				)
			)
			(6007 ; avianLeftShaft4
				(if (IsFlag 141)
					(= local0 13)
				else
					(= local0 12)
				)
			)
			(6002 ; avianRightShaft1
				(= local0 2)
			)
			(6004 ; avianRightShaft2
				(= local0 5)
			)
			(6006 ; avianRightShaft3
				(= local0 11)
			)
			(6008 ; avianRightShaft4
				(= local0 14)
			)
		)
		(super init: [local1 local0])
		(if (OneOf local0 2 5 11 14)
			(rightManualControls init:)
			(rightAutoButtons init:)
		else
			(leftManualControls init:)
			(leftAutoButtons init:)
		)
	)
)

(class ManualControls of Feature
	(properties)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(if (not (OneOf local0 2 5 11 14))
			(self setHotspot: 2 15)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(switch local0
					(9
						(SetFlag 137)
						(= local0 10)
						(control3_4_Turn play:)
						(self deleteHotspot: 2)
					)
					(7
						(SetFlag 137)
						(= local0 10)
						(controlFullTurn play:)
						(self deleteHotspot: 2)
					)
					(6
						(SetFlag 136)
						(= local0 8)
						(control1_4_Turn play:)
						(proc1111_31 43 15)
					)
				)
			)
			(15
				(switch local0
					(0
						(SetFlag 139)
						(= local0 1)
						(self deleteHotspot: 15)
						(oilControl1 play:)
					)
					(3
						(SetFlag 140)
						(self deleteHotspot: 15)
						(= local0 4)
						(oilControl2 play:)
					)
					(6
						(gCurRoom noun: 0)
						((proc70_6 35) verb: 152)
						(SetFlag 138)
						(self deleteHotspot: 15)
						(= local0 7)
						(oilControl3 play:)
						(self setHotspot: 2)
					)
					(8
						(gCurRoom noun: 0)
						((proc70_6 35) verb: 152)
						(SetFlag 138)
						(self deleteHotspot: 15)
						(= local0 9)
						(oilTurnedControl3 play:)
						(self setHotspot: 2)
					)
					(12
						(SetFlag 141)
						(self deleteHotspot: 15)
						(= local0 13)
						(oilControl4 play:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class AutoButtons of Feature
	(properties)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(if (!= local0 10)
			(self setHotspot: 2 144)
		else
			(self setHotspot: 144)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(motorStraining play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftManualControls of ManualControls
	(properties
		nsLeft 224
		nsTop 154
		nsRight 368
		nsBottom 224
	)
)

(instance leftAutoButtons of AutoButtons
	(properties
		nsLeft 384
		nsTop 79
		nsRight 431
		nsBottom 100
	)
)

(instance rightManualControls of ManualControls
	(properties
		nsLeft 215
		nsTop 151
		nsRight 362
		nsBottom 220
	)
)

(instance rightAutoButtons of AutoButtons
	(properties
		nsLeft 159
		nsTop 75
		nsRight 223
		nsBottom 116
	)
)

(instance controlFullTurn of VMDMovie
	(properties
		movieName 6033
		begPic 6092
		endPic 6091
	)
)

(instance control1_4_Turn of VMDMovie
	(properties
		movieName 6032
		begPic 6044
		endPic 6090
	)
)

(instance control3_4_Turn of VMDMovie
	(properties
		movieName 6034
		begPic 6093
		endPic 6091
	)
)

(instance oilControl1 of VMDMovie
	(properties
		movieName 6010
		endPic 6094
	)
)

(instance oilControl2 of VMDMovie
	(properties
		movieName 6020
		endPic 6095
	)
)

(instance oilControl4 of VMDMovie
	(properties
		movieName 6040
		endPic 6096
	)
)

(instance oilControl3 of VMDMovie
	(properties
		movieName 6030
		begPic 6044
		endPic 6092
	)
)

(instance oilTurnedControl3 of VMDMovie
	(properties
		movieName 6031
		begPic 6090
		endPic 6093
	)
)

(instance motorStraining of Sound
	(properties
		number 6000
	)
)

