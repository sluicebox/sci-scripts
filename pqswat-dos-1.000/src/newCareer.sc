;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use PQRoom)
(use Button)
(use CareerID)
(use DEdit)
(use Str)
(use Actor)
(use System)

(public
	newCareer 0
)

(local
	local0
)

(instance newCareer of PQRoom
	(properties
		picture 20
		infoRoomSignal 256
	)

	(method (init)
		(Load rsAUDIO 2001)
		(super init: &rest)
		(Load rsVIEW 205)
		(SetFlag 3)
		(idList init:)
		(swatLogo init:)
		(gotoMetro init: setActive: 0)
		((= local0 (Str new: 25)) format: {%s} {Swat Pup})
		(if (< (idList size:) 10)
			(editField init:)
			(self setScript: delayScript)
		else
			(gBackMusic number: 2001 loop: -1 play:)
			(deleteView init:)
			(deleteYes init:)
			(deleteNo init:)
			(gGame handsOn:)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: editField)
			(gMouseDownHandler delete: editField)
		)
		(if (gKeyDownHandler contains: editField)
			(gKeyDownHandler delete: editField)
		)
		(gBackMusic fade: 0 2 21 1)
		(ClearFlag 3)
		(idList dispose:)
		(local0 dispose:)
		(super dispose: &rest)
	)
)

(instance delayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
				(gotoMetro setActive: 1)
			)
			(1
				(gBackMusic number: 2001 loop: -1 play:)
				(gMessager say: 1 2 1 0 self) ; "Welcome to D Platoon, Officer. Formed in 1967, the Special Weapons and Tactics team of the Los Angeles Police Department has held a preeminence within the field of law enforcement and has been the standard bearer for domestic specialized tactical units throughout the world. We are an organization steeped in tradition and pride, where individuals are frequently called upon to perform at levels far above the norm. There have been, and ever will be, certain guiding principles that have provided the foundation for the high level of professionalism exemplified by this organization and it's members. Commit them to memory."
			)
			(2
				(gGame handsOn:)
				(editField hilite: 1)
				(self dispose:)
			)
		)
	)
)

(instance idList of CareerIDSet
	(properties)
)

(instance deleteView of View
	(properties
		priority 150
		fixPriority 1
		view 205
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

(instance deleteYes of Button
	(properties
		priority 151
		fixPriority 1
		view 205
		loop 1
		keyMessage 121
	)

	(method (init)
		(= x (+ (deleteView x:) 15))
		(= y (+ (deleteView y:) 113))
		(super init: &rest)
	)

	(method (doVerb)
		(SetFlag 17)
		(gCurRoom newRoom: 25) ; prevCareerId
	)
)

(instance deleteNo of Button
	(properties
		priority 151
		fixPriority 1
		view 205
		loop 1
		upCel 2
		downCel 3
		keyMessage 110
	)

	(method (init)
		(= x (+ (deleteView x:) 163))
		(= y (+ (deleteView y:) 113))
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: 15) ; mainMenu
	)
)

(instance editField of DEdit
	(properties)

	(method (init)
		(self
			text: (local0 data:)
			width: 24
			fore: 156
			font: 20071
			back: 0
			skip: 0
			setSize:
			moveTo: 302 423
		)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evKEYBOARD)
					(== (event message:) KEY_RETURN)
					(gotoMetro active:)
				)
				(gotoMetro doVerb:)
			)
			(
				(and
					(& (event type:) evKEYBOARD)
					(== (event message:) KEY_ESCAPE)
					(gotoMetro active:)
				)
				(self hilite: 1)
				(event claimed: 1)
				(return)
			)
		)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(event claimed: 1)
			(self hilite: 1)
			(event claimed:)
			(return)
		)
		(super handleEvent: event)
	)
)

(instance swatLogo of Button
	(properties
		view 10
		loop 13
		upCel 11
		downCel 10
	)

	(method (init)
		(self posn: 28 10)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom displayTravel:)
	)
)

(instance gotoMetro of Button
	(properties
		x 562
		y 400
		view 200
	)

	(method (doVerb &tmp temp0)
		(if (not (local0 size:))
			(gMessager say: 1 2 2) ; "Officer, before you are allowed to enter into the ranks of D Platoon you must sign your name indicating you have read, and agree to comply with, the SWAT Mission Statement. There will be no exceptions."
			(editField enable: 1 hilite: 1)
			(return)
		)
		(if (!= (= temp0 (idList createId: local0)) -1)
			(idList write: selectId: temp0)
		else
			(gCurRoom newRoom: 15) ; mainMenu
		)
		(SetFlag 16)
		(gCurRoom newRoom: 13) ; openToon
	)
)

