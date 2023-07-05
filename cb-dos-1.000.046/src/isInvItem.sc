;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 413)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	isInvItem 0
)

(local
	[local0 11] = [2 64 512 8 16 1 4 1024 32 256 128]
	[local11 22] = [413 0 413 1 413 2 413 3 413 4 413 5 413 6 413 7 413 8 413 9 413 10]
	[local33 11] = ['/celie' '/attorney' '/colonel' '/ethel' '/fifi' '/gertie' '/actress' '/butler' '/lil' '/rudolph' '/c']
	[local44 11] = ['/*<celie' '/*<attorney' '/*<colonel' '/*<ethel' '/*<fifi' '/*<gertie' '/*<actress' '/*<butler' '/*<lil' '/*<rudolph' '/*<c']
	[local55 11] = ['//celie' '//attorney' '//colonel' '//ethel' '//fifi' '//gertie' '//actress' '//butler' '//lil' '//rudolph' '//c']
	[local66 24] = ['//necklace' '//monocle' '//lantern' '//can' '//pin' '//key<skeleton' '//poker' '//crowbar' '//butt,butt' '//record' '//notebook,pencil' '//cracker,box' '//bone' '//handle,valve' '//bullet' '//derringer' '//match' '//carrot' '//key' '//diary' '//control' '//cane' '//diamond' '//handkerchief']
	[local90 24] = ['<necklace' '<monocle' '<lantern' '<can' '<pin' '<key<skeleton' '<poker' '<crowbar' '<butt,butt' '<record' '<notebook,pencil' '<cracker,box' '<bone' '<handle,valve' '<bullet' '<derringer' '<match' '<carrot' '<key' '<diary' '<control' '<cane' '<diamond' '<handkerchief']
	local114
)

(procedure (localproc_0 param1 &tmp temp0 temp1 [temp2 50])
	(for ((= temp0 0)) (< temp0 11) ((++ temp0))
		(if (and (Said 'tell//*<about>') (Said [local55 temp0]))
			(++ local114)
			(param1 claimed: 0)
		)
		(if
			(and
				(or
					(and
						(Said 'show,give,flirt>')
						(or (Said [local44 temp0]) (Said [local55 temp0]))
					)
					(Said [local33 temp0])
				)
				(not (& (| global195 global208) (= temp1 [local0 temp0])))
			)
			(*= temp0 2)
			(if
				(or
					(and (== temp1 1) (& gCorpseFlags $0001)) ; Gertie
					(and (== temp1 128) (& gCorpseFlags $0002)) ; Wilbur
					(and (== temp1 4) (& gCorpseFlags $0004)) ; Gloria
					(and (== temp1 8) (& gCorpseFlags $0008)) ; Ethel
					(and (or (== temp1 16) (== temp1 1024)) (& gCorpseFlags $0010)) ; Jeeves & Fifi
					(and (== temp1 64) (& gCorpseFlags $0020)) ; Clarence
					(and (== temp1 32) (& gCorpseFlags $0040)) ; Lillian
				)
				(Print
					(Format @temp2 413 13 [local11 temp0] [local11 (++ temp0)]) ; "You must be joking! %s is dead."
				)
			else
				(Print
					(Format @temp2 413 14 [local11 temp0] [local11 (++ temp0)]) ; "You must be confused. %s is not here."
				)
			)
			(return 1)
		)
	)
	(param1 claimed: 0)
	(return 0)
)

(instance isInvItem of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(= global219 (= global224 0))
		(= global171 -1)
		(cond
			((or (Said '/dijon') (Said '//dijon'))
				(Print 413 11) ; "Please don't be so formal. Just use first names."
			)
			(
				(and
					(Said
						'ask,tell,show,give,talk,look,get,hit,kill,kiss,embrace,flirt>'
					)
					(localproc_0 event)
				))
			((or (Said 'look//*<for') (Said 'find'))
				(Print 413 12) ; "You will have to do that yourself."
			)
			((= global219 (gInventory saidMe:))
				(= temp0 (gInventory first:))
				(for
					((= global171 0))
					(!= global219 (NodeValue temp0))
					((++ global171))
					
					(= temp0 (gInventory next: temp0))
				)
				(= global171 (gInventory indexOf: global219))
				(event claimed: 0)
			)
			(else
				(for ((= global171 0)) (<= global171 23) ((++ global171))
					(if
						(or
							(Said [local66 global171])
							(Said [local90 global171])
						)
						(= global219 (gInventory at: global171))
						(event claimed: 0)
						(break)
					)
				)
			)
		)
		(if (and global219 (== (global219 owner:) gEgo))
			(= global224 1)
		)
		(if (== local114 1)
			(SetFlag 51)
		else
			(ClearFlag 51)
		)
		(client setScript: 0)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 413)
	)
)

