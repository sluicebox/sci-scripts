;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45951)
(include sci.sh)
(use Main)
(use Str)
(use Timer)
(use File)
(use System)

(public
	chap7Timer 0
	checkInv 1
	chase_dat 2
	proc45951_3 3
	proc45951_4 4
	proc45951_5 5
	proc45951_6 6
)

(procedure (proc45951_3 &tmp temp0)
	(= temp0 (Str with: {00}))
	((ScriptID 45951 2) read: temp0 2) ; chase_dat
	(= global179 (temp0 asInteger:))
	(temp0 dispose:)
)

(procedure (proc45951_4 &tmp temp0 temp1 temp2)
	(= temp1 (Str new: 2))
	((ScriptID 45951 2) seek: -2 2) ; chase_dat
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= global179 0)
		(while (!= global179 99)
			((ScriptID 45951 2) read: temp1 2) ; chase_dat
			(= global179 (temp1 asInteger:))
			((ScriptID 45951 2) seek: -4 1) ; chase_dat
		)
	)
	((ScriptID 45951 2) seek: 6 1) ; chase_dat
	(proc45951_3)
	(= gPrevRoomNum
		(switch global179
			(1 45950)
			(2 46030)
			(3 46040)
			(4 46050)
			(5 46100)
			(6 46290)
			(7 46320)
			(8 46340)
			(9 46570)
			(10 46620)
			(11 46630)
			(12 40100)
			(13 46720)
			(14 46770)
			(15 46790)
			(16 46910)
			(17 46980)
			(18 47020)
			(19 47180)
			(20 46780)
		)
	)
	(while (!= global179 99)
		((ScriptID 45951 2) read: temp1 2) ; chase_dat
		(= global179 (temp1 asInteger:))
	)
	((ScriptID 45951 2) seek: 2 1) ; chase_dat
	(= temp2 (Str newWith: 2 {98}))
	((ScriptID 45951 2) writeString: temp2 close:) ; chase_dat
	(temp2 dispose:)
	((ScriptID 45951 2) open: 1) ; chase_dat
	(= global179 0)
	(= temp1 (Str newWith: 2 {}))
	(KString 5 (temp1 data:) 0 2 0) ; StrFill
	(tmp_dat open: 2)
	(while (!= global179 98)
		((ScriptID 45951 2) read: temp1 2) ; chase_dat
		(if (!= (= global179 (temp1 asInteger:)) 98)
			(tmp_dat writeString: temp1)
		)
	)
	((ScriptID 45951 2) close: delete:) ; chase_dat
	(tmp_dat close:)
	(FileIO fiRENAME (tmp_dat name:) ((ScriptID 45951 2) name:)) ; chase_dat
	((ScriptID 45951 2) open: 0) ; chase_dat
	(temp1 dispose:)
)

(procedure (proc45951_5 &tmp temp0 temp1 temp2 [temp3 2])
	(gGDacSound stop:)
	((ScriptID 45951 2) close:) ; chase_dat
	(= temp0 (Str newWith: 128 {}))
	(KString 5 (temp0 data:) 0 128 0) ; StrFill
	(temp0 cat: {chase.dat})
	(= temp1 (Str newWith: 128 {}))
	(KString 5 (temp1 data:) 0 128 0) ; StrFill
	(= temp2 (Str new:))
	(temp1 cat: ((temp2 format: {chasedun.%d} global124) data:))
	(FileIO fiRENAME (temp0 data:) (temp1 data:))
	(temp0 dispose:)
	(temp1 dispose:)
	(temp2 dispose:)
	(gGame save:)
)

(procedure (proc45951_6 &tmp temp0 temp1 temp2)
	(= temp0 (Str newWith: 128 {}))
	(KString 5 (temp0 data:) 0 128 0) ; StrFill
	(= temp1 (Str new:))
	(temp0 cat: ((temp1 format: {chasedun.%d} global124) data:))
	(= temp2 (Str newWith: 128 {}))
	(KString 5 (temp2 data:) 0 128 0) ; StrFill
	(temp2 cat: {chase.dat})
	(FileIO fiRENAME (temp0 data:) (temp2 data:))
	(temp0 dispose:)
	(temp1 dispose:)
	(temp2 dispose:)
)

(instance chase_dat of File
	(properties
		name {chase.dat}
	)

	(method (open &tmp temp0)
		(= temp0 (Str newWith: 128 {}))
		(KString 5 (temp0 data:) 0 128 0) ; StrFill
		(temp0 cat: {chase.dat})
		(self name: (KString 8 (temp0 data:))) ; StrDup
		(temp0 dispose:)
		(super open: &rest)
	)
)

(instance tmp_dat of File
	(properties
		name {tmp.dat}
	)

	(method (open &tmp temp0)
		(= temp0 (Str newWith: 128 {}))
		(KString 5 (temp0 data:) 0 128 0) ; StrFill
		(temp0 cat: {tmp.dat})
		(self name: (KString 8 (temp0 data:))) ; StrDup
		(temp0 dispose:)
		(super open: &rest)
	)
)

(instance chap7Timer of Timer
	(properties)
)

(instance checkInv of Code
	(properties)

	(method (doit param1)
		(if
			(and
				(or (gEgo has: 14) (gEgo has: 15)) ; invCrucifix, invBeads
				(or (gEgo has: 19) (gEgo has: 10)) ; invCutter, invBrooch
				(gEgo has: 17) ; invXmasOrn
				(gEgo has: 16) ; invSpellBook
			)
			(SetFlag 143)
		)
		(if argc
			(param1 cue:)
		)
	)
)

