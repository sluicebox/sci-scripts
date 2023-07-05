;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6109)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Actor)

(public
	securityScreen 0
)

(instance securityScreen of CloseupLocation
	(properties
		noun 57
	)

	(method (init)
		(= picture
			(switch global234
				(2 6134)
				(3 6163)
				(4 6164)
				(5 6165)
				(7 6167)
				(else 6134)
			)
		)
		(super init: picture)
		(self edgeE: 0)
		(self edgeW: 0)
		(if (== global233 2)
			(cameraShot init: global117)
		)
	)
)

(instance cameraShot of View
	(properties)

	(method (init)
		(self setPri: 0 setLoop: 0 setCel: 0)
		(switch global234
			(2
				(self
					view:
						(switch [global235 (- global234 1)]
							(0 6103)
							(1 6104)
							(2 6105)
							(else 6106)
						)
					posn: -89 291
				)
			)
			(3
				(self view: 6113 posn: 72 291)
			)
			(4
				(self view: 6107 posn: 42 1)
			)
			(5
				(self
					view:
						(cond
							(
								(and
									(not (IsFlag 144))
									(not (IsFlag 145))
								)
								6108
							)
							((and (IsFlag 144) (not (IsFlag 145))) 6109)
							((and (not (IsFlag 144)) (IsFlag 145)) 6110)
							(else 6111)
						)
					posn: -16 291
				)
			)
			(7
				(self view: 6112 posn: -8 291)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)
)

