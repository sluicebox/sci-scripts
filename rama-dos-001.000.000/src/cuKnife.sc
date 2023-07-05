;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1200)
(include sci.sh)
(use Main)
(use InvInitialize)
(use SpinProp)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	cuKnife 0
)

(local
	[local0 15] = [-22 -18 -9 -5 -1 -3 -5 -7 -15 -23 -31 -35 -37 -37 -31]
	[local15 15] = [-19 -19 -21 -24 -26 -28 -34 -33 -36 -35 -33 -30 -26 -23 -22]
	local30
)

(procedure (localproc_0 param1 param2)
	(if (not argc)
		(return)
	)
	(switch param1
		(0
			(param2 cel: 0)
			(param2 verb: 34)
			(param2 setHotspot:)
		)
		(1
			(param2 cel: 2)
			(param2 verb: 16)
			(param2 setHotspot:)
		)
		(2
			(param2 cel: 8)
			(param2 verb: 66)
			(param2 setHotspot:)
		)
		(3
			(param2 cel: 4)
			(param2 verb: 136)
			(param2 setHotspot: 131 129 119 142)
			(cuKnife setHotspot: 131 129 119 142)
			(cuKnife view: 20292)
		)
		(4
			(param2 cel: 6)
			(param2 verb: 35)
			(param2 setHotspot:)
		)
		(5
			(param2 cel: 12)
			(param2 verb: 139)
			(param2 setHotspot:)
			(cuKnife setHotspot: 2 11)
			(cuKnife view: 20940)
		)
		(6
			(param2 cel: 14)
			(param2 verb: 140)
			(param2 setHotspot:)
			(cuKnife setHotspot: 11 2)
			(cuKnife view: 20939)
		)
		(7
			(param2 cel: 16)
			(param2 verb: 141)
			(param2 setHotspot:)
			(cuKnife setHotspot: 2 11)
			(cuKnife view: 20941)
		)
		(8
			(param2 cel: 10)
			(param2 verb: 140)
			(param2 setHotspot:)
			(cuKnife setHotspot: 2 11)
			(cuKnife view: 20938)
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 1)
	(switch param1
		(131
			(if
				(or
					(== (cuKnife view:) 20941)
					(== (cuKnife view:) 20939)
					(== (cuKnife view:) 20938)
				)
				(= temp0 0)
			)
		)
		(129
			(if
				(or
					(== (cuKnife view:) 20940)
					(== (cuKnife view:) 20939)
					(== (cuKnife view:) 20938)
				)
				(= temp0 0)
			)
		)
		(119
			(if
				(or
					(== (cuKnife view:) 20940)
					(== (cuKnife view:) 20941)
					(== (cuKnife view:) 20938)
				)
				(= temp0 0)
			)
		)
		(142
			(if
				(or
					(== (cuKnife view:) 20940)
					(== (cuKnife view:) 20939)
					(== (cuKnife view:) 20941)
				)
				(= temp0 0)
			)
		)
	)
	(return temp0)
)

(instance cuKnife of SpinProp
	(properties)

	(method (init)
		(= local30 cursor)
		(= cursor 0)
		(switch (myInvObj cel:)
			(0
				(= view 20289)
			)
			(2
				(= view 20291)
			)
			(8
				(= view 20293)
			)
			(4
				(= view 20292)
			)
			(6
				(= view 20290)
			)
			(12
				(= view 20940)
			)
			(14
				(= view 20939)
			)
			(16
				(= view 20941)
			)
			(10
				(= view 20938)
			)
		)
		(Load rsAUDIO 20011)
		(super init: &rest)
		(switch (myInvObj cel:)
			(4
				(self setHotspot: 131 129 119 142)
			)
			(12
				(self setHotspot: 2 11)
			)
			(14
				(self setHotspot: 2 11)
			)
			(16
				(self setHotspot: 2 11)
			)
			(10
				(self setHotspot: 2 11)
			)
		)
		(self setPri: 200)
		(itemFeat
			plane: (self plane:)
			init:
				(+ (self x:) [local0 cel])
				(+ (self y:) [local15 cel])
				(+ (self x:) [local0 cel] 23)
				(+ (self y:) [local15 cel] 17)
		)
	)

	(method (doit)
		(if (!= oldCel cel)
			(= oldCel cel)
			(itemFeat
				nsLeft: (+ (self x:) [local0 cel])
				nsTop: (+ (self y:) [local15 cel])
				nsRight: (+ (self x:) [local0 cel] 23)
				nsBottom: (+ (self y:) [local15 cel] 17)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (localproc_1 theVerb))
			(return)
		)
		(switch theVerb
			(1
				(cond
					((OneOf (gTheCursor verb:) 139 140 141)
						(gTheCursor setTempCursor: handCursor 2)
					)
					(
						(and
							(OneOf view 20940 20939 20941 20938)
							(gTheCursor isInvCursor:)
						)
						0
					)
					((gTheCursor isInvCursor:)
						(super doVerb: theVerb &rest)
					)
					(else
						(gTheCursor setTempCursor: handCursor 2)
					)
				)
			)
			(2
				(self deleteHotspot:)
				(switch view
					(20289
						(butClick play:)
						(= view 20290)
						(localproc_0 4 myInvObj)
					)
					(20290
						(butClick play:)
						(= view 20291)
						(localproc_0 1 myInvObj)
					)
					(20291
						(butClick play:)
						(= view 20293)
						(localproc_0 2 myInvObj)
					)
					(20293
						(butClick play:)
						(= view 20292)
						(localproc_0 3 myInvObj)
					)
					(20292
						(butClick play:)
						(= view 20289)
						(localproc_0 0 myInvObj)
						(self deleteHotspot:)
					)
					(20940
						(itemFeat setHotspot: 2 11)
						(localproc_0 3 myInvObj)
						(gTheCursor setInvCursor: (proc70_6 5) hilite:)
					)
					(20939
						(itemFeat setHotspot: 2 11)
						(localproc_0 3 myInvObj)
						(gTheCursor setInvCursor: (proc70_6 115) hilite:)
					)
					(20941
						(itemFeat setHotspot: 2 11)
						(localproc_0 3 myInvObj)
						(gTheCursor setInvCursor: (proc70_6 123) hilite:)
					)
					(20938
						(itemFeat setHotspot: 2 11)
						(localproc_0 3 myInvObj)
						(cond
							((== (proc70_9 41) 45)
								(gTheCursor setInvCursor: (proc70_6 41) hilite:)
							)
							((== (proc70_9 42) 45)
								(gTheCursor setInvCursor: (proc70_6 42) hilite:)
							)
							((== (proc70_9 43) 45)
								(gTheCursor setInvCursor: (proc70_6 43) hilite:)
							)
						)
					)
				)
			)
			(131
				(itemFeat deleteHotspot:)
				(proc70_3)
				(self view: 20940)
				(localproc_0 5 myInvObj)
				(proc70_10 5 45)
				(gTheCursor setInvCursor: (global125 myInvObj:) 1)
			)
			(129
				(itemFeat deleteHotspot:)
				(proc70_3)
				(self view: 20941)
				(localproc_0 7 myInvObj)
				(proc70_10 123 45)
				(gTheCursor setInvCursor: (global125 myInvObj:) 1)
			)
			(119
				(itemFeat deleteHotspot:)
				(proc70_3)
				(localproc_0 6 myInvObj)
				(proc70_10 115 45)
				(gTheCursor setInvCursor: (global125 myInvObj:) 1)
			)
			(142
				(if (== cel 4)
					(itemFeat deleteHotspot:)
					(= temp0 (gTheCursor invItem:))
					(proc70_3)
					(localproc_0 8 myInvObj)
					(gTheCursor setInvCursor: (global125 myInvObj:) 1)
					(proc70_10 (proc70_7 temp0) 45)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(self deleteHotspot:)
		(itemFeat dispose:)
		(super dispose: &rest)
	)
)

(instance handCursor of View
	(properties
		cel 10
		view 600
	)
)

(instance itemFeat of Feature
	(properties)

	(method (init param1 param2 param3 param4)
		(if argc
			(self nsLeft: param1 nsTop: param2 nsRight: param3 nsBottom: param4)
		)
		(super init: &rest)
		(self setHotspot: 2 11)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cuKnife doVerb: theVerb &rest)
			)
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)
)

(instance butClick of Sound
	(properties
		number 20011
		flags 5
	)
)

