;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 896)
(include sci.sh)
(use Main)
(use n814)
(use LoadMany)
(use System)

(public
	proc896_0 0
)

(procedure (proc896_0 param1 &tmp temp0 temp1 temp2 [temp3 20])
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(if (OneOf param1 2 9 200 299 602 601)
		(gTheIconBar disable:)
	else
		(gTheIconBar enable:)
	)
	(&= global191 $00ff)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gMouseDownHandler release:)
	(gKeyDownHandler release:)
	(gDirectionHandler release:)
	(if (== param1 600)
		(ClearFlag 328)
		(FixTime 12 0)
		(= gNight 0)
		(= global40 0)
	)
	(if (and (not global279) (!= global252 73))
		(= global251 0)
	)
	(for ((= temp0 0)) (< temp0 40) ((++ temp0))
		((gInventory at: temp0) amtDropped: 0)
	)
	((ScriptID 206 2) release: init:) ; dropInv
	(LoadMany
		0
		988
		991
		972
		800
		940
		550
		551
		205
		7
		8
		813
		104
		105
		106
		100
		803
		812
		969
		971
		970
		121
		120
	)
	(DisposeScript 896)
)

(instance dumpMeMaybe of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #dumpIt)
			((ScriptID 206 2) delete: param1) ; dropInv
		)
	)
)

