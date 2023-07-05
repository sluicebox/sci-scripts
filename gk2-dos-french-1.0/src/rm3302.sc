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
		dialogDoneFlag 50
	)

	(method (init)
		(if (not checking)
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
		(tVonGlower setSubList: tFrom tFamily tMunich)
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

(instance tVonGlower of Topic ; "Himself"
	(properties
		sceneNum -1
		flagNum 201
		noun 21
	)
)

(instance tClub of Topic ; "The Club"
	(properties
		sceneNum 402
		flagNum 202
		noun 10
	)
)

(instance tMembers of Topic ; "Club Members"
	(properties
		sceneNum 404
		flagNum 206
		noun 11
	)
)

(instance tMembers2 of Topic ; "Club Members"
	(properties
		sceneNum 405
		flagNum 207
		readyFlagNum 206 ; "Club Members"
		noun 15
	)
)

(instance tFamily of Topic ; "Tell me about your family."
	(properties
		sceneNum 401
		flagNum 205
		noun 14
	)
)

(instance tFrom of Topic ; "Where are you from?"
	(properties
		sceneNum 398
		flagNum 204
		noun 12
	)
)

(instance tMunich of Topic ; "What brought you to Munich?"
	(properties
		sceneNum 399
		flagNum 208
		readyFlagNum 204 ; "Where are you from?"
		noun 13
	)
)

(instance tBasement of Topic ; "Club Basement"
	(properties
		sceneNum 406
		flagNum 209
		readyFlagNum 513
		noun 16
	)
)

(instance tPhil of Topic ; "Club Philosophy"
	(properties
		sceneNum 407
		flagNum 210
		readyFlagNum 209 ; "Club Basement"
		noun 17
	)
)

(instance tPhil2 of Topic ; "Club Philosophy"
	(properties
		sceneNum 408
		flagNum 211
		readyFlagNum 210 ; "Club Philosophy"
		noun 18
	)
)

(instance tPhil3 of Topic ; "Club Philosophy"
	(properties
		sceneNum 409
		flagNum 212
		readyFlagNum 211 ; "Club Philosophy"
		noun 19
	)
)

(instance tWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 410
		flagNum 213
		readyFlagNum 212 ; "Club Philosophy"
		noun 20
	)

	(method (yo param1)
		(return (and (super yo: param1) (or (and argc param1) (IsFlag 514))))
	)
)

