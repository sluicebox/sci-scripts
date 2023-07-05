;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Button)
(use n1111)
(use Plane)
(use Print)
(use Inset)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(local
	local0
)

(instance automapEgo of View
	(properties
		view 350
		loop 1
	)
)

(class AutoMapProp of Actor
	(properties
		priority 1
		fixPriority 1
		testFlag 0
		scaleView 0
		scaleLoop 0
		scaleCel 0
		startSize 0
		startX 0
		startY 0
	)

	(method (init)
		(if (and testFlag (not (IsFlag 307)) (not (IsFlag testFlag)))
			(return)
		)
		(super init: &rest)
		(&= signal $efff)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if scaleView
					(ScaledActor
						view: scaleView
						setLoop: scaleLoop 1
						setCel: scaleCel
						startX: startX
						startY: startY
					)
					(ScaledActor init: ((AutoMapInset curMapInset:) insetCast:))
					(((AutoMapInset curMapInset:) insetCast:)
						eachElementDo: #perform hideForScaling
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class AutoMapInset of Inset
	(properties
		priority 15
		arrowPosnX 0
		arrowPosnY 0
		maxLevels 0
		arrowSignal 0
		showUserPosn 0
		curMapInset 0
		mapWidth 624
		mapHeight 332
		buttonPlane 0
	)

	(method (init &tmp temp0)
		(AutoMapInset curMapInset: self)
		(if (not plane)
			((= plane (Plane new:))
				name: {AutoMapPlane}
				picture: picture
				setRect: 30 40 mapWidth mapHeight
			)
			((= buttonPlane automapButtonPlane)
				name: {AutoMapButtonPlane}
				picture: -2
				priority: (+ priority 1)
				init: 30 40 624 332
				addCast: (= temp0 (Cast new:))
			)
		)
		(super init: &rest)
		(mapCursorCatcher plane: plane init:)
		(automapEgo init: insetCast)
		(self positionAlterEgo: automapEgo)
		(if (not (& (automapEgo signal:) $0008))
			(UpdateScreenItem automapEgo)
		)
		(ExitButton init: temp0)
		(if (> mapHeight 332)
			(UpArrow init: temp0)
			(DownArrow init: temp0)
		)
	)

	(method (dispose)
		(buttonPlane dispose:)
		(= buttonPlane 0)
		(AutoMapInset curMapInset: 0)
		(super dispose:)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(if inView
			(plane setBitmap: inView 0)
		)
		(self initItems:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (buttonNotify param1)
		(buttonSound play:)
		(switch param1
			(1
				(if (< (plane top:) 40)
					(plane
						setRect:
							(plane left:)
							(+ (plane top:) 73)
							(plane right:)
							(+ (plane bottom:) 73)
					)
					(UpdatePlane plane)
					(FrameOut)
				)
			)
			(4
				(if (> (plane bottom:) 372)
					(plane
						setRect:
							(plane left:)
							(- (plane top:) 73)
							(plane right:)
							(- (plane bottom:) 73)
					)
					(UpdatePlane plane)
					(FrameOut)
				)
			)
			(16
				((AutoMapInset curMapInset:) dispose:)
			)
		)
	)

	(method (positionAlterEgo param1)
		(param1 posn: 296 146)
	)

	(method (initItems))
)

(class AutoMapScaler of Scaler
	(properties)

	(method (init param1 param2 param3)
		(if argc
			(= client param1)
			(= frontSize 100)
			(= backSize 50)
			(= frontY param2)
			(= backY param3)
		)
		(= slopeNum (- frontSize backSize))
		(if (not (= slopeDen (- frontY backY)))
			(Prints {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(= const (- backSize (/ (* slopeNum backY) slopeDen)))
		(self doit:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp2 (client scaleX:))
		(= temp3 (client scaleY:))
		(= temp0 (client x:))
		(= temp1
			(/ (* (= temp1 (+ (/ (* slopeNum temp0) slopeDen) const)) 128) 100)
		)
		(if (or (!= temp2 temp1) (!= temp3 temp1))
			(client scaleX: temp1 scaleY: temp1)
		)
	)
)

(instance ScaledActor of AutoMapProp
	(properties
		priority 500
	)

	(method (init &tmp temp0 temp1)
		(= temp0
			(/
				(-
					(((AutoMapInset curMapInset:) plane:) right:)
					(((AutoMapInset curMapInset:) plane:) left:)
				)
				2
			)
		)
		(= temp1
			(/
				(-
					(((AutoMapInset curMapInset:) plane:) bottom:)
					(((AutoMapInset curMapInset:) plane:) top:)
				)
				2
			)
		)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			moveSpeed: 0
			setStep: 15 15
			posn: startX startY
		)
		(self
			setScaler: AutoMapScaler temp0 startX
			setMotion: MoveTo temp0 temp1
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(self dispose:)
		(((AutoMapInset curMapInset:) insetCast:)
			eachElementDo: #perform showAllObjs
		)
		((AutoMapInset curMapInset:) buttonNotify: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (not mover)
					(self setMotion: MoveTo startX startY self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance automapButtonPlane of Plane
	(properties)

	(method (onMe param1 &tmp temp0)
		(= temp0 (super onMe: param1))
		(param1 localize: self)
		(if
			(and
				temp0
				(not (UpArrow onMe: param1))
				(not (DownArrow onMe: param1))
				(not (ExitButton onMe: param1))
			)
			(= temp0 0)
		)
		(param1 globalize:)
		(return temp0)
	)
)

(instance UpArrow of Button
	(properties
		x 557
		y 34
		view 350
		upCel 2
		downCel 3
		doVerbCalled 1
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
		(self setHotspot: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				((AutoMapInset curMapInset:) buttonNotify: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self view: upView loop: upLoop cel: upCel active: 1 case: 8)
		else
			(self view: downView loop: downLoop cel: downCel active: 0 case: 7)
		)
		(UpdateScreenItem self)
	)
)

(instance DownArrow of Button
	(properties
		x 557
		y 245
		view 350
		doVerbCalled 1
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
		(self setHotspot: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				((AutoMapInset curMapInset:) buttonNotify: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self view: upView loop: upLoop cel: upCel active: 1 case: 8)
		else
			(self view: downView loop: downLoop cel: downCel active: 0 case: 7)
		)
		(UpdateScreenItem self)
	)
)

(instance ExitButton of Button
	(properties
		x 20
		y 24
		view 350
		upCel 4
		downCel 5
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
		(self setHotspot: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				((AutoMapInset curMapInset:) buttonNotify: 16)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setActive))
)

(instance mapCursorCatcher of Feature
	(properties)

	(method (init)
		(self
			nsLeft: 0
			nsTop: 0
			nsRight: (plane right:)
			nsBottom: (plane bottom:)
		)
		(super init: &rest)
		(self setHotspot: 2 31 11)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hideForScaling of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #setActive)
			(param1 setActive: 0)
			(return)
		)
	)
)

(instance showAllObjs of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #setActive)
			(param1 setActive: 0)
			(return)
		)
	)
)

(instance buttonSound of Sound
	(properties
		number 4003
	)
)

