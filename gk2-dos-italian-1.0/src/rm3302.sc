;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3302)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	rm3302 0
)

(instance rm3302 of TopicRoom ; "Von Glower's House"
	(properties
		modNum 330
		noun 3
		picture 3315
		south 330 ; vgHouseRm
		BAD_SELECTOR 50
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 24392
				setLoop: 0 1
				posn: 370 112
				cel: 0
				init:
				setPri: 250 1
				setScript: FidgetScript
			)
			(pVonGlower init: setScript: FidgetScript)
		)
		(tVonGlower BAD_SELECTOR: tFrom tFamily tMunich)
		(super
			init:
				tVonGlower
				tClub
				tMembers
				tMembers2
				tBasement
				tPhil
				tPhil2
				tPhil3
				tWolf
		)
	)
)

(instance pVonGlower of Prop
	(properties
		sightAngle 360
		x 174
		y 139
		view 23392
	)
)

(instance tVonGlower of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 201
		noun 21
	)
)

(instance tClub of Topic
	(properties
		BAD_SELECTOR 402
		BAD_SELECTOR 202
		noun 10
	)
)

(instance tMembers of Topic
	(properties
		BAD_SELECTOR 404
		BAD_SELECTOR 206
		noun 11
	)
)

(instance tMembers2 of Topic
	(properties
		BAD_SELECTOR 405
		BAD_SELECTOR 207
		BAD_SELECTOR 206
		noun 15
	)
)

(instance tFamily of Topic
	(properties
		BAD_SELECTOR 401
		BAD_SELECTOR 205
		noun 14
	)
)

(instance tFrom of Topic
	(properties
		BAD_SELECTOR 398
		BAD_SELECTOR 204
		noun 12
	)
)

(instance tMunich of Topic
	(properties
		BAD_SELECTOR 399
		BAD_SELECTOR 208
		BAD_SELECTOR 204
		noun 13
	)
)

(instance tBasement of Topic
	(properties
		BAD_SELECTOR 406
		BAD_SELECTOR 209
		BAD_SELECTOR 513
		noun 16
	)
)

(instance tPhil of Topic
	(properties
		BAD_SELECTOR 407
		BAD_SELECTOR 210
		BAD_SELECTOR 209
		noun 17
	)
)

(instance tPhil2 of Topic
	(properties
		BAD_SELECTOR 408
		BAD_SELECTOR 211
		BAD_SELECTOR 210
		noun 18
	)
)

(instance tPhil3 of Topic
	(properties
		BAD_SELECTOR 409
		BAD_SELECTOR 212
		BAD_SELECTOR 211
		noun 19
	)
)

(instance tWolf of Topic
	(properties
		BAD_SELECTOR 410
		BAD_SELECTOR 213
		BAD_SELECTOR 212
		noun 20
	)

	(method (BAD_SELECTOR param1)
		(return
			(and
				(super BAD_SELECTOR: param1)
				(or (and argc param1) (IsFlag 514))
			)
		)
	)
)

