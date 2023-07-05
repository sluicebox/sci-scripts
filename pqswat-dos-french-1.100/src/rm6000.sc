;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6000)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Button)
(use RobotDoVerb)
(use Plane)
(use Inset)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm6000 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local2 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(qualifyView init:)
	(qualifyYes init:)
	(qualifyNo init:)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(gGame handsOn:)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(= local1 0)
	(while (not local1)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gGame handsOff:)
	(temp1 dispose:)
	(return (== local1 1))
)

(instance rm6000 of PQRoom
	(properties
		picture 6000
		infoRoomSignal 14
	)

	(method (init)
		(Load rsAUDIO 6000)
		(Lock rsAUDIO 6000 1)
		(chalkBoard init:)
		(tvAndVCR init:)
		(leftBoard init:)
		(rightBoard init:)
		(cond
			((IsFlag 122)
				(ClearFlag 122)
			)
			((IsFlag 304)
				(gCurRoom setScript: talkToSaunders)
			)
			((IsFlag 103)
				(= picture 6400)
				(self setScript: altPrisonBound)
			)
			((IsFlag 100)
				(= picture 6400)
				(self setScript: prisonBound)
			)
			((and (IsFlag 16) (not (SetFlag 26)))
				(ClearFlag 16)
				(self setScript: showOpeningSeq)
			)
			((== gPrevRoomNum 130) ; profiles
				(self setScript: returnFromProfiles)
			)
			((IsFlag 75)
				(Load rsVIEW 60014)
				(Load rsVIEW 60033)
				(Load rsVIEW 60034)
				(Load rsVIEW 60035)
				(Load rsVIEW 60036)
				(charmichael init:)
				(tony init:)
				(denton init:)
				(wixell init:)
				(gEgo
					view: 60014
					loop: 0
					cel: 0
					posn: 373 147
					setPri: 240
					init:
				)
				(egoLegs
					view: 60014
					loop: 2
					cel: 0
					posn: 390 171
					setPri: 240
					init:
				)
				(= infoRoomSignal 0)
				(chalkBoardTraining init:)
				(= local3 1)
				(gKeyDownHandler addToFront: self)
				(self setScript: rookTraining)
			)
			((IsFlag 67)
				(self setScript: reinstatement)
			)
			((and (IsFlag 24) (not (IsFlag 120)))
				(= picture 0)
			)
			(
				(and
					(== global136 2)
					(not (& (gEgo medals:) $0080))
					(not (IsFlag 24))
				)
				(= global136 0)
				(self setScript: askToQualify)
			)
			((IsFlag 64)
				(= picture 6400)
				(gCurRoom setScript: removeSuspension)
			)
			((IsFlag 63)
				(= picture 6400)
				(self setScript: removeProbation)
			)
		)
		(super init: &rest)
		(cond
			((and (not script) (IsFlag 24) (not (IsFlag 120)))
				(self setScript: congratPlayer)
			)
			((and (not script) (IsFlag 18) (not (IsFlag 91)))
				(self setScript: playerPromotion)
			)
		)
		(if (== picture 6000)
			(exitSign init:)
			(backDoor init:)
		)
		(if (not script)
			(gGame handsOn:)
		)
		(gBackMusic number: 6000 setLoop: -1 play:)
	)

	(method (displayTravel)
		(if (gCurRoom inset:)
			((gCurRoom inset:) dispose:)
		)
		(super displayTravel: &rest)
	)

	(method (newRoom)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(if (gMouseDownHandler contains: robotFeature)
			(gMouseDownHandler delete: robotFeature)
		)
		(super newRoom: &rest)
	)

	(method (dispose)
		(Lock rsAUDIO 6000 0)
		(gEgo dispose: view: 0)
		(gBackMusic stop:)
		(proc4_5)
		(responseTimer dispose: delete:)
		(jdTimer dispose: delete:)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp [temp0 4])
		(if (and local3 (& (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(= local4 1)
			(gGame handsOff:)
			(Palette 2 42 254 0) ; PalIntensity
			(FrameOut)
			(if (gTimers contains:)
				(responseTimer dispose: delete:)
			)
			(ClearFlag 75)
			(SetFlag 111)
			(proc4_5)
			(if (pacmeyer cycler:)
				(pacmeyer cycler: 0)
			)
			(event claimed: 1)
			(gCast eachElementDo: #dispose)
			(gSwatInterface startAlert:)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)
)

(instance removeSuspension of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 64)
				(ClearFlag 68)
				(gGame handsOff:)
				(Load rsAUDIO 15)
				(proc4_6 60035 215 103)
			)
			(1
				(proc4_5)
				(gGame showCloseUp: 60066 180 66 self 1)
			)
			(2
				(gFxSound number: 15 loop: 1 play: self)
			)
			(3
				(self setScript: draw6000Pic self)
			)
			(4
				(exitSign init:)
				(backDoor init:)
				(gGame setCallUp: (gGame callUpTime:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance removeProbation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 63)
				(ClearFlag 68)
				(Load rsAUDIO 15)
				(proc4_6 60033 223 94 0 0 -1 1)
			)
			(1
				(proc4_5)
				(gGame showCloseUp: 60034 180 66 self 1)
			)
			(2
				(gFxSound number: 15 loop: 1 play: self)
			)
			(3
				(self setScript: draw6000Pic self)
			)
			(4
				(exitSign init:)
				(backDoor init:)
				(gGame setCallUp: (gGame callUpTime:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookTraining of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkieTalkie showFrame: 60010 0 257 90)
				(= global128 60010)
				(pacmeyer init: setCycle: End)
				(= cycles 2)
			)
			(1
				(proc4_5)
				(proc4_6 60010 257 90 0 0 11 1)
			)
			(2
				(rooker view: 60010 loop: 1 setPri: 11 posn: 257 90 init:)
				(proc4_5)
				(gGame handsOn:)
				(responseTimer setReal: responseTimer 5)
				(self dispose:)
			)
		)
	)
)

(instance showOpeningSeq of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gFxSound number: 15 loop: 1 play: self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance returnFromProfiles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gFxSound number: 6005 loop: -1 play:)
				(leftTV cel: 3 init:)
				(middleTV cel: 3 init:)
				(rightTV cel: 3 init:)
				(vcr init: setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(leftTV setCycle: Beg self)
				(middleTV setCycle: Beg)
				(rightTV setCycle: Beg)
			)
			(2
				(gFxSound number: 0 stop:)
				(leftTV dispose:)
				(middleTV dispose:)
				(rightTV dispose:)
				(vcr dispose:)
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance gotoProfiles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 6005 loop: -1 play:)
				(leftTV init: setCycle: End self)
				(middleTV init: setCycle: End)
				(rightTV init: setCycle: End)
				(vcr init:)
			)
			(1
				(vcr setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(gFxSound number: 0 stop:)
				(gCurRoom newRoom: 130) ; profiles
			)
		)
	)
)

(instance draw6000Pic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(1
				(proc4_5)
				(gCurRoom drawPic: 6000)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(self dispose:)
			)
		)
	)
)

(instance reinstatement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 15)
				(proc4_6 60006 394 79 0 0 200)
			)
			(1
				(proc4_5)
				(gGame showCloseUp: 60067 180 66 self)
			)
			(2
				(gFxSound number: 15 setLoop: 0 play:)
				(ClearFlag 67)
				(gGame setCallUp: (gGame callUpTime:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance congratPlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 15)
				(gGame handsOff:)
				(Palette 2 0 254 100) ; PalIntensity
				(FrameOut)
				(gGame showCloseUp: 6008 180 66 self 1)
			)
			(1
				(gFxSound number: 15 setLoop: 1 play: self)
			)
			(2
				(gCurRoom drawPic: 6000)
				(SetFlag 120)
				(exitSign init:)
				(backDoor init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance askToQualify of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 15)
				(proc4_6 60028 304 82 5 0 200 1)
			)
			(1
				(if (localproc_0)
					(gMessager say: 0 0 9 0 self) ; "Great. I'll let Sgt. Pruett know you're interested. Good luck."
					(SetFlag 23)
					(proc4_5)
					(gGame showCloseUp: 60029 180 66 self)
				else
					(gMessager say: 0 0 10 0 self) ; "Well, maybe another time. I'll check with you periodically... to see if you change your mind."
					(proc4_5)
					(gGame showCloseUp: 60030 180 66 self)
				)
			)
			(2
				(gFxSound number: 15 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance playerPromotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 15)
				(proc4_6 60031 166 86 0 0 200)
			)
			(1
				(proc4_5)
				(gGame showCloseUp: 60032 180 66 self)
			)
			(2
				(gFxSound number: 15 setLoop: 1 play:)
				(gEgo makeLeader:)
				(SetFlag 19)
				(ClearFlag 18)
				(gGame setCallUp: (gGame callUpTime:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveDuringTraining of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGame showCloseUp: 60052 -1 -1 self)
			)
			(2
				(responseTimer setReal: responseTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookTV of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGame showCloseUp: 60051 -1 -1 self)
			)
			(2
				(responseTimer setReal: responseTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance askFirstQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(proc4_6 60014 371 139 0 0 240 1)
			)
			(1
				(gCurRoom newRoom: 6400)
			)
		)
	)
)

(instance talkToSaunders of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMouseDownHandler add: (robotFeature init: yourself:))
				(if (IsFlag 305)
					(proc4_6 60019 206 99 0 0 200 1)
				else
					(proc4_6 60024 206 96 0 0 200 1)
				)
			)
			(1
				(jdTimer setReal: jdTimer 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jdTimesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jdTimer dispose: delete:)
				(Load rsAUDIO 15)
				(gGame handsOff:)
				(if (IsFlag 305)
					(gGame showCloseUp: 60055 180 66 self)
				else
					(gGame showCloseUp: 60023 180 66 self)
				)
			)
			(1
				(gFxSound number: 15 loop: 1 play: self)
			)
			(2
				(robotFeature dispose:)
				(ClearFlag 304)
				(SetFlag 67)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jdLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jdTimer dispose: delete:)
				(Load rsAUDIO 15)
				(gGame handsOff:)
				(if (IsFlag 305)
					(gGame showCloseUp: 60056 180 66 self)
				else
					(gGame showCloseUp: 60058 180 66 self)
				)
			)
			(1
				(gFxSound number: 15 loop: 1 play: self)
			)
			(2
				(robotFeature dispose:)
				(ClearFlag 304)
				(SetFlag 67)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance clickedOnJD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 15)
				(gGame showCloseUp: register 180 66 self)
			)
			(1
				(gFxSound number: 15 setLoop: 1 play: self)
			)
			(2
				(robotFeature dispose:)
				(ClearFlag 304)
				(SetFlag 67)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance prisonBound of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 100)
				(proc4_6 60003 238 40 0 0 -1 1)
			)
			(1
				(gGame restart:)
			)
		)
	)
)

(instance altPrisonBound of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 103)
				(proc4_6 60002 238 40 0 0 -1 1)
			)
			(1
				(gGame restart:)
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties
		x 602
		y 317
		priority 225
		fixPriority 1
		view 60011
	)
)

(instance rooker of Prop
	(properties
		x 400
		y 216
		view 6000
	)

	(method (doVerb)
		(if (IsFlag 75)
			(SetFlag 29)
			(responseTimer dispose: delete:)
			(gCurRoom setScript: askFirstQuestion)
		)
	)
)

(instance hancock of Prop ; UNUSED
	(properties
		x 240
		y 216
		view 6000
		cel 2
	)
)

(instance leftTV of Prop
	(properties
		x 70
		y 40
		view 60054
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
	)
)

(instance middleTV of Prop
	(properties
		x 162
		y 122
		view 60054
		loop 1
		cel 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 158)
		(&= signal $efff)
	)
)

(instance rightTV of Prop
	(properties
		x 454
		y 21
		view 60054
		loop 2
		cel 2
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
	)
)

(instance vcr of Prop
	(properties
		x 202
		y 152
		view 60054
		loop 3
		cel 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 158)
		(&= signal $efff)
	)
)

(instance chalkBoardTraining of View
	(properties
		x 244
		y 84
		priority 10
		fixPriority 1
		view 60125
	)

	(method (onMe)
		(return 0)
	)
)

(instance charmichael of Prop
	(properties
		y 366
		priority 330
		fixPriority 1
		view 60033
	)
)

(instance tony of Prop
	(properties
		x 167
		y 368
		priority 300
		fixPriority 1
		view 60034
	)
)

(instance denton of Prop
	(properties
		x 270
		y 352
		priority 300
		fixPriority 1
		view 60035
	)
)

(instance wixell of Prop
	(properties
		x 108
		y 275
		priority 260
		fixPriority 1
		view 60036
	)
)

(instance exitSign of Prop
	(properties
		x 598
		y 49
		view 60001
		cel 1
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)
)

(instance backDoor of Feature
	(properties
		nsLeft 568
		nsTop 84
		nsRight 640
		nsBottom 261
	)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doit)
		(super doit:)
		(if (and (gGame isHandsOn:) (self onMe: gMouseX gMouseY))
			(exitSign cel: 0)
		else
			(exitSign cel: 1)
		)
		(UpdateScreenItem exitSign)
	)

	(method (doVerb)
		(if (IsFlag 75)
			(responseTimer dispose: delete:)
			(gCurRoom setScript: leaveDuringTraining)
		else
			(gCurRoom newRoom: 100)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance chalkBoard of Feature
	(properties
		y 1
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 191 81 429 76 428 144 189 140
					yourself:
				)
		)
	)

	(method (doVerb)
		(if (IsFlag 75)
			(Palette 2 42 254 0) ; PalIntensity
			(responseTimer dispose: delete:)
			(SetFlag 30)
			(gCurRoom newRoom: 6400)
		else
			(gCurRoom newRoom: 180) ; tacticsMenu
		)
	)
)

(instance tvAndVCR of Feature
	(properties
		y 10
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 116 157 157 243 159 243 148 206 148 204 116
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 67 31 70 75 126 75 122 29
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 447 9 449 64 522 62 522 2
					yourself:
				)
		)
	)

	(method (doVerb)
		(if (IsFlag 75)
			(responseTimer dispose: delete:)
			(gCurRoom setScript: lookTV)
		else
			(gCurRoom setScript: gotoProfiles)
		)
	)
)

(instance leftBoard of Feature
	(properties
		nsTop 86
		nsRight 76
		nsBottom 148
	)

	(method (doVerb)
		(bullBoard view: 60057 loop: 0)
		(gCurRoom setInset: bullBoard 0 1)
	)
)

(instance rightBoard of Feature
	(properties
		nsLeft 456
		nsTop 86
		nsRight 552
		nsBottom 158
	)

	(method (doVerb)
		(bullBoard view: 60057 loop: 1)
		(gCurRoom setInset: bullBoard 0 1)
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (not (self onMe: event)))
			(event claimed: 1)
			(gCurRoom setScript: jdLeaves)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(jdTimer dispose: delete:)
				(if (IsFlag 305)
					(gCurRoom setScript: clickedOnJD 0 60054)
				else
					(gCurRoom setScript: clickedOnJD 0 60057)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance bullBoard of Inset
	(properties
		picture -2
		disposeNotOnMe 1
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (doVerb)
		(self dispose:)
	)
)

(instance responseTimer of Timer
	(properties)

	(method (doit)
		(if (not (gCurRoom inset:))
			(super doit: &rest)
		)
	)

	(method (cue)
		(gGame handsOff:)
		(if (not local4)
			(gCurRoom newRoom: 6400)
		)
	)
)

(instance jdTimer of Timer
	(properties)

	(method (cue)
		(self dispose: delete:)
		(gCurRoom setScript: jdTimesOut)
	)
)

(instance qualifyView of View
	(properties
		priority 150
		fixPriority 1
		view 154
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance qualifyYes of Button
	(properties
		priority 151
		fixPriority 1
		view 154
		loop 1
		keyMessage 110
	)

	(method (init)
		(= x (+ (qualifyView x:) 16))
		(= y (+ (qualifyView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(= local1 1)
	)
)

(instance qualifyNo of Button
	(properties
		priority 151
		fixPriority 1
		view 154
		loop 1
		upCel 2
		downCel 3
		keyMessage 110
	)

	(method (init)
		(= x (+ (qualifyView x:) 166))
		(= y (+ (qualifyView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(= local1 2)
	)
)

(instance egoLegs of View
	(properties)
)

