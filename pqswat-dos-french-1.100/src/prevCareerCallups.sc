;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use PQRoom)
(use Button)
(use CareerID)
(use MedalID)
(use PQSlider)
(use DSelector)
(use DText)
(use Str)
(use Array)
(use File)
(use Actor)
(use System)

(public
	prevCareerCallups 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(= local1 (Str new: 720))
	(= local2 (IntArray new: 21))
	(if
		(==
			(= local0 (Save 5 (gGame name:) (local1 data:) (local2 data:))) ; GetSaveFiles
			-1
		)
		(return 0)
	)
	(if (and (ourSelector textList:) ((ourSelector textList:) size:))
		(ourSelector setText: 0)
	)
	(ourSelector current: 0 width: 234 setText: local1 setSize:)
	(deleteButn setActive: local0)
	(return (restoreButn setActive: local0))
)

(procedure (localproc_1 &tmp temp0)
	(policeMedal hide:)
	(policeStar hide:)
	(meritCitation hide:)
	(medalOfValor hide:)
	(meritService hide:)
	(commCitation hide:)
	(distService hide:)
	(elementLeaderStar hide:)
	(snipeExpert hide:)
	(if (or (not (ourSelector textList:)) (not ((ourSelector textList:) size:)))
		(return)
	)
	(if
		(&
			(= temp0 (theMedals select: (local2 at: (ourSelector current:))))
			$0001
		)
		(policeMedal show:)
	)
	(if (& temp0 $0002)
		(medalOfValor show:)
	)
	(if (& temp0 $0004)
		(policeStar show:)
	)
	(if (& temp0 $0008)
		(distService show:)
	)
	(if (& temp0 $0010)
		(meritService show:)
	)
	(if (& temp0 $0020)
		(commCitation show:)
	)
	(if (& temp0 $0040)
		(meritCitation show:)
	)
	(if (& temp0 $0080)
		(elementLeaderStar show:)
	)
	(if (& temp0 $0100)
		(snipeExpert show:)
	)
	(UpdatePlane gThePlane)
	(FrameOut)
)

(class Medal of View
	(properties
		maxAllowed 0
		box 0
		boxView 0
		boxLoop 0
		boxCel 0
		boxX 0
		boxY 0
		goldFrame 0
	)

	(method (init)
		(super init: &rest)
		((= box (View new:))
			view: boxView
			setLoop: boxLoop
			setCel: boxCel
			x: boxX
			y: boxY
			init:
		)
	)

	(method (show)
		(super show: &rest)
		(box setCel: boxCel show:)
		(UpdateScreenItem box)
		(if goldFrame
			(goldFrame show:)
		)
	)

	(method (hide)
		(super hide: &rest)
		(box hide:)
		(if goldFrame
			(goldFrame hide:)
		)
	)

	(method (dispose)
		(box dispose:)
		(if goldFrame
			(goldFrame dispose:)
		)
		(super dispose: &rest)
	)
)

(instance prevCareerCallups of PQRoom
	(properties
		picture 30
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(SetFlag 3)
		(idList init:)
		(if (and (>= global111 0) (= temp0 (idList getCareerIdObj: global111)))
			(= local3 (Str format: {%s} ((temp0 idName:) data:)))
		)
		(idList dispose:)
		(restoreButn init:)
		(deleteButn init:)
		(cancelButn init:)
		(scrollUpButn init:)
		(scrollDownButn init:)
		(theMedals init:)
		(policeMedal init: hide:)
		(policeStar init: hide:)
		(meritCitation init: hide:)
		(medalOfValor init: hide:)
		(meritService init: hide:)
		(commCitation init: hide:)
		(distService init: hide:)
		(elementLeaderStar init: hide:)
		(snipeExpert init: hide:)
		(if local3
			(careerName
				text: (KString 8 (local3 data:)) ; StrDup
				font: 20071
				fore: 28
				back: 0
				skip: 0
				setSize:
			)
			(careerName
				moveTo:
					(+ (/ (- 234 (careerName textRight:)) 2) 202)
					(+ (/ (- 17 (careerName textBottom:)) 2) 65)
				init:
			)
		)
		(badgeNumber init: cel: global111)
		(localproc_0)
		(ourSelector init: gCast gFtrInitializer updatePlane: draw:)
		(sliderObj init: setup:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(Palette 2 0 254 0) ; PalIntensity
		(FrameOut)
		(if (!= newRoomNumber 25) ; prevCareerId
			(Lock rsAUDIO 2001 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(careerName dispose:)
		(theMedals dispose:)
		(ourSelector dispose:)
		(DisposeScript 64993)
		(DisposeScript 64990)
		(ClearFlag 3)
		(local2 dispose:)
		(local1 dispose:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance idList of CareerIDSet
	(properties)
)

(instance restoreButn of Button
	(properties
		x 188
		y 218
		z 2
		view 303
	)

	(method (doVerb)
		(theMedals dispose:)
		(careerName dispose:)
		(Lock rsAUDIO 2001 0)
		(gBackMusic fade: 0 2 21 1)
		(ourSelector setText: 0 dispose:)
		(gGame restore: (local2 at: (ourSelector current:)))
		(ourSelector init: gCast gFtrInitializer updatePlane: draw:)
	)
)

(instance deleteButn of Button
	(properties
		x 273
		y 217
		z 1
		view 303
		loop 1
	)

	(method (doVerb &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (Str new:))
		(= temp6 (ourSelector current:))
		(Save 6 (temp0 data:) (gGame name:)) ; MakeSaveCatName
		((= temp1 (File new:)) name: (temp0 data:) open: 2)
		(for ((= temp2 0)) (< temp2 local0) ((++ temp2))
			(if (!= temp2 temp6)
				(= temp5 (local2 at: temp2))
				(temp0
					at: 0 (& temp5 $00ff)
					at: 1 (& (>> temp5 $0008) $00ff)
					at: 2 0
				)
				(temp1 write: (temp0 data:) 2)
				(= temp3 (Str new: 36))
				(temp3 copyToFrom: 0 local1 (* temp2 36) 36)
				(temp1 write: (temp3 data:) 36)
				(temp3 dispose:)
			)
		)
		(temp0 at: 0 255 at: 1 255)
		(temp1 write: (temp0 data:) 2 close: dispose:)
		(Save 7 (temp0 data:) (gGame name:) (local2 at: temp6)) ; MakeSaveFileName
		(FileIO fiUNLINK (temp0 data:))
		((= temp4 (MedalList new:)) init: deleteID: (local2 at: temp6) dispose:)
		(if
			(==
				(= local0
					(Save 5 (gGame name:) (local1 data:) (local2 data:)) ; GetSaveFiles
				)
				-1
			)
			(return 0)
		)
		(deleteButn setActive: local0)
		(restoreButn setActive: local0)
		(if (and (ourSelector textList:) ((ourSelector textList:) size:))
			(ourSelector setText: 0)
		)
		(return (ourSelector current: 0 setText: local1 setSize: draw:))
	)
)

(instance cancelButn of Button
	(properties
		x 358
		y 216
		view 303
		loop 2
	)

	(method (doVerb)
		(gCurRoom newRoom: 25) ; prevCareerId
	)
)

(instance policeMedal of Medal
	(properties
		x 342
		y 262
		view 303
		loop 3
		maxAllowed 6
		boxView 303
		boxLoop 17
		boxX 351
		boxY 389
	)

	(method (show)
		(if (< global444 maxAllowed)
			(= boxCel (Max 0 (- global444 1)))
		else
			((= goldFrame (View new:))
				view: 303
				setLoop: 16
				x: boxX
				y: boxY
				setPri: 500
				init:
			)
			(= boxCel maxAllowed)
		)
		(super show: &rest)
	)
)

(instance policeStar of Medal
	(properties
		x 152
		y 263
		view 303
		loop 4
		maxAllowed 11
		boxView 303
		boxLoop 17
		boxX 155
		boxY 389
	)

	(method (show)
		(if (< global440 maxAllowed)
			(= boxCel (Max 0 (- global440 1)))
		else
			((= goldFrame (View new:))
				view: 303
				setLoop: 16
				x: boxX
				y: boxY
				setPri: 500
				init:
			)
			(= boxCel maxAllowed)
		)
		(super show: &rest)
	)
)

(instance meritCitation of Medal
	(properties
		x 429
		y 262
		view 303
		loop 5
		maxAllowed 26
		boxView 303
		boxLoop 17
		boxX 434
		boxY 389
	)

	(method (show)
		(if (< global442 maxAllowed)
			(= boxCel (Max 0 (- global442 1)))
		else
			((= goldFrame (View new:))
				view: 303
				setLoop: 16
				x: boxX
				y: boxY
				setPri: 500
				init:
			)
			(= boxCel maxAllowed)
		)
		(super show: &rest)
	)
)

(instance medalOfValor of Medal
	(properties
		x 226
		y 255
		view 303
		loop 6
		maxAllowed 3
		boxView 303
		boxLoop 17
		boxX 254
		boxY 389
	)

	(method (show)
		(if (< global439 maxAllowed)
			(= boxCel (Max 0 (- global439 1)))
		else
			((= goldFrame (View new:))
				view: 303
				setLoop: 16
				x: boxX
				y: boxY
				setPri: 500
				init:
			)
			(= boxCel maxAllowed)
		)
		(super show: &rest)
	)
)

(instance meritService of View
	(properties
		x 54
		y 247
		view 303
		loop 7
	)
)

(instance commCitation of Medal
	(properties
		x 74
		y 263
		view 303
		loop 8
		maxAllowed 11
		boxView 303
		boxLoop 17
		boxX 77
		boxY 389
	)

	(method (show)
		(if (< global443 maxAllowed)
			(= boxCel (Max 0 (- global443 1)))
		else
			((= goldFrame (View new:))
				view: 303
				setLoop: 16
				x: boxX
				y: boxY
				setPri: 500
				init:
			)
			(= boxCel maxAllowed)
		)
		(super show: &rest)
	)
)

(instance distService of View
	(properties
		x 54
		y 247
		view 303
		loop 9
	)
)

(instance elementLeaderStar of View
	(properties
		x 493
		y 159
		view 303
		loop 11
	)
)

(instance snipeExpert of View
	(properties
		x 511
		y 268
		view 303
		loop 15
	)
)

(instance badgeNumber of View
	(properties
		x 104
		y 199
		view 303
		loop 10
	)
)

(instance careerName of DText
	(properties)
)

(instance theMedals of MedalList
	(properties)
)

(instance ourSelector of DSelector
	(properties
		font 20071
		length 10
		fore 28
		back 0
	)

	(method (init param1)
		(= upButton (= downButton -1))
		(gMouseDownHandler add: self)
		(self moveTo: 190 100)
		(super init: param1 &rest)
	)

	(method (setText param1 &tmp temp0 temp1 [temp2 2])
		(if (and param1 (param1 size:))
			(for ((= temp0 0)) (param1 at: temp0) ((+= temp0 36))
				(super setText: (= temp1 (param1 subStr: temp0 36)))
				(temp1 dispose:)
			)
		else
			(super setText: 0)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (draw)
		(super draw: &rest)
		(localproc_1)
		(sliderObj dataCur: current)
		(sliderObj positionThumb:)
	)
)

(instance sliderObj of PQSlider
	(properties
		x 429
		view 303
		loop 14
		topY 120
		bottomY 187
	)

	(method (setup)
		(super setup:)
		(if (ourSelector textList:)
			(= dataBottom (Max 0 (- ((ourSelector textList:) size:) 1)))
		)
		(= dataStep 1)
	)

	(method (updateData &tmp temp0 temp1)
		(super updateData: &rest)
		(ourSelector current: dataCur)
		(= temp1 (ourSelector textList:))
		(= temp0 (- (- (temp1 size:) 1) (ourSelector length:)))
		(ourSelector
			first:
				(if (< temp0 (ourSelector current:) (- (temp1 size:) 1))
					temp0
				else
					(ourSelector current:)
				)
		)
		(ourSelector draw:)
	)
)

(instance scrollUpButn of Button
	(properties
		x 432
		y 100
		view 303
		loop 12
		keyMessage 1
	)

	(method (doVerb)
		(ourSelector scrollUp:)
	)
)

(instance scrollDownButn of Button
	(properties
		x 432
		y 198
		view 303
		loop 13
		keyMessage 5
	)

	(method (doVerb)
		(ourSelector scrollDown:)
	)
)

