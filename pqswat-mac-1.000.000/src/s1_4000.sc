;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4000)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use ROsc)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4000 0
	doLash 1
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
)

(procedure (localproc_0 param1 param2)
	(if (== param1 local0)
		(param2 cue:)
	else
		(switch local0
			(0
				(if (== param1 4)
					(egoFromSlot0 dispose:)
					(param2 cue:)
				else
					(host setScript: peelEgoAway0 param2)
				)
			)
			(1
				(host setScript: peelEgoAway1 param2)
			)
			(2
				(host setScript: peelEgoAway2 param2)
			)
			(3
				(host setScript: peelEgoAway3 param2)
			)
			(4
				(host setScript: peelEgoAway4 param2)
			)
		)
	)
)

(instance s1_4000 of PQRoom
	(properties)

	(method (init)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 4010 4310 4320 4330) ; s1_4010, s1_4310, s1_4320, s1_4330
			(if (or (IsFlag 156) (IsFlag 157) (global112 flashBanged:))
				(self drawPic: 0 setScript: getAfterEgo1)
			else
				(self drawPic: 0 setScript: getAfterEgo2)
			)
		else
			(Load rsVIEW 40001)
			(host init: hide:)
			(yellowLine setPri: 500 init:)
			(swatVan init:)
			(dentTelloRhea setCycle: ROsc -1 0 61 init:)
			(neighbor cycleSpeed: 12 setCycle: ROsc -1 0 56 init:)
			(officer1 init:)
			(officer2 setCycle: ROsc -1 0 50 init:)
			(wixell init:)
			(carmichael init:)
			(egoFromSlot0 init:)
			(self drawPic: 4000 setScript: introDiscussion)
		)
	)

	(method (dispose)
		(if (gTimers contains: interactTimer)
			(interactTimer dispose: delete:)
		)
		(if (gTimers contains: briefTimer)
			(briefTimer dispose: delete:)
		)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance doLash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(interactTimer dispose: delete:)
				(gFxSound number: 5 setLoop: 1 play: self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance introDiscussion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKeyDownHandler addToFront: self)
				(WalkieTalkie showFrame: 40001 0 188 136)
				(= global128 40001)
				(= cycles 2)
			)
			(1
				(proc4_6 40001 188 136)
			)
			(2
				(gKeyDownHandler delete: self)
				(pacRookHerbKat setPri: 1 setCycle: ROsc -1 0 15 init:)
				(proc4_5)
				(briefTimer setReal: briefTimer 0 1)
				(interactTimer setReal: interactTimer 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (== (event message:) KEY_SPACE)
				(event claimed: 1)
				(= seconds (= cycles 0))
				(if gAutoRobot
					(proc4_5)
					(= state 1)
				)
				(self cue:)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance getAfterEgo1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 0 stop:)
				(UnLoad 141 40103)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(1
				(gGame showCloseUp: 4021 180 70 self 1)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 113)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance getAfterEgo2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 0 stop:)
				(UnLoad 141 40103)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(1
				(gGame showCloseUp: 4022 180 70 self 1)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 113)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance goToBriefing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(Lock rsAUDIO 40101 0)
				(Load rsAUDIO 40102)
				(Lock rsAUDIO 40102 1)
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40102 loop: -1 play:)
				(UnLoad 141 40101)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 14 1 self) ; "Briefing!"
			)
			(2
				(gCurRoom newRoom: 4051) ; s1_405
			)
		)
	)
)

(instance talkToGroup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 1 self)
			)
			(1
				(proc4_5)
				(cond
					((IsFlag 160)
						(if local2
							(gGame showCloseUp: 4006 180 70 self)
						else
							(= local2 1)
							(gGame showCloseUp: 4005 180 70 self)
						)
					)
					(local2
						(gGame showCloseUp: 4004 180 70 self)
					)
					(else
						(= local2 1)
						(gGame showCloseUp: 4003 180 70 self)
					)
				)
				(if (!= local0 1)
					(pacRookHerbKat dispose:)
					(egoPacRookHerbKat setPri: 1 init:)
					(= local0 1)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToCarmichael of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 4 self)
			)
			(1
				(proc4_5)
				(if local10
					(gGame showCloseUp: 4023 180 70 self)
				else
					(= local10 1)
					(gGame showCloseUp: 4020 180 70 self)
				)
				(if (!= local0 4)
					(egoWixCarm setPri: 1 init:)
					(wixell dispose:)
					(carmichael dispose:)
					(= local0 4)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToWixell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 4 self)
			)
			(1
				(proc4_5)
				(cond
					((> local9 1)
						(gGame showCloseUp: 4036 180 70 self)
					)
					(local9
						(++ local9)
						(gGame showCloseUp: 4035 180 70 self)
					)
					(else
						(++ local9)
						(gGame showCloseUp: 4019 180 70 self)
					)
				)
				(if (!= local0 4)
					(egoWixCarm setPri: 1 init:)
					(wixell dispose:)
					(carmichael dispose:)
					(= local0 4)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToNeighbor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 160)
				(interactTimer dispose: delete:)
				(localproc_0 2 self)
			)
			(1
				(proc4_5)
				(cond
					((> local3 2)
						(gGame showCloseUp: 4026 180 70 self)
					)
					((== local3 2)
						(++ local3)
						(gGame showCloseUp: 4027 180 70 self)
					)
					((== local3 1)
						(++ local3)
						(gGame showCloseUp: 4025 180 70 self)
					)
					(else
						(++ local3)
						(gGame showCloseUp: 4011 180 70 self)
					)
				)
				(if (!= local0 2)
					(neighbor dispose:)
					(officer1 dispose:)
					(officer2 dispose:)
					(egoFromSlot2 cel: 0 init:)
					(= local0 2)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToOfficer1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 2 self)
			)
			(1
				(proc4_5)
				(cond
					((> local4 2)
						(gGame showCloseUp: 4029 180 70 self)
					)
					((== local4 2)
						(++ local4)
						(gGame showCloseUp: 4030 180 70 self)
					)
					((== local4 1)
						(++ local4)
						(gGame showCloseUp: 4028 180 70 self)
					)
					(else
						(++ local4)
						(gGame showCloseUp: 4009 180 70 self)
					)
				)
				(if (!= local0 2)
					(neighbor dispose:)
					(officer1 dispose:)
					(officer2 dispose:)
					(egoFromSlot2 cel: 0 init:)
					(= local0 2)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToOfficer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 2 self)
			)
			(1
				(proc4_5)
				(cond
					((> local5 1)
						(gGame showCloseUp: 4032 180 70 self)
					)
					(local5
						(++ local5)
						(gGame showCloseUp: 4031 180 70 self)
					)
					(else
						(++ local5)
						(gGame showCloseUp: 4010 180 70 self)
					)
				)
				(if (!= local0 2)
					(neighbor dispose:)
					(officer1 dispose:)
					(officer2 dispose:)
					(egoFromSlot2 cel: 0 init:)
					(= local0 2)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToDenton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 3 self)
			)
			(1
				(proc4_5)
				(if local6
					(gGame showCloseUp: 4024 180 70 self)
				else
					(= local6 1)
					(gGame showCloseUp: 4014 180 70 self)
				)
				(if (!= local0 3)
					(dentTelloRhea dispose:)
					(egoFromSlot3 setPri: 1 cel: 0 init:)
					(= local0 3)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToRhea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 3 self)
			)
			(1
				(proc4_5)
				(if local7
					(gGame showCloseUp: 4033 180 70 self)
				else
					(= local7 1)
					(gGame showCloseUp: 4015 180 70 self)
				)
				(if (!= local0 3)
					(dentTelloRhea dispose:)
					(egoFromSlot3 setPri: 1 cel: 0 init:)
					(= local0 3)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToTello of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(interactTimer dispose: delete:)
				(localproc_0 3 self)
			)
			(1
				(proc4_5)
				(if local8
					(gGame showCloseUp: 4034 180 70 self)
				else
					(= local8 1)
					(gGame showCloseUp: 4016 180 70 self)
				)
				(if (!= local0 3)
					(dentTelloRhea dispose:)
					(egoFromSlot3 setPri: 1 cel: 0 init:)
					(= local0 3)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtVan of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local11 1)
				(while ((= temp0 (Event new:)) type:)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(interactTimer dispose: delete:)
				(localproc_0 3 self)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(proc4_5)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 405)
				(greaseBoard init:)
				(vanInt init:)
				(northE init:)
				(eastE init:)
				(westE init:)
				(southE init:)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitVan of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(while ((= temp0 (Event new:)) type:)
					(temp0 dispose:)
				)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(vanInt dispose:)
				(greaseBoard dispose:)
				(northE dispose:)
				(eastE dispose:)
				(westE dispose:)
				(southE dispose:)
				(gCurRoom drawPic: 4000)
				(gCast eachElementDo: #show)
				(if (!= local0 3)
					(dentTelloRhea dispose:)
					(egoFromSlot3 setPri: 1 cel: 0 init:)
					(= local0 3)
				)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				(= local11 0)
				(self dispose:)
			)
		)
	)
)

(instance lookAtGreaseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local12 1)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCurRoom drawPic: 410)
				(greaseBoard hide:)
				(= local1 1)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(self dispose:)
			)
		)
	)
)

(instance exitGreaseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCurRoom drawPic: 405)
				(greaseBoard show:)
				(= local1 0)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= local12 0)
				(self dispose:)
			)
		)
	)
)

(instance peelEgoAway0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoFromSlot0 setCycle: End self)
			)
			(1
				(egoFromSlot0 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance peelEgoAway1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoPacRookHerbKat dispose:)
				(proc4_6 40002 184 124 0 0 -1 1)
			)
			(1
				(pacRookHerbKat setPri: 1 setCycle: ROsc -1 0 15 init:)
				(proc4_5)
				(self dispose:)
			)
		)
	)
)

(instance peelEgoAway2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoFromSlot2 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(1
				(neighbor cycleSpeed: 12 setCycle: ROsc -1 0 56 init:)
				(officer1 init:)
				(officer2 setCycle: ROsc -1 0 50 init:)
				(egoFromSlot2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance peelEgoAway3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoFromSlot3 setCycle: End self)
			)
			(1
				(dentTelloRhea setPri: 1 setCycle: ROsc -1 0 61 init:)
				(egoFromSlot3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance peelEgoAway4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoWixCarm dispose:)
				(proc4_6 40018 158 114 0 0 -1 1)
			)
			(1
				(wixell init:)
				(carmichael init:)
				(proc4_5)
				(self dispose:)
			)
		)
	)
)

(instance egoFromSlot0 of Prop
	(properties
		x 60
		y 410
		view 40008
	)
)

(instance egoFromSlot2 of Prop
	(properties
		x 5
		y 299
		view 4008
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if (= temp0 (super onMe: param1 &rest))
			(cond
				((< (= temp1 (param1 x:)) 35)
					(= scratch 3)
				)
				((< temp1 85)
					(= scratch 5)
				)
				(else
					(= scratch 4)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(switch scratch
					(3
						(gCurRoom setScript: talkToOfficer1)
					)
					(5
						(gCurRoom setScript: talkToNeighbor)
					)
					(4
						(gCurRoom setScript: talkToOfficer2)
					)
				)
			)
		)
	)
)

(instance egoFromSlot3 of Prop
	(properties
		x 25
		y 250
		view 40003
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if (= temp0 (super onMe: param1 &rest))
			(cond
				((< (= temp1 (param1 x:)) 55)
					(= scratch 0)
				)
				((< temp1 85)
					(= scratch 2)
				)
				(else
					(= scratch 1)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(switch scratch
					(0
						(gCurRoom setScript: talkToDenton)
					)
					(2
						(gCurRoom setScript: talkToTello)
					)
					(1
						(gCurRoom setScript: talkToRhea)
					)
				)
			)
		)
	)
)

(instance pacRookHerbKat of Prop
	(properties
		x 241
		y 355
		view 40001
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToGroup)
			)
		)
	)
)

(instance dentTelloRhea of Prop
	(properties
		x 25
		y 250
		view 40004
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if (= temp0 (super onMe: param1 &rest))
			(cond
				((< (= temp1 (param1 x:)) 55)
					(= scratch 0)
				)
				((< temp1 85)
					(= scratch 2)
				)
				(else
					(= scratch 1)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(switch scratch
					(0
						(gCurRoom setScript: talkToDenton)
					)
					(2
						(gCurRoom setScript: talkToTello)
					)
					(1
						(gCurRoom setScript: talkToRhea)
					)
				)
			)
		)
	)
)

(instance neighbor of Prop
	(properties
		x 5
		y 295
		view 4007
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToNeighbor)
			)
		)
	)
)

(instance officer2 of Prop
	(properties
		x 5
		y 295
		view 4007
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToOfficer2)
			)
		)
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance egoPacRookHerbKat of View
	(properties
		x 239
		y 358
		view 40002
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToGroup)
			)
		)
	)
)

(instance egoWixCarm of View
	(properties
		x 332
		y 425
		view 40018
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if (= temp0 (super onMe: param1 &rest))
			(if (and (> (= temp1 (param1 x:)) 392) (< temp1 550))
				(= scratch 7)
			else
				(= scratch 6)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(switch scratch
					(7
						(gCurRoom setScript: talkToCarmichael)
					)
					(6
						(gCurRoom setScript: talkToWixell)
					)
				)
			)
		)
	)
)

(instance carmichael of View
	(properties
		x 395
		y 430
		view 40008
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToCarmichael)
			)
		)
	)
)

(instance wixell of View
	(properties
		x 555
		y 425
		view 40008
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToWixell)
			)
		)
	)
)

(instance officer1 of View
	(properties
		x 5
		y 295
		view 4007
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToOfficer1)
			)
		)
	)
)

(instance yellowLine of View
	(properties
		x 175
		y 270
		view 40020
	)
)

(instance greaseBoard of View
	(properties
		x 441
		y 176
		view 410
	)

	(method (doVerb)
		(gCurRoom setScript: lookAtGreaseBoard)
	)
)

(instance swatVan of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 1 124 35 118 97 126 116 123 115 218 86 219 72 234 19 242 0 239
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local11)
					(gCurRoom setScript: lookAtVan)
				)
			)
		)
	)
)

(instance vanInt of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 357 106 0 528 0 516 355
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local12)
					(gMessager say: 7 29 0 0) ; "Hey! Leave everything in there alone. It's all inventoried and nothing's been assigned to you."
				)
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
		(if local1
			(gCurRoom setScript: exitGreaseBoard)
		else
			(gCurRoom setScript: exitVan)
		)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: exitGreaseBoard)
		else
			(gCurRoom setScript: exitVan)
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: exitGreaseBoard)
		else
			(gCurRoom setScript: exitVan)
		)
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
		(if local1
			(gCurRoom setScript: exitGreaseBoard)
		else
			(gCurRoom setScript: exitVan)
		)
	)
)

(instance briefTimer of Timer
	(properties)

	(method (cue)
		(if (or (gTalkers size:) (gCurRoom script:))
			(self setReal: self 5)
		else
			(gCurRoom setScript: goToBriefing)
			(self dispose: delete:)
		)
	)
)

(instance interactTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: goToBriefing)
		(self dispose: delete:)
	)
)

