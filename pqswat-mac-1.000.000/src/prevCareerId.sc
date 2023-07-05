;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Button)
(use CareerID)
(use PQSlider)
(use DSelector)
(use Str)
(use Array)
(use Motion)
(use Actor)
(use System)

(public
	prevCareerId 0
)

(instance prevCareerId of PQRoom
	(properties
		picture 0
		infoRoomSignal 257
	)

	(method (init &tmp temp0 temp1 temp2)
		(= picture (+ 24 (Random 0 1)))
		(super init: &rest)
		(SetFlag 3)
		(ClearFlag 16)
		(Load rsVIEW 250)
		(if (not (idList init:))
			(gCurRoom newRoom: 15) ; mainMenu
		)
		(for ((= temp2 0)) (< temp2 (idList size:)) ((++ temp2))
			(= temp1 (idList at: temp2))
			(selectCareer setText: (temp1 idName:))
		)
		(if (!= gPrevRoomNum 30) ; prevCareerCallups
			(Load rsAUDIO 2001)
			(Lock rsAUDIO 2001 1)
			(gBackMusic number: 2001 loop: -1 play:)
		)
		(self setScript: showEagleAppear)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 30) ; prevCareerCallups
			(Lock rsAUDIO 2001 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(if (== newRoomNumber 35) ; metroExt
			(gGame getDisc: 1)
		)
		(ClearFlag 3)
		(ClearFlag 17)
		(idList dispose:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance idList of CareerIDSet
	(properties)
)

(instance showEagleAppear of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (and (== state 0) (== (event message:) KEY_SPACE))
				(event claimed: 1)
				(= cycles (= seconds 0))
				(self cue:)
			else
				(super handleEvent: event)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(backView init:)
				(selectCareer
					setSize:
					init: gCast gFtrInitializer
					updatePlane:
					draw:
				)
				(selectUp init:)
				(selectDown init:)
				(swatLogo init:)
				(if (not (IsFlag 17))
					(selectItem init:)
				)
				(deleteItem init:)
				(cancelDialog init:)
				(sliderObj init: setup:)
				(selectUp init:)
				(selectDown init:)
				(idList selectId: (selectCareer current:))
				(= cycles 3)
			)
			(2
				(swatLogo setLoop: 8 cel: 0 setCycle: End self)
			)
			(3
				(swatLogo loop: 9 cel: 0)
				(UpdateScreenItem swatLogo)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backView of View
	(properties
		view 250
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (plane right:) (plane left:)) temp0) 2))
		(= y (/ (- (- (plane bottom:) (plane top:)) temp1) 2))
	)
)

(instance selectCareer of DSelector
	(properties
		font 20071
		length 10
		width 214
		fore 28
		back 0
	)

	(method (init)
		(= upButton (= downButton -1))
		(gMouseDownHandler add: self)
		(self moveTo: (+ (backView x:) 38) (+ (backView y:) 127))
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (== (event type:) evMOUSEBUTTON)
			(event globalize:)
			(if (listPlane onMe: event)
				(event localize: listPlane)
				(if (= temp0 (textList firstTrue: #onMe event))
					(= current (textList indexOf: temp0))
					(self draw:)
					(idList selectId: current)
					(sliderObj dataCur: current)
					(sliderObj positionThumb:)
				)
			)
			(event localize: plane)
		)
		(if (event claimed:)
			(return self)
		)
	)
)

(instance selectItem of Button
	(properties
		view 250
		loop 1
	)

	(method (init)
		(self posn: (+ (backView x:) 296) (+ (backView y:) 120))
		(super init: &rest)
	)

	(method (doVerb &tmp temp0 temp1)
		(= temp0 (Str new: 20))
		(= temp1 (IntArray new: 20))
		(if (not (Save 5 (gGame name:) (temp0 data:) (temp1 data:))) ; GetSaveFiles
			(gMessager say: 9 2 13 0 0 0) ; "This career has no saved games in which to restore."
		else
			(gGame handsOff:)
			(gCurRoom newRoom: 30) ; prevCareerCallups
		)
		(temp0 dispose:)
		(temp1 dispose:)
	)
)

(instance deleteItem of Button
	(properties
		view 250
		loop 2
	)

	(method (init)
		(self posn: (+ (backView x:) 296) (+ (backView y:) 182))
		(super init: &rest)
	)

	(method (doVerb &tmp temp0 temp1)
		(idList deleteId: (selectCareer current:))
		(if (not (idList size:))
			(gGame handsOff:)
			(gCurRoom newRoom: 15) ; mainMenu
		else
			(selectCareer setText: 0)
			(for ((= temp1 0)) (< temp1 (idList size:)) ((++ temp1))
				(= temp0 (idList at: temp1))
				(selectCareer setText: (temp0 idName:))
			)
			(selectCareer current: 0 setSize: draw:)
			(idList selectId: (selectCareer current:))
		)
		(if (IsFlag 17)
			(gCurRoom newRoom: 20) ; newCareer
		)
	)
)

(instance cancelDialog of Button
	(properties
		view 250
		loop 3
	)

	(method (init)
		(self posn: (+ (backView x:) 296) (+ (backView y:) 245))
		(super init: &rest)
	)

	(method (doVerb)
		(gMessager say: 2 2 3 0 self 0) ; "The selection process for a previous career has been cancelled."
	)

	(method (cue)
		(super cue: &rest)
		(gCurRoom newRoom: 15) ; mainMenu
	)
)

(instance swatLogo of Button
	(properties
		view 250
		loop 7
		upLoop 9
		downLoop 9
	)

	(method (init)
		(self
			posn:
				(+ (backView x:) (proc4_16 312 325 312 312 312))
				(+ (backView y:) 19)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom displayTravel:)
	)
)

(instance sliderObj of PQSlider
	(properties
		view 250
		loop 6
	)

	(method (init)
		(= x (+ (backView x:) 255))
		(= topY (+ (backView y:) 145))
		(= bottomY (+ (backView y:) 246))
		(super init: &rest)
	)

	(method (setup)
		(super setup:)
		(if (selectCareer textList:)
			(= dataBottom
				(Max 0 (- ((selectCareer textList:) size:) 1))
			)
		)
		(= dataStep 1)
	)

	(method (updateData &tmp temp0 temp1)
		(super updateData: &rest)
		(selectCareer current: dataCur)
		(= temp1 (selectCareer textList:))
		(= temp0 (- (- (temp1 size:) 1) (selectCareer length:)))
		(selectCareer
			first:
				(if (< temp0 (selectCareer current:) (- (temp1 size:) 1))
					temp0
				else
					(selectCareer current:)
				)
		)
		(selectCareer draw:)
	)
)

(instance selectUp of Button
	(properties
		view 250
		loop 4
	)

	(method (init)
		(self posn: (+ (backView x:) 258) (+ (backView y:) 124))
		(super init: &rest)
	)

	(method (doVerb)
		(selectCareer scrollUp:)
		(sliderObj adjust: -1)
		(idList selectId: (selectCareer current:))
	)
)

(instance selectDown of Button
	(properties
		view 250
		loop 5
	)

	(method (init)
		(self posn: (+ (backView x:) 258) (+ (backView y:) 256))
		(super init: &rest)
	)

	(method (doVerb)
		(selectCareer scrollDown:)
		(sliderObj adjust: 1)
		(idList selectId: (selectCareer current:))
	)
)

