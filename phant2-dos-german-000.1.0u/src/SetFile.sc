;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64956)
(include sci.sh)
(use Str)
(use Jump)
(use File)

(class SetFile of File
	(properties
		tabCount 0
	)

	(method (readActor param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (Str new: 20))
		(= temp1 (Str new: 140))
		(= temp3 (Str with: { \t\0d\n}))
		(if
			(while (self readString: temp1 139)
				(temp1 getToken: temp3 temp2)
				(if (temp2 compare: {(instance})
					(break)
				)
			)
			(= temp0
				(if argc
					param1
				else
					(Prop new:)
				)
			)
			(temp1 getToken: temp3 temp2)
			(temp0 name: (KArray 9 temp2)) ; ArrayGetData
			(temp2 data: 0 dispose:)
			(= temp2 (Str new: 20))
			(self readString: temp1 139)
			(self readString: temp1 139)
			(temp1 getToken: temp3 temp2)
			(temp1 getToken: temp3 temp2)
			(temp0 view: (temp2 asInteger:))
			(self readString: temp1 139)
			(temp1 getToken: temp3 temp2)
			(temp1 getToken: temp3 temp2)
			(temp0 loop: (temp2 asInteger:))
			(self readString: temp1 139)
			(temp1 getToken: temp3 temp2)
			(temp1 getToken: temp3 temp2)
			(temp0 cel: (temp2 asInteger:))
			(self readString: temp1 139)
			(temp1 getToken: temp3 temp2)
			(temp1 getToken: temp3 temp2)
			(temp0 x: (temp2 asInteger:))
			(self readString: temp1 139)
			(temp1 getToken: temp3 temp2)
			(temp1 getToken: temp3 temp2)
			(temp0 y: (temp2 asInteger:))
			(self readString: temp1 139)
			(self readString: temp1 139)
		else
			(PrintDebug {Error: No actor found in file})
			(SetDebug self)
		)
		(temp2 dispose:)
		(temp1 dispose:)
		(temp3 dispose:)
	)

	(method (writeLine &tmp temp0)
		(self indent:)
		(= temp0 (Str format: &rest))
		(self writeString: temp0)
		(temp0 dispose:)
		(self writeWord: 2573)
	)

	(method (writeActor param1 param2 &tmp temp0)
		(= temp0
			(if (> argc 1)
				param2
			else
				(param1 getSuper:)
			)
		)
		(self writeLine: {(instance %s of %s} (param1 name:) (temp0 name:))
		(++ tabCount)
		(self writeLine: {(properties})
		(++ tabCount)
		(self writeLine: {view %d} (param1 view:))
		(self writeLine: {loop %d} (param1 loop:))
		(self writeLine: {cel %d} (param1 cel:))
		(self writeLine: {x %d} (param1 x:))
		(self writeLine: {y %d} (param1 y:))
		(-- tabCount)
		(self writeLine: {)})
		(-- tabCount)
		(self writeLine: {)})
	)

	(method (indent &tmp temp0)
		(= temp0 tabCount)
		(while temp0
			(if (& temp0 $0001)
				(-- temp0)
				(self writeByte: 9)
			else
				(-= temp0 2)
				(self writeWord: 2313)
			)
		)
	)
)

