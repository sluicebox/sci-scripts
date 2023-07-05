;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use RotProp)
(use Feature)
(use Sound)
(use System)

(public
	figurineCloseUp 0
)

(local
	local0 = -1
)

(instance headFeat of Feature
	(properties)

	(method (doVerb theVerb)
		(figurineCloseUp doVerb: theVerb)
	)

	(method (cue)
		(if (IsFlag 114)
			(self nsLeft: 47 nsTop: 14 nsRight: 67 nsBottom: 27)
		else
			(self nsLeft: 47 nsTop: 24 nsRight: 67 nsBottom: 37)
		)
	)
)

(instance sayLine of Sound
	(properties
		number 5020
	)
)

(instance sfx of Sound
	(properties
		number 5021
	)
)

(instance figurineCloseUp of RotProp
	(properties
		noun 22
		modNum 1
		view 9820
		baseView 9820
	)

	(method (init param1 param2 param3 param4)
		(if (not (IsFlag 114))
			(self view: 9820 baseView: 9820)
		else
			(self view: 9860 baseView: 9860)
		)
		((= myFeat headFeat) init: cue:)
		(= local0 -1)
		(super init: param1 param2 param3 param4)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= local0 cel)
			(= local0 cel)
			(if (== view 9820)
				(if (OneOf cel 0 1 7 8 9 10 11 12 13 14 15)
					(myFeat setHotspot: 4 3) ; Do, Move
				else
					(myFeat setHotspot: 0)
				)
			)
			(if (== view 9860)
				(if (OneOf cel 1 2 3 4 5 6 7 8 9 10)
					(myFeat setHotspot: 4 3) ; Do, Move
				else
					(myFeat setHotspot: 0)
				)
			)
		)
	)

	(method (dispose)
		(headFeat dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(if (== theVerb 4) ; Do
			(if (not (IsFlag 114))
				(SetFlag 114)
				(= temp2 (gInventory at: 21)) ; invFigurine
				(= temp0 (temp2 view:))
				(= temp1 9861)
				(sfx play:)
				(temp2
					view: temp1
					hiliteView: temp1
					loliteView: (+ temp1 1)
					loop: 0
					cel: 0
					verb: 35
				)
				(self view: 9860 baseView: 9860)
				(myFeat cue:)
				(gInvCursor
					view: (temp2 loliteView:)
					loop: (temp2 loop:)
					cel: (temp2 cel:)
				)
				(if (not (IsFlag 111))
					(SetFlag 111)
					(sayLine play:)
				)
			else
				(ClearFlag 114)
				(= temp2 (gInventory at: 21)) ; invFigurine
				(= temp0 (temp2 view:))
				(= temp1 9821)
				(sfx play:)
				(temp2
					view: temp1
					hiliteView: temp1
					loliteView: (+ temp1 1)
					loop: 0
					cel: 0
					verb: 34
				)
				(self view: 9820 baseView: 9820)
				(myFeat cue:)
				(gInvCursor
					view: (temp2 loliteView:)
					loop: (temp2 loop:)
					cel: (temp2 cel:)
				)
			)
			(Lock rsVIEW temp0 0)
			(Lock rsVIEW (+ temp0 1) 0)
			(Lock rsVIEW temp1 1)
			(Lock rsVIEW (+ temp1 1) 1)
		else
			(super doVerb: theVerb)
		)
	)
)

