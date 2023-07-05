;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use ExitButton)
(use Button)
(use LashInterface)
(use Motion)
(use Actor)

(public
	elementLeaderLashInterface 0
)

(instance elementLeaderLashInterface of LashInterface
	(properties)

	(method (addItems)
		(lashBackground init:)
		(elemA init:)
		(eAHold init:)
		(eAMove init:)
		(eACover init:)
		(eAClear init:)
		(eALeft init:)
		(eARight init:)
		(eADoor init:)
		(eAOpen init:)
		(eABreach init:)
		(eARam init:)
		(eAShotgun init:)
		(eAMirror init:)
		(eAInitiate init:)
		(eAFlashbang init:)
		(eAGas init:)
		(eAInPosition init:)
		(elemB init:)
		(eBHold init:)
		(eBMove init:)
		(eBCover init:)
		(eBClear init:)
		(eBLeft init:)
		(eBRight init:)
		(eBDoor init:)
		(eBOpen init:)
		(eBBreach init:)
		(eBRam init:)
		(eBShotgun init:)
		(eBMirror init:)
		(eBInitiate init:)
		(eBFlashbang init:)
		(eBGas init:)
		(eBInPosition init:)
		(inPosition init:)
		(compromised init:)
		(trailer init:)
		(suspect init:)
		(hostage init:)
		(inControl init:)
		(downButn init:)
		(comingOut init:)
		(transmitButn init:)
		(leftFlash init:)
		(rightFlash init:)
	)

	(method (transmit &tmp temp0 temp1)
		(= temp0 45)
		(= temp1 0)
		(while (< temp0 61)
			(if (proc4_11 temp0)
				(++ temp1)
			)
			(++ temp0)
		)
		(= global147 temp1)
		(= temp0 62)
		(= temp1 0)
		(while (< temp0 78)
			(if (proc4_11 temp0)
				(++ temp1)
			)
			(++ temp0)
		)
		(= global148 temp1)
		(= global149 size)
		(if (proc4_11 44)
			(-- global149)
		)
		(if (proc4_11 61)
			(-- global149)
		)
		(super transmit: &rest)
	)

	(method (flashDoits)
		(rightFlash doit:)
		(leftFlash doit:)
	)

	(method (buttonDoits)
		(suspect doit:)
		(hostage doit:)
	)
)

(instance lashBackground of View
	(properties
		view 18
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)
)

(instance elemA of LashButton
	(properties
		view 18
		loop 1
		enumType 44
		buttVerb 133
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 61))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (and (not param1) param2)
			(eAHold select: 0 1)
			(eAMove select: 0 1)
			(eACover select: 0 1)
			(eAClear select: 0 1)
			(eALeft select: 0 1)
			(eARight select: 0 1)
			(eADoor select: 0 1)
			(eAOpen select: 0 1)
			(eABreach select: 0 1)
			(eARam select: 0 1)
			(eAShotgun select: 0 1)
			(eAMirror select: 0 1)
			(eAInitiate select: 0 1)
			(eAFlashbang select: 0 1)
			(eAGas select: 0 1)
			(eAInPosition select: 0 1)
		)
		(super select: param1 param2 &rest)
	)
)

(instance eAHold of LashButton
	(properties
		view 18
		loop 3
		enumType 45
		buttVerb 94
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 61))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAMove of LashButton
	(properties
		view 18
		loop 4
		enumType 46
		buttVerb 62
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 61))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eACover of LashButton
	(properties
		view 18
		loop 5
		enumType 47
		buttVerb 95
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 61))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAClear of LashButton
	(properties
		view 18
		loop 6
		enumType 48
		buttVerb 98
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 61))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eALeft of LashButton
	(properties
		view 18
		loop 7
		enumType 49
		buttVerb 134
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 84))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eARight of LashButton
	(properties
		view 18
		loop 8
		enumType 50
		buttVerb 135
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 84))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eADoor of LashButton
	(properties
		view 18
		loop 9
		enumType 51
		buttVerb 88
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 84))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAOpen of LashButton
	(properties
		view 18
		loop 10
		enumType 52
		buttVerb 136
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 84))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eABreach of LashButton
	(properties
		view 18
		loop 11
		enumType 53
		buttVerb 137
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 84))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eARam of LashButton
	(properties
		view 18
		loop 12
		enumType 54
		buttVerb 66
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 84))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAShotgun of LashButton
	(properties
		view 18
		loop 13
		enumType 55
		buttVerb 8
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAMirror of LashButton
	(properties
		view 18
		loop 14
		enumType 56
		buttVerb 40
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAInitiate of LashButton
	(properties
		view 18
		loop 15
		enumType 57
		buttVerb 59
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAFlashbang of LashButton
	(properties
		view 18
		loop 16
		enumType 58
		buttVerb 16
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAGas of LashButton
	(properties
		view 18
		loop 17
		enumType 59
		buttVerb 67
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eAInPosition of LashButton
	(properties
		view 18
		loop 18
		enumType 60
		buttVerb 77
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemA select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance elemB of LashButton
	(properties
		view 18
		loop 2
		enumType 61
		buttVerb 138
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 137))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (and (not param1) param2)
			(eBHold select: 0 1)
			(eBMove select: 0 1)
			(eBCover select: 0 1)
			(eBClear select: 0 1)
			(eBLeft select: 0 1)
			(eBRight select: 0 1)
			(eBDoor select: 0 1)
			(eBOpen select: 0 1)
			(eBBreach select: 0 1)
			(eBRam select: 0 1)
			(eBShotgun select: 0 1)
			(eBMirror select: 0 1)
			(eBInitiate select: 0 1)
			(eBFlashbang select: 0 1)
			(eBGas select: 0 1)
			(eBInPosition select: 0 1)
		)
		(super select: param1 param2 &rest)
	)
)

(instance eBHold of LashButton
	(properties
		view 18
		loop 3
		enumType 62
		buttVerb 94
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 137))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBMove of LashButton
	(properties
		view 18
		loop 4
		enumType 63
		buttVerb 62
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 137))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBCover of LashButton
	(properties
		view 18
		loop 5
		enumType 64
		buttVerb 95
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 137))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBClear of LashButton
	(properties
		view 18
		loop 6
		enumType 65
		buttVerb 98
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 137))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBLeft of LashButton
	(properties
		view 18
		loop 7
		enumType 66
		buttVerb 134
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 159))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBRight of LashButton
	(properties
		view 18
		loop 8
		enumType 67
		buttVerb 135
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 159))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBDoor of LashButton
	(properties
		view 18
		loop 9
		enumType 68
		buttVerb 88
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 159))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBOpen of LashButton
	(properties
		view 18
		loop 10
		enumType 69
		buttVerb 136
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 159))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBBreach of LashButton
	(properties
		view 18
		loop 11
		enumType 70
		buttVerb 137
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 159))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBRam of LashButton
	(properties
		view 18
		loop 12
		enumType 71
		buttVerb 66
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 159))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBShotgun of LashButton
	(properties
		view 18
		loop 13
		enumType 72
		buttVerb 8
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 181))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBMirror of LashButton
	(properties
		view 18
		loop 14
		enumType 73
		buttVerb 40
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 181))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBInitiate of LashButton
	(properties
		view 18
		loop 15
		enumType 74
		buttVerb 59
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 181))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBFlashbang of LashButton
	(properties
		view 18
		loop 16
		enumType 75
		buttVerb 16
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 181))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBGas of LashButton
	(properties
		view 18
		loop 17
		enumType 76
		buttVerb 67
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 181))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance eBInPosition of LashButton
	(properties
		view 18
		loop 18
		enumType 77
		buttVerb 77
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 181))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(elemB select: 1 1)
		)
		(super select: param1 &rest)
	)
)

(instance inPosition of LashButton
	(properties
		view 18
		loop 18
		enumType 43
		buttVerb 77
	)

	(method (init)
		(= x (+ (lashBackground x:) 119))
		(= y (+ (lashBackground y:) 214))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(compromised select: 0 1)
			(trailer select: 0 1)
		)
		(super select: param1 &rest)
	)
)

(instance compromised of LashButton
	(properties
		view 18
		loop 19
		enumType 18
		buttVerb 87
	)

	(method (init)
		(= x (+ (lashBackground x:) 195))
		(= y (+ (lashBackground y:) 214))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(inPosition select: 0 1)
			(trailer select: 0 1)
		)
		(super select: param1 &rest)
	)
)

(instance trailer of LashButton
	(properties
		view 18
		loop 20
		enumType 20
		buttVerb 101
	)

	(method (init)
		(= x (+ (lashBackground x:) 271))
		(= y (+ (lashBackground y:) 214))
		(super init: &rest)
	)

	(method (select param1)
		(if (and argc param1)
			(inPosition select: 0 1)
			(compromised select: 0 1)
		)
		(super select: param1 &rest)
	)
)

(instance suspect of LashButton
	(properties
		view 18
		loop 21
		enumType 21
		buttVerb 89
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 247))
		(super init: &rest)
	)

	(method (select param1)
		(if cycler
			(suspect setCycle: 0 cel: 0)
			(self setCycle: 0 cel: 0)
			(UpdateScreenItem self)
			(UpdateScreenItem suspect)
		)
		(cond
			((or (not argc) param1)
				(hostage select: 0 1 1)
			)
			(
				(and
					(not (> argc 2))
					(or (proc4_11 42) (proc4_11 10) (proc4_11 23))
				)
				(self setCycle: Fwd)
				(hostage setCycle: Fwd)
			)
		)
		(super select: param1 &rest)
	)
)

(instance hostage of LashButton
	(properties
		view 18
		loop 22
		enumType 22
		buttVerb 90
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 247))
		(super init: &rest)
	)

	(method (select param1)
		(if cycler
			(suspect setCycle: 0 cel: 0)
			(self setCycle: 0 cel: 0)
			(UpdateScreenItem self)
			(UpdateScreenItem suspect)
		)
		(cond
			((or (not argc) param1)
				(suspect select: 0 1 1)
			)
			(
				(and
					(not (> argc 2))
					(or (proc4_11 42) (proc4_11 10) (proc4_11 23))
				)
				(self setCycle: Fwd)
				(suspect setCycle: Fwd)
			)
		)
		(super select: param1 &rest)
	)
)

(instance inControl of LashButton
	(properties
		view 18
		loop 23
		enumType 42
		buttVerb 139
	)

	(method (init)
		(= x (+ (lashBackground x:) 119))
		(= y (+ (lashBackground y:) 268))
		(super init: &rest)
	)

	(method (select param1)
		(if (or (suspect cycler:) (hostage cycler:))
			(suspect setCycle: 0 cel: 0)
			(hostage setCycle: 0 cel: 0)
			(UpdateScreenItem suspect)
			(UpdateScreenItem hostage)
		)
		(if (or (not argc) param1)
			(downButn select: 0 1)
			(comingOut select: 0 1)
			(if (and (not (proc4_11 21)) (not (proc4_11 22)))
				(suspect setCycle: Fwd)
				(hostage setCycle: Fwd)
			)
		)
		(super select: param1 &rest)
	)
)

(instance downButn of LashButton
	(properties
		view 18
		loop 24
		enumType 10
		buttVerb 140
	)

	(method (init)
		(= x (+ (lashBackground x:) 195))
		(= y (+ (lashBackground y:) 268))
		(super init: &rest)
	)

	(method (select param1)
		(if (or (suspect cycler:) (hostage cycler:))
			(suspect setCycle: 0 cel: 0)
			(hostage setCycle: 0 cel: 0)
			(UpdateScreenItem suspect)
			(UpdateScreenItem hostage)
		)
		(if (or (not argc) param1)
			(inControl select: 0 1)
			(comingOut select: 0 1)
			(if (and (not (proc4_11 21)) (not (proc4_11 22)))
				(suspect setCycle: Fwd)
				(hostage setCycle: Fwd)
			)
		)
		(super select: param1 &rest)
	)
)

(instance comingOut of LashButton
	(properties
		view 18
		loop 25
		enumType 23
		buttVerb 141
	)

	(method (init)
		(= x (+ (lashBackground x:) 271))
		(= y (+ (lashBackground y:) 268))
		(super init: &rest)
	)

	(method (select param1)
		(if (or (suspect cycler:) (hostage cycler:))
			(suspect setCycle: 0 cel: 0)
			(hostage setCycle: 0 cel: 0)
			(UpdateScreenItem suspect)
			(UpdateScreenItem hostage)
		)
		(if (or (not argc) param1)
			(downButn select: 0 1)
			(inControl select: 0 1)
			(if (and (not (proc4_11 21)) (not (proc4_11 22)))
				(suspect setCycle: Fwd)
				(hostage setCycle: Fwd)
			)
		)
		(super select: param1 &rest)
	)
)

(instance transmitButn of Button
	(properties
		view 18
		loop 26
	)

	(method (init)
		(= x (+ (lashBackground x:) 195))
		(= y (+ (lashBackground y:) 294))
		(= active 1)
		(super init: &rest)
	)

	(method (doVerb)
		(if (or (suspect cycler:) (hostage cycler:))
			(inControl select: 0 1)
			(downButn select: 0 1)
			(comingOut select: 0 1)
			(suspect setCycle: 0 cel: 0)
			(hostage setCycle: 0 cel: 0)
			(UpdateScreenItem suspect)
			(UpdateScreenItem hostage)
		)
		(leftFlash setCycle: Fwd)
		(rightFlash setCycle: Fwd)
		(self setActive: 0)
		(gLashInterface transmit:)
	)
)

(instance leftFlash of Prop
	(properties
		view 18
		loop 27
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

(instance rightFlash of Prop
	(properties
		view 18
		loop 28
	)

	(method (init)
		(= x (+ (lashBackground x:) 446))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

