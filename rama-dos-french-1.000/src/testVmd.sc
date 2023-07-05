;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Location)
(use VMDMovie)
(use Str)
(use Print)
(use File)
(use System)

(public
	testVmd 0
)

(instance testVmd of Location
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= temp2 0)
		(= temp1 0)
		(super init: &rest)
		(cond
			((!= -1 (CD 0 1)) ; Check
				(= temp1 (Str newWith: 128 gCurSaveDir))
				(temp1 cat: (vmd_dir name:))
				((= temp2 (File new:)) name: (KArray 8 (temp1 data:))) ; ArrayDup
				(= temp0 (temp2 open: 1))
			)
			((not (= temp0 (vmd_dir open: 1)))
				(= temp1 (Str newWith: 128 {..\src\5c}))
				(temp1 cat: (vmd_dir name:))
				((= temp2 (File new:)) name: (KArray 8 (temp1 data:))) ; ArrayDup
				(= temp0 (temp2 open: 1))
			)
		)
		(if temp0
			(if temp1
				(vmd_dir name: (KArray 8 (temp1 data:))) ; ArrayDup
				(temp1 dispose:)
			)
			(if temp2
				(KArray 4 (temp2 name:)) ; ArrayFree
				(temp2 close:)
			)
			(c__results_txt open: 2 close:)
			(self setScript: testVMDScript self)
		else
			(if temp1
				(temp1 dispose:)
			)
			(if temp2
				(KArray 4 (temp2 name:)) ; ArrayFree
				(temp2 close:)
			)
			(Prints {Missing Data File})
			(gGame quitGame:)
		)
	)

	(method (cue)
		(gGame quitGame:)
	)
)

(instance vmd_dir of File
	(properties
		name {vmd.dir}
	)
)

(instance c__results_txt of File
	(properties
		name {c:\results.txt}
	)
)

(instance testVMDScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(switch (= state newState)
			(0
				(= temp0 (Str newWith: 132))
				(vmd_dir readString: temp0 132)
				(if (not (temp0 weigh: {Disk 2}))
					(gGame getDisc: 2)
					(temp0 dispose:)
					(= temp0 (Str newWith: 132))
					(vmd_dir readString: temp0 132)
				)
				(if (not (temp0 weigh: {Disk 3}))
					(gGame getDisc: 3)
					(temp0 dispose:)
					(= temp0 (Str newWith: 132))
					(vmd_dir readString: temp0 132)
				)
				(global123 displayOptionsText: (temp0 data:))
				(= temp5 (Str new:))
				(= temp6 (Str newWith: {.}))
				(temp0 getToken: temp6 temp5)
				(if (not (temp5 asInteger:))
					(self dispose:)
				else
					((= temp1 (VMDMovie new:))
						movieName: (temp5 asInteger:)
						play:
					)
				)
				(while ((= temp7 (Event new: 12)) type:)
					(temp7 dispose:)
				)
				(temp7 dispose:)
				(= temp3
					(switch
						((Print new:)
							addTitle: {VMD playback test}
							mode: 1
							addText: {Playback problems?} 0 15
							addButton: 1 {Plays fine} 0 30
							addButton: 2 {Close, but choppy} 0 45
							addButton: 3 {Choppy} 0 60
							addButton: 4 {Really bad} 0 75
							addButton: 5 {Other} 0 90
							init:
						)
						(1
							(Str with: {Fine})
						)
						(2
							(Str with: {Close})
						)
						(3
							(Str with: {Choppy})
						)
						(4
							(Str with: {Bad})
						)
						(5
							(Str with: {Other})
						)
						(else
							(Str with: {Skipped})
						)
					)
				)
				(= temp2
					(switch
						((Print new:)
							addTitle: {VMD playback test}
							mode: 1
							addText: {Audio problems?} 0 15
							addButton: 1 {Plays fine} 0 30
							addButton: 2 {Stutters} 0 45
							addButton: 3 {Loops} 0 60
							addButton: 4 {Static} 0 75
							addButton: 5 {Needs Audio} 0 90
							addButton: 6 {Other} 0 105
							init:
						)
						(1
							(Str with: {Fine})
						)
						(2
							(Str with: {Stutters})
						)
						(3
							(Str with: {Loops})
						)
						(4
							(Str with: {Static})
						)
						(5
							(Str with: {Needs})
						)
						(6
							(Str with: {Other})
						)
						(else
							(Str with: {Skipped})
						)
					)
				)
				(= temp4
					(Str
						format:
							{VMD Name %d,\t VIDEO %s,\t AUDIO %s\r\n}
							(temp5 asInteger:)
							(temp3 data:)
							(temp2 data:)
					)
				)
				(c__results_txt open: 0 writeString: (temp4 data:) close:)
				(temp4 dispose:)
				(temp2 dispose:)
				(temp3 dispose:)
				(temp6 dispose:)
				(temp0 dispose:)
				(temp1 dispose:)
				(temp5 dispose:)
				(= cycles 1)
			)
			((self init: &rest))
		)
	)
)

